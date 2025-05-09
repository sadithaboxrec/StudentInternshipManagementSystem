/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author sadit
 */
public class AdminDAOImpl  implements AdminDAO{
    
    	private Connection conn;

	
	
	
	public AdminDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


    @Override
    public boolean AdminRegister(Admin admin) {
        
        boolean f= false;
        
        try {
            
            String sql="INSERT INTO admin  (name, email, telephone, username, password, photoName,role) VALUES ( ?,  ?, ?, ?, ?, ?,?) ";
            
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getTelephone());
            ps.setString(4, admin.getUsername()); 
            ps.setString(5, admin.getPassword());
            ps.setString(6, admin.getPhotoName());

            
            int i= ps.executeUpdate();
            
            if(i==1) {
            	f=true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return f;
        
    }
    
    
    
    	@Override
	public List<Admin> getAllAdmins() {
		List <Admin> list=new ArrayList<Admin>();
                
		Admin admin=null;
		
		try {
                       String sql="SELECT * FROM admin";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			  
			  while(rs.next()) 
			  {
				  
				 admin = new Admin();
				  admin.setAdminId(rs.getInt(1));
				  admin.setName(rs.getString(2));
				  admin.setEmail(rs.getString(3));
				  admin.setTelephone(rs.getString(4));
				  admin.setUsername(rs.getString(5));
				  admin.setPassword(rs.getString(6));
                                  admin.setPhotoName(rs.getString(7));
      
				  list.add(admin);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

    
    
}
