/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

/**
 *
 * @author sadit
 */
public class Admin  {
    
    	private int adminId;
	private String name;
	private String email;
	private String telephone;
	private String username;
	private String password;
	private String photoName;
        private String role;
        
        
        public Admin() {
		super();
	}
	
	
	public Admin(String name, String email, String telephone, String username,
			String password, String photoName ,String role) {
		super();
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.username = username;
		this.password = password;
		this.photoName = photoName;
                this.role = role;
	}
        
        


    public void setAdminId(int userId) {
        this.adminId = adminId;
    }


    public void setName(String name) {
        this.name = name;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public int getAdminId() {
        return adminId;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhotoName() {
        return photoName;
    }


    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    
    
    
        
	
    
}
