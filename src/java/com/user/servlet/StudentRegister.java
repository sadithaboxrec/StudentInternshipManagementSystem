/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user.servlet;

import com.DAO.StudentDAOImpl;
import com.DB.DBConnect;
import com.Entity.Student;
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
@WebServlet("/StudentRegister")
public class StudentRegister extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            
            String name = request.getParameter("name");
	    String email = request.getParameter("email");
            String password=request.getParameter("password");
            
            Student student =new Student(name,email,password,"student");
            
            StudentDAOImpl dao=new StudentDAOImpl(DBConnect.getConn());
            boolean f=dao.StudentRegister(student);
            
            HttpSession session=request.getSession();
            
                if(f) {
				 	
                  session.setAttribute("SuccessMsg", "Student Added Successfully");
                  response.sendRedirect("login.jsp");
                  
                }else {
                    session.setAttribute("failedMsg", "Something wrong on Server");
                    response.sendRedirect("index.jsp");
	        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


}
