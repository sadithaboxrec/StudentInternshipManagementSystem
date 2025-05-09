/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.DAO;

import com.Entity.Company;
import java.util.List;

/**
 *
 * @author sadit
 */
public interface CompanyDAO {
    
    public boolean CompanyRegister(Company company);
    
    public List <Company> getAllCompany();
    
}
