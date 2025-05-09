/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.servlet;

import com.DAO.CompanyDAOImpl;
import com.DB.DBConnect;
import com.Entity.Company;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/CompanyRegister")
public class CompanyRegister extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
            try {
            
            String companyName = request.getParameter("companyname");
	    String companyEmail = request.getParameter("companyemail");
            String companyPhone=request.getParameter("companyphone");
            String companyPassword=request.getParameter("companypassword");
            String role=request.getParameter("role");
            
            Company company =new Company(companyName,companyEmail,companyPhone,companyPassword,"company");
            
            CompanyDAOImpl dao=new CompanyDAOImpl(DBConnect.getConn());
            boolean f=dao.CompanyRegister(company);
            
            HttpSession session=request.getSession();
            
                if(f) {
				 	
                  session.setAttribute("SuccessMsg", "Student Added Successfully");
                 // response.sendRedirect("Super_Admin/alladmins.jsp");
                  
                }else {
                    session.setAttribute("failedMsg", "Something wrong on Server");
                 //   response.sendRedirect("Super_Admin/alladmins.jsp");
	        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
            
            
}
