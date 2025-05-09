<%-- 
    Document   : alladmins
    Created on : May 9, 2025, 12:24:54 PM
    Author     : sadit
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page import="com.DAO.userDAOImpl"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="java.util.List"%>
<%@page import="com.Entity.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Admins</title>
</head>
<body>

    
<h1>All Admins</h1>


                <c:if test="${not empty SuccessMsg }">
                  <p> ${SuccessMsg} </p>
                  <c:remove var="SuccessMsg"  scope="session" />
                </c:if>

                <c:if test="${not empty failedMsg }">
                  <p> ${failedMsg} </p>
                  <c:remove var="failedMsg"  scope="session" />
                </c:if>
			


		<table>
                    
		  <thead>
		    <tr>
		      <th>Id</th>
                      <th>Name</th>
		      <th>Email</th>
		      <th>Telephone</th>
		      <th>Username</th>
		      <th>Photo</th>
		      <th>Edit Details</th>
		    </tr>
                    
		  </thead>
		  <tbody>
		  
		  <% 
		  AdminDAOImpl dao=new AdminDAOImpl(DBConnect.getConn());
		  List<Admin> list= dao.getAllAdmins();
		  
		  for(Admin admin:list){
			  %>
			 
			<tr>
                            
			   <td><%=admin.getAdminId %></td>
                            <td> <%=admin.getName() %> </td>
                            <td> <%=admin.getEmail() %></td>
                            <td> <%=admin.getTelephone() %></td>
                           <td> <%=admin.getUsername() %></td>
                            <td> <img src="../images/users/<%=us.getPhotoName() %>"  style="width:50px; height:50px;"> </td>
                            <td>
                               <a href="editadmins.jsp?id=<%=us.getAdminId() %>">Edit</a>
                            </td>
		    </tr>
			  
			  <%
		  }
		  %>


		  </tbody>
		</table>

</body>
</html>