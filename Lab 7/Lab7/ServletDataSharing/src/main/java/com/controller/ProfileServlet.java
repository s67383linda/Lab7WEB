/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import com.dao.ProfileDAO;
import com.model.Profile;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Profile
 */
public class ProfileServlet extends HttpServlet {

    private static String INSERT = "/studentRegister.jsp";
    private static String CONFIRM = "/confirmRegister.jsp";
    private static String CREATED = "/notificationRegister.jsp";
    private ProfileDAO dao;

    public ProfileServlet() throws ClassNotFoundException {
        super();
        dao = new ProfileDAO();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String foward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("confirm")) {
            foward = CONFIRM;
            String username = request.getParameter("username");
            Profile profile = dao.getProfilebyUsername(username);
            request.setAttribute("profile", profile);
        } else if (action.equalsIgnoreCase("insert")) {
            foward = INSERT;
        } else if (action.equalsIgnoreCase("created")) {
            foward = CREATED;
        }

        RequestDispatcher view = request.getRequestDispatcher(foward);
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        Profile profile = new Profile();
        profile.setUsername(request.getParameter("username"));
        profile.setIcno(request.getParameter("icno"));
        profile.setFirstName(request.getParameter("firstName"));

        if (action.equalsIgnoreCase("insert")) {
            request.setAttribute("profile", profile); // Set the profile attribute here
            RequestDispatcher view = request.getRequestDispatcher(CONFIRM);
            view.forward(request, response);
        } else if (action.equalsIgnoreCase("confirm")) {
            dao.addProfile(profile);
            RequestDispatcher view = request.getRequestDispatcher(CREATED);
            view.forward(request, response);
        }
    }
}
