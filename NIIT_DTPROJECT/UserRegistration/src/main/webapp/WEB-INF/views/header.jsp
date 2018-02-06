<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNav">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Kidoo's Book Shelf</a>
		</div>

		<div class="collapse navbar-collapse, topnav" id="myNav">
			<ul class="nav navbar-nav">
				<li><a href="home">Home</a></li>
				<li><a href="#" data-target="#id01" data-toggle="modal">Register</a>
				</li>
				<li><a href="#" data-target="#id02" data-toggle="modal">Sign
						In</a></li>
				<li><a href="#" data-target="#id03" data-toggle="modal">Add
						Category</a>
				<li><a href="#" data-target="#id04" data-toggle="modal">Add
						Product</a>
				<li><a href="showProductDetails">Show Products</a></li>
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
	<div id="id04" class="modal" role="dialogue">
		<span onclick="document.getElementById('id04').style.display='none'"
			class="close" title="Close Modal">&times;</span>
		<div class="container">
			<%@ include file="addproduct.jsp"%>
			<hr>
		</div>
	</div>
</body>
</html>
