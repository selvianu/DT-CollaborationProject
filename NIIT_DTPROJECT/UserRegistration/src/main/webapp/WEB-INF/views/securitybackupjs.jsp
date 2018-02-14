<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.4/css/mdb.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.4/js/mdb.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNav">
				<span class="glyphicon glyphicon-menu-hamburger"></span>
			</button>
			<a class="navbar-brand" href="#">Kidoo's Book Shelf</a>
		</div>

		<div class="collapse navbar-collapse, topnav" id="myNav">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#"><span
						class="glyphicon glyphicon-home aria-hidden=true"></span> Home</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/adding"
					data-target="#id01" data-toggle="modal">Register</a></li>

				<li class="dropdown"><a class="dropdown-toggle" href="#">Admin</a>
					<div id="id04" class="modal" role="dialogue"></div> <a
					href="${pageContext.request.contextPath}/admin/showProducts"
					data-target="#id04" data-toggle="modal">Product</a></li>

				<!-- <li><a href="#" data-target="#id02" data-toggle="modal">Sign
								In</a></li>
						<li><a href="#" data-target="#id03" data-toggle="modal">Add
								Category</a>
						<li><a href="#" data-target="#id04" data-toggle="modal">Add
								Product</a>
						<li><a href="showProducts">Show Products</a></li> -->
			</ul>
			</ul>
		</div>
	</div>
	</nav>
	<div id="id01" class="modal" role="dialogue">
		<span onclick="document.getElementById('id01').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<div class="container">
			<h1>Sign Up</h1>
			<%@ include file="register.jsp"%>
			<hr>
		</div>
	</div>
	<div id="id02" class="modal" role="dialogue">
		<span onclick="document.getElementById('id02').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<div class="container">
			<%@ include file="signin.jsp"%>
			<hr>
		</div>
	</div>
	<div id="id03" class="modal" role="dialogue">
		<span onclick="document.getElementById('id03').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<div class="container">
			<%@ include file="addcategory.jsp"%>
			<hr>
		</div>
	</div>

	<span onclick="document.getElementById('id04').style.display='none'"
		class="close" title="Close Modal">&times;</span>
	<div class="container">
		<%@ include file="addproduct.jsp"%>
		<hr>
	</div>

</body>
</html>
