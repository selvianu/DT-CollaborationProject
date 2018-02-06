<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background: -webkit-linear-gradient(top, rgba(238, 238, 238, 1) 0%,
		rgba(89, 89, 89, 1) 100%); /* Chrome10+,Safari5.1+ */
}
</style>

<title>Home Page</title>
</head>
<body>

	<nav id="navbar-red" class="navbar navbar-default" role="navigation">
	<%@ include file="header.jsp"%>
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>

			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img class="first-slide" src="resources/images/1.jpg"
						alt="First slide" width="90%">
					<div class="container">
						<h1>Play Learn and Grow Together</h1>
					</div>
				</div>
				<div class="item">
					<img class="first-slide" src="resources/images/2.jpg"
						alt="First slide" width="90%">
					<div class="container">
						<h1>
							The beautiful thing about learning is nobody</br>can take it away from
							you
						</h1>
					</div>
				</div>

				<div class="item">
					<img class="first-slide" src="resources/images/3.jpg"
						alt="First slide" width="90%">
					<div class="container">
						<h1>Today is the great day to learn something new</h1>
					</div>
				</div>
				<div class="item">
					<img class="first-slide" src="resources/images/4.jpg"
						alt="First slide" width="90%">
					<div class="container">
						<h1>Be the change you want to see in the world</h1>
					</div>
				</div>

				<div class="item active">
					<img class="first-slide" src="resources/images/5.jpg"
						alt="First slide" width="90%">
					<div class="container">
						<h1>Respect the Brain, Build the mind</h1>
					</div>
				</div>
				<div class="item active">
					<img class="first-slide" src="resources/images/6.jpg"
						alt="First slide" width="90%">
					<div class="container">
						<h1>Kids must be taught how to think, not what to think</h1>
					</div>
				</div>
			</div>
			<div>
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span></a>
			</div>
		</div>
	</div>
	</nav>



	<%@ include file="footer.jsp"%>


</body>
</html>