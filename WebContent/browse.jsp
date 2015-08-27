<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="model.*" %>
<%
Profile profile = new Profile();
String table = "";
String admin = "admin";
if(request.getAttribute("table") != null) {
	table = (String) request.getAttribute("table");
}
if(session.getAttribute("profile") != null) {
	profile = (Profile) session.getAttribute("profile");
}
String adminTestString = "admin";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
	    <title>Application Management System: Browse</title>
    </head>

    <body>
	    <h2>Application Management System</h2>
	    <p>You are logged in as <%=profile.getUsername() %></p>
	    <br>
	    <div id="menu">

		    <div>
			    <%if(profile.getType() != ""){
				    out.println("<form action='LogoutServlet'><input class='input' type='submit' value='Logout'></form>");
				}
			    else{
					out.println("<form action='index.jsp'><input class='input' type='submit' value='Login'></form>");
				} %>

		    </div>
		    <div>
			    <%if(profile.getType().equals(adminTestString)) {out.println("<form action='browse'><input class='input' type='submit' value='Browse'></form>");} %>
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


	    <div>
		    <%= table %>
	    </div>


    </body>
</html>