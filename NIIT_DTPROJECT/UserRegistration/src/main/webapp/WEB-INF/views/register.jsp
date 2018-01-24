<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Registration Page</h1>
	<form action="registrationController" method="post">
		Enter username:<input type="text" name="username"> </br>Enter
		password:<input type="password" name="password1"> </br>Re-Enter Ur
		password:<input type="password" name="password2"> </br> Enter ur
		e-mail id <input type="email" name="email"></br> Enter ur Date of
		Birth <input type="date" name="dob" placeholder="YYYY-MM-DD" required
			pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}"
			title="Enter a date in this formart YYYY-MM-DD"> </br> </br> <input
			type="submit" value="register">
	</form>
</body>
</html>