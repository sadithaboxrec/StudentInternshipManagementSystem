/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.Student;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author sadit
 */
public class StudentDAOImpl implements StudentDAO{
    
      private Connection conn;

	
	
	
	public StudentDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


    public boolean StudentRegister(Student student) {
        
        boolean f= false;
        
        try {
            
            String sql="INSERT INTO student  (name, email, telephone,password,role) VALUES ( ?,  ?, ?, ?) ";
            
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            ps.setString(4, student.getRole());
        
            int i= ps.executeUpdate();
            
            if(i==1) {
            	f=true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;   
    }
    
    
    
    
    
        
	public List<Student> getAllStudent() {
		List <Student> list=new ArrayList<Student>();
                
		Student student=null;
		
		try {
                       String sql="SELECT * FROM student";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			  
			  while(rs.next()) 
			  {
				  
				 student = new Student();
				  student.setStudentId(rs.getInt(1));
				  student.setName(rs.getString(2));
				  student.setEmail(rs.getString(3));
				  student.setRole(rs.getString(4));
      
				  list.add(student);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
    
}
