<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Category</title>
</head>
<body>
	<h1>Add Category</h1>
	<form action="/admin/addcategory" method="post" class="modal-content">
		Category Name:<input type="text" name="cname"> </br> </br> <input
			type="submit" value="Add Category"> <select
			name="selectCategory">
			<!-- <c:forEach var="cat" items="${category}" begin="1" end="5">
				<option label="${cat.cname}" value="${cat.cid}" />
			</c:forEach> -->
		</select>

	</form>
</body>
</html>