/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Profile;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProfileDAO {

    private Connection connection;

    public ProfileDAO() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }

    public void addProfile(Profile profile) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into userprofile(username, icno, firstname) values (?,?,?)");

            preparedStatement.setString(1, profile.getUsername());
            preparedStatement.setString(2, profile.getIcno());
            preparedStatement.setString(3, profile.getFirstName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Profile getProfilebyUsername(String username) {
        Profile profile = new Profile();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from userprofile where username = ?");
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                profile.setUsername(rs.getString("username"));
                profile.setIcno(rs.getString("icno"));
                profile.setFirstName(rs.getString("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profile;
    }
}
