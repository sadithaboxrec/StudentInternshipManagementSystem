<%-- 
    Document   : addadmin
    Created on : May 9, 2025, 11:42:31 AM
    Author     : sadit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Admin</title>
    </head>
    <body>
        <h1>Add Admin</h1>
        
        <h2>Admin Registration </h2>

            <c:if test="${not empty SuccessMsg }">
              <p> $ {SuccessMsg} </p>
              <c:remove var="SuccessMsg"  scope="session" />
            </c:if>

            <c:if test="${not empty failedMsg }">
              <p> $ {failedMsg} </p>
              <c:remove var="failedMsg"  scope="session" />
            </c:if>

 		 <form action="../AdminRegister" method="POST"  enctype="multipart/form-data">
                     
 		 
			    <label for="name">Full Name:</label><br>
			    <input type="text" id="name" name="name" required><br><br>
			
			    <label for="email">Email:</label><br>
			    <input type="email" id="email" name="email" required><br><br>
			
			    <label for="telephone">Telephone:</label><br>
			    <input type="tel" id="telephone" name="telephone"><br><br>
                            
			    <label for="username">User Name:</label><br>
			    <input type="text" id="username" name="username" required><br><br>
			
			    <label for="password">Password:</label><br>
			    <input type="password" id="password" name="password" required><br><br>
			    
			    <label for="userPhoto">Upload Photo:</label>
                            <input type="file" id="userPhoto" name="userPhoto" accept="image/*" required><br><br>
			
			    <input type="checkbox" id="terms" name="check" required>
			    <label for="check"> Adding the User Confirmed</label><br><br>

			
			    <input type="submit" value="Submit">
                            
                  </form>

    </body>
</html>
