/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DAO;


import com.Entity.Student;
import java.util.List;

/**
 *
 * @author sadit
 */
public interface StudentDAO {
    
    public boolean StudentRegister(Student student);
    
    public List <Student> getAllStudent();
    
}
