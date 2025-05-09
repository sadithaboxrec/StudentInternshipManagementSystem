/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DAO;

import com.Entity.Admin;
import java.util.List;

/**
 *
 * @author sadit
 */
public interface AdminDAO {
    
    public boolean AdminRegister(Admin admin);
    
    public List <Admin> getAllAdmins();
}
