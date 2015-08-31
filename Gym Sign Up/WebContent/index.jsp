<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css" />
	<title>Application Management System: Home Page</title>
</head>
<body>
	<h2>Application Management System</h2>
	
	<p>This is a application management system that handles all the gym application people have submited.</p>
		
	<p>Instructions for Beta-Test use: Login with the username: 'ugack111' and the password: '123456789'</p>
	
	<p>So, basically there are 2 users "admin" and "applicant". The admin has an exclusive access to members page where he can see some information that are not visible to applicants such as username and password. He can also create, update, and delete user in members page.</p>
	
	<p>When you click "Browse" on the index page, you can just view the users information without logging in. Critical information like username and password are not shown here.</p>
 	
 	<p>The settings page is where the applicants can update their information along with their gym application.</p>	
		
		<h3>Login Information</h3>
		
		<br>
		<div style="display: inline-block; border: 1px solid">
			<form id="loginForm" name="loginForm" action="login" method="post" onsubmit="return validateLogin()">
				<div>
					<input id="usernameInput" class="input" type="text" name="username" value="username">
				</div>
				<div>
					<input id="passwordInput" class="input" type="password" name="password" value="password">
				</div>
					<input type="radio" name="account" value="login"checked>Existing Account
				<br>
					<input type="radio" name="account" value="create">New Account
				<br>
					<input class="input" type="submit" name="login" value="Go">
			</form>
			<!-- <form action="browse">	
				<input class="input" type="hidden" name="filterType" value="unfiltered">
				<input class="input" type="submit" name="browse" value="Browse">
			</form>-->
		</div>	
		<br>
		${errorMessage} 
		<% //String errorMessage= (String) request.getAttribute("errorMessage");
		//out.println(errorMessage);
		%>
		<script type="text/javascript">
			function validateLogin() {
	   			var username = document.getElementById("usernameInput").value;
	   			var password = document.getElementById("passwordInput").value;
	   			if (username.length > 20 || username.length < 8) {
		    		alert("Username must be atleast 8 characters and no more than 20");
		    		return false;
		    	}
		   		if (password.length > 20 || password.length < 8) {
		    		alert("Password must be atleast 8 characters and no more than 20");
		    		return false;
		    	}
				return true;
			}
		</script>	
</body>
</html>