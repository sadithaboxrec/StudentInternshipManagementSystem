/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.Admin;
import com.Entity.Company;
import com.Entity.Student;
import java.sql.*;

/**
 *
 * @author sadit
 */
public class UserDAOImpl implements UserDAO {
    
    
    private Connection conn;

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }

    public Object login(String username, String password) {
        
        try {

            String adminQuery = "SELECT * FROM admin WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(adminQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("id"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setTelephone(rs.getString("telephone"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admin.setPhotoName(rs.getString("photoName"));
                admin.setRole(rs.getString("role"));
                return admin;
            }


            String companyQuery = "SELECT * FROM company WHERE email = ? AND password = ?";
            ps = conn.prepareStatement(companyQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                Company company = new Company();
                company.setCompanyId(rs.getInt("id"));
                company.setCompanyName(rs.getString("name"));
                company.setCompanyEmail(rs.getString("email"));
                company.setCompanyPhone(rs.getString("telephone"));
                company.setCompanyPassword(rs.getString("password"));
                company.setRole(rs.getString("role"));
                return company;
            }


            String studentQuery = "SELECT * FROM student WHERE email = ? AND password = ?";
            ps = conn.prepareStatement(studentQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setRole(rs.getString("role"));
                return student;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
