<%-- 
    Document   : registerStudents
    Created on : May 9, 2025, 6:48:24 PM
    Author     : sadit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Register</title>
    </head>
    <body>
        <h1>Student Registration</h1>
        
        <form method="post" action="StudentRegister">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name" required><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" required><br><br>

            <label for="password">Password:</label><br>
            <input type="password" id="password" name="password" required><br><br>

            <input type="submit" value="Submit">
        </form>

        
        
    </body>
</html>
