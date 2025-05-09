<%-- 
    Document   : login
    Created on : May 9, 2025, 11:22:43 AM
    Author     : sadit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    
        
    <c:if test="${not empty failedMsg}">
      <h5>${failedMsg}</h5>
      <c:remove var="failedMsg" scope="session"/>
    </c:if>
    
      
      
</head>
<body>
    <h2>Login</h2>
    <form method="post" action="UserLogin">
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>

