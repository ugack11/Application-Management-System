<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="model.*" %>
<%
Profile profile = new Profile();
String table = (String) request.getAttribute("table");
profile = (Profile) session.getAttribute("profile");
String adminTestString = "admin";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
	    <title>Application Management System: Members</title>
    </head>
    <body>
	    <h2>Application Management System</h2>
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
	    <div>
		    <%=table %>
	    </div>
	    <!-- Scripts Only Below -->
	    <script>
		 function validateFilter() {
	   		 var category = document.getElementById("category").value;
	   		 var value = document.forms["filter"]["value"].value;

	   		 if(value.length == 0) {
	    		 alert("Please enter a value");
	    		 return false;
	    	 }
	    	 if(!(/^\d+$/.test(value)) && category == "profileID") {
	    		 alert("Please choose a numerical value");
	    		 return false;
	    	 }
	    	 return true;
		 }
		</script>

    </body>
</html>