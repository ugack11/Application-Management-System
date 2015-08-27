<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.*" %>  

<%
	Profile profile = (Profile) session.getAttribute("profile");
	
	
	String adminTestString = "admin";
%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css" >
	<title>Application Management System: Settings</title>
</head>
<body>
	<h2>Browse Application Management System</h2>
	<p>You are logged in as <%=profile.getUsername() %></p>
	<br>
	<div id="menu">
	<div>
			<form action='LogoutServlet'><input class='input' type='submit' value='Logout'></form>
		</div>
		<div>
			<form action='browse'><input class='input' type='submit' value='Browse'></form>
		</div>
		<div>
			<% 
				if(profile.getType().equals(adminTestString)) { 
					out.println("<form action='members'><input class='input' type='submit' value='Members'></form>");
				} 
			 %>
		 </div>
		 <div>
		  <form action='settings'><input class='input' type='submit' value='Settings'></form>
		</div>
		</div>
	<br>
	<form id="settingForm" action="updateForm">
		<div>
			<label for="username">Username:</label>
			<input class='input' type="text" name="username" value="<%= request.getAttribute("username") %>" readonly/>
		</div>
		<div>
			<label for="password">Password:</label>
			<input class='input' type="text" name="password" value="<%= request.getAttribute("password") %>">
		</div>
		<div>
			<label for="fName">First Name:</label>
			<input class='input' type="text" name="fName" value="<%= request.getAttribute("fName") %>">
		</div>
		<div>
			<label for="lName">Last Name:</label>
			<input class='input' type="text" name="lName" value="<%= request.getAttribute("lName") %>">
		</div>
		<div>
			<label for="type">Type:</label>
			<input class='input' type="text" name="type" value="<%= request.getAttribute("type") %>">
		</div>
		<div>
			<label for="sex">Sex(M/F):</label>
			<input class='input' type="text" name="sex" value="<%= request.getAttribute("sex") %>">
		</div>
		<div>
			<label for="birthdate">Birth Date(MM/DD/YYYY):</label>
			<input class='input' type="text" name="birthdate" value="<%= request.getAttribute("birthdate") %>">
		</div>
		<div>
			<label for="maddress">Mailing Address:</label>
			<input class='input' type="text" name="maddress" value="<%= request.getAttribute("maddress") %>">
		</div>
		<div>
			<label for="city">City:</label>
			<input class='input' type="text" name="city" value="<%= request.getAttribute("city") %>">
		</div>
		<div>
			<label for="state">State:</label>
			<input class='input' type="text" name="state" value="<%= request.getAttribute("state") %>">
		</div>
		<div>
			<label for="zipcode">Zip Code:</label>
			<input class='input' type="text" name="zipcode" value="<%= request.getAttribute("zipcode") %>">
		</div>
		<div>
			<label for="telephone">Telephone:</label>
			<input class='input' type="text" name="telephone" value="<%= request.getAttribute("telephone") %>">
		</div>
		<div>
			<label for="email">E-mail:</label>
			<input class='input' type="text" name="email" value="<%= request.getAttribute("email") %>">
		</div>
		<div>
			<input type='hidden' name="oldUsername" value="<%= request.getAttribute("username") %>">
			<input type='hidden' name="oldPassword" value="<%= request.getAttribute("password") %>">
			<input class='input' type="submit" value="Update">
		</div>
	</form>
	<form action='deleteApplication'>
		<input class='input' type='submit' value='Delete Application'>	
	</form>
</body>
</html>