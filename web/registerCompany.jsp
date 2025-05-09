<%-- 
    Document   : registerCompany
    Created on : May 9, 2025, 7:43:06 PM
    Author     : sadit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
                <h1>Company Registration</h1>
        
        <form method="post" action="CompanyRegister">
            
            <label for="name">Company Name:</label><br>
            <input type="text" id="name" name="companyname" required><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="companyemail" required><br><br>
            
            <label for="tel">Telephone Number:</label><br>
            <input type="tel" id="tel" name="companyphone" required><br><br>

            <label for="password">Password:</label><br>
            <input type="password" id="password" name="companypassword" required><br><br>

            <input type="submit" value="Submit">
            
            
        </form>
                
                
    </body>
</html>
