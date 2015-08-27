
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css" >
	    <title>Application Management System: Create Account</title>
    </head>

    <body>
        <h2>Browse Application Management System</h2>

	    <form id="settingForm" action="AddServlet">
		    <div>
			    <label for="username">Username:</label>
                <input class='input' type="text" name="username" value="">
		    </div>

		    <div>
			    <label for="password">Password:</label>
                <input class='input' type="text" name="password" value="">

		    </div>

		    <div>
			    <label for="fName">First Name:</label>
                <input class='input' type="text" name="fName" value="">
		    </div>

		    <div>
			    <label for="lName">Last Name:</label>
                <input class='input' type="text" name="lName" value="">
		    </div>

		    <div>
			    <label for="type">Type:</label>
                <input class='input' type="text" name="type" value="applicant" readonly/>
		    </div>

		    <div>
			    <label for="sex">Sex(M/F):</label>
                <input class='input' type="text" name="sex" value="">
		    </div>

		    <div>
			    <label for="birthdate">Birth Date(mm/dd/yyyy):</label>
                <input class='input' type="text" name="birthdate" value="">
		    </div>

		    <div>
			    <label for="mailingaddress">Mailing Address</label>
                <input class='input' type="text" name="maddress" value="">
		    </div>

		    <div>
			    <label for="city">city:</label>
                <input class='input' type="text" name="city" value="">
		    </div>

		    <div>
			    <label for="state">State:</label>
                <input class='input' type="text" name="state" value="">
		    </div>

		    <div>
			    <label for="zipcode">Zip Code:</label>
                <input class='input' type="text" name="zipcode" value="">
		    </div>

		    <div>
			    <label for="telephone">Telephone(xxx-xxx-xxxx):</label>
                <input class='input' type="text" name="telephone" value="">
		    </div>

		    <div>
			    <label for="email">E-mail:</label>
                <input class='input' type="text" name="email" value="">
		    </div>

		    <div>
			    <input class='input' type="submit" value="Create Account">
		    </div>

	    </form>

    </body>
</html>