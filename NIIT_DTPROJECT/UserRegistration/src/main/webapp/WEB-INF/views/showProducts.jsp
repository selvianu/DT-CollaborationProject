<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<h2 style="text-align: center">Product List</h2>
	<table border="1" cellspacing="2" align="center">
		<tr bgcolor="gray">
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Description</td>
			<td>Price</td>
			<td>Stock</td>
			<td>Photo</td>
			<td>Actions</td>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.pid}</td>
				<td>${product.pname}</td>
				<td>${product.desc}</td>
				<td>${product.price}</td>
				<td>${product.stockAvailable}</td>
				<c:url value="/resources/images/${product.pname}.jpg" var="imageUrl"></c:url>
				<td><img src="${imageUrl}" height="50" width="100"></td>


				<!-- <td><a href="productDesc/${product.pid}"> image<img
						src="<c:url value="/resources/**${product.pid}.jpg"/>"
						width="50px" height="50px" /></a></td>-->
				<!-- 				<td align="center"><a href=""><span
						class="glyphicon glyphicon-info-sign">update</span></a> <align="center">
					<a href=""><span class="glyphicon glyphicon-info-sign">delete</span></a></td>-->

				<td align="center" height="50" width="70"><a
					href=<c:url value="/all/product/viewProduct/${product.pid}"/>><span
						class="glyphicon glyphicon-info-sign">|View|</span></a></br> <a
					href=<c:url value="/all/product/editform/${product.pid}"/>><span
						class="glyphicon glyphicon-pencil">| Update|</span></a></br> <a
					href=<c:url value="/admin/deleteProduct/${product.pid}"/>
					class="btn btn-danger">Delete<span
						class="glyphicon glyphicon-trash"></span></a></br></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>