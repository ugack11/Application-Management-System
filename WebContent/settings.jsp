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
			<% 
			if(profile.getType().equals(adminTestString)){
			out.println("<form action='browse'><input class='input' type='submit' value='Browse'></form>");}
			else {}
			%>
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
	<form id="settingForm" action="updateProfile">
		<div>
			<label for="username">Username:</label>
			<input class='input' type="text" name="username" value="<%= profile.getUsername() %>">
		</div>
		<div>
			<label for="password">Password:</label>
			<input class='input' type="text" name="password" value="<%= profile.getPassword() %>">
		</div>
		<div>
			<label for="fName">First Name:</label>
			<input class='input' type="text" name="fName" value="<%= profile.getFirstName() %>">
		</div>
		<div>
			<label for="lName">Last Name:</label>
			<input class='input' type="text" name="lName" value="<%= profile.getLastName() %>">
		</div>
		<div>
			<label for="sex">Sex(M/F):</label>
			<input class='input' type="text" name="sex" value="<%= profile.getSex() %>">
		</div>
		<div>
			<label for="birthdate">Birth Date(mm/dd/yyyy):</label>
			<input class='input' type="text" name="birthdate" value="<%= profile.getBirthDate() %>">
		</div>
		<div>
			<label for="maddress">Mailing Address:</label>
			<input class='input' type="text" name="maddress" value="<%= profile.getMAddress() %>">
		</div>
		<div>
			<label for="city">City:</label><input class='input' type="text" name="city" value="<%= profile.getCity() %>">
			
		</div>
		<div>
			<label for="state">State:</label>
			<input class='input' type="text" name="state" value="<%= profile.getState() %>">
		</div>
		<div>
			<label for="zipcode">Zip Code:</label>
			<input class='input' type="text" name="zipcode" value="<%= profile.getZipCode() %>">
		</div>
		<div>
			<label for="telephone">Telephone(xxx-xxx-xxx):</label>
			<input class='input' type="text" name="telephone" value="<%= profile.getTelephone() %>">
		</div>
		<div>
			<label for="email">Email:</label>
			<input class='input' type="text" name="email" value="<%= profile.getEmail() %>">
		</div>
		<div>
			<!-- <input type='hidden' name="oldPassword" value="<%= profile.getPassword() %>">-->
			<input class='input' type="submit" value="Update">
		</div>
	</form>
	<form action='application'>
		<input class='input' type='submit' value='Upload Application'>	
	</form>
	<form action='DeleteApplicationServlet'>
		<input type='hidden' value='<%= profile.getUsername() %>'>
		<input class='input' type='submit' value='Delete Application'>	
	</form>
</body>
</html>