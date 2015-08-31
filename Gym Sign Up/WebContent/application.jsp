<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.*" %>    

<%
	Profile profile = (Profile) session.getAttribute("profile");
	String table = "";
	String fileName = "";
	
	/*if(request.getAttribute("filename") != null) {
		fileName = (String) request.getAttribute("filename");
	}*/
	
	request.setAttribute("username", profile.getUsername());
	
	
	String path = getServletContext().getRealPath("/applications");
	String applicationLink = "applications/"+ profile.getApplication();
	
	String adminTestString = "admin";
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css" >
	<title>Application Management System: Application</title>
</head>
<body>
	<h2>Browse Application Management System</h2>
	<p>You are logged in as <%=profile.getUsername() %> </p>
	<br>
	<div id="menu">
		
		<div>
			<form action='LogoutServlet'><input class='input' type='submit' value='Logout'></form>
		</div>
		<div>
			<% 
			if(profile.getType().equals(adminTestString)){
			out.println("<form action='browse'><input class='input' type='submit' value='Browse'></form>");
			}
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
	<form action="UploadServlet" style= "text-align:center;" method="post" enctype="multipart/form-data">
		<input class='input' type="file" name="file">
		<input class='input' type="submit" value="Upload">
	</form>
	
	<div>
		<p style="text-align:center;">
     		
     		<a href="<%= applicationLink %>" target="_"><button class='input'>View Application</button></a>
     		
  		</p>
	</div>
  
	
  	
</body>
</html>