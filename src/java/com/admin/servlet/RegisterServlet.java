/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.admin.servlet;

import com.DAO.AdminDAOImpl;
import com.DB.DBConnect;
import com.Entity.Admin;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;

import java.sql.Connection;



@WebServlet("/AdminRegister")
@MultipartConfig

public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
     
            
            try {
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String telephone = request.getParameter("telephone");
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
                    Part part=request.getPart("userPhoto");
                    String fileName=part.getSubmittedFileName();
			
			
			Connection conn = DBConnect.getConn();
			
			Admin admin = new Admin(name, email, telephone,username, password, fileName,"admin");

			
			AdminDAOImpl dao=new AdminDAOImpl(DBConnect.getConn());
			boolean f=dao.AdminRegister(admin);
			
			HttpSession session=request.getSession();
			
			if(f) {
				  String path=getServletContext().getRealPath("")+"images/admin";
				  System.out.println(path);
				  
				  File file=new File(path);
				  part.write(path + File.separator+ fileName);
				
				session.setAttribute("SuccessMsg", "User Added Successfully");
				response.sendRedirect("Super_Admin/alladmins.jsp");
			}else {
				session.setAttribute("failedMsg", "Something wrong on Server");
				response.sendRedirect("Super_Admin/alladmins.jsp");
			}
			
                } catch (Exception e) {
                e.printStackTrace();
            }
        

      }
    
}
    

        
