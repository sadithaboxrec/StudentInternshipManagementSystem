/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.Company;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;


public class CompanyDAOImpl implements CompanyDAO {
        
             private Connection conn;

	
	
	
	public CompanyDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}


             @Override
    public boolean CompanyRegister(Company company) {
        
        boolean f= false;
        
        try {
            
            String sql="INSERT INTO company  (name, email, telephone,password,role) VALUES ( ?,  ?, ?, ?,?) ";
            
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getCompanyEmail());
            ps.setString(3, company.getCompanyPhone());
            ps.setString(4, company.getCompanyPassword());
            ps.setString(5, company.getRole());
        
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
	public List<Company> getAllCompany() {
		List <Company> list=new ArrayList<Company>();
                
		Company company=null;
		
		try {
                       String sql="SELECT * FROM company";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			  
			  while(rs.next()) 
			  {
				  
				 company = new Company();
				  company.setCompanyId(rs.getInt(1));
				  company.setCompanyName(rs.getString(2));
                                  company.setCompanyPhone(rs.getString(3));
				  company.setCompanyPassword(rs.getString(4));
				  company.setRole(rs.getString(5));
      
				  list.add(company);
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

    
}
