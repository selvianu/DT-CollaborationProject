<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
body {
	background-image: url("");
}
</style>

</head>
<body>
	<c:url value="/admin/login" var="login"></c:url>
	<form action="${login}" method="post">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-5 col-md-3">
					<div class="form-login">
						<br> <br> <br>
						<h4 style="color: red; text-align: center">Kids library</h4>
						<c:if test="${error!=null}">
							<div class="alert alert-danger">
								<strong>check your username or password</strong>
							</div>
						</c:if>
						Username: <input type="text" name="username"
							class="form-control input-sm chat-input" placeholder="username" />
						<br> Password: <input type="password" name="password"
							class="form-control input-sm chat-input" placeholder="password" />
						<br>

						<div class="wrapper">
							<span class="group-btn"> <input type="submit"
								value="Login"> <i class="fa fa-sign-in"></i>
							</span>
						</div>
						<div class="bottom text-center">
							New here ? <a href="register"><b>Register</b></a>
						</div>
					</div>
				</div>

			</div>
		</div>
	</form>
</body>
</html>
