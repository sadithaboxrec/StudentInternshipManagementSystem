/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.servlet;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.Entity.Admin;
import com.Entity.Company;
import com.Entity.Student;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author sadit
 */
@WebServlet("/UserLogin")
public class UserLoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
        UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
        Object user = dao.login(email, password);

        HttpSession session = request.getSession();

        if (user != null) {
            session.setAttribute("currentUser", user);

            String role = "";
            if (user instanceof Admin) {
                role = ((Admin) user).getRole();
            } else if (user instanceof Company) {
                role = ((Company) user).getRole();
            } else if (user instanceof Student) {
                role = ((Student) user).getRole();
            }

            switch (role) {
                case "admin":
                    response.sendRedirect("Super_Admin/dashboard.jsp");
                    break;
                case "company":
                    response.sendRedirect("Company/dashboard.jsp");
                    break;
                case "student":
                    response.sendRedirect("Student/dashboard.jsp");
                    break;
                default:
                    session.setAttribute("failedMsg", "Unknown role");
                    response.sendRedirect("login.jsp");
            }
        } else {
            session.setAttribute("failedMsg", "Invalid credentials");
            response.sendRedirect("login.jsp");
        }
    }


}
