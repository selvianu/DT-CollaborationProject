<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
</head>
<body>
	<h1>Add Product</h1>
	<form action="addProduct" method="post" class="modal-content"
		enctype="multipart/form-data">
		Product Name:<input type="text" name="pname"> </br> </br> Produt
		Description:<input type="text" name="desc"> </br> </br> Product Price:<input
			type="text" name="price"></br> </br> Enter no of products available:<input
			type="text" name="stockAvailable"> </br> </br> Select Product Category:
		<select name="selectCategory">
			<!-- <option value="CD">CD</option>
			<option value="Flash Cards">Flash Cards</option>
			<option value="Board Books">Board Books</option>
			<option value="3D Books">Board Books</option> -->
			<c:forEach var="cat" items="${category}" begin="1" end="5">
				<option label="${cat.cname}" value="${cat.cid}" />
				
			</c:forEach>

		</select> <input type="file" name="imgName"> <input type="submit"
			value="enter">
	</form>
</body>
</html>