/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static Connection myConnection = null;
    private static String myURL = "jdbc:mysql://localhost:3306/lab7";
    
    public static Connection getConnection() throws ClassNotFoundException{
        if(myConnection != null){
            return myConnection;
        }
        else{
            try{
                Class.forName("com.mysql.jdbc.Driver");
                myConnection = DriverManager.getConnection(myURL,"root","admin");
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
        return myConnection;
    }
    
    
    public void closeConnection() throws ClassNotFoundException {
        try{
            myConnection.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
