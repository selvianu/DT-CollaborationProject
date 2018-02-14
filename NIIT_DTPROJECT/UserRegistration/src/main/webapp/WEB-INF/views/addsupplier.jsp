<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier List</title>
</head>
<body>
	<h2 style="text-align: center">Product List</h2>
	<table border="1" cellspacing="2" align="center">
		<tr bgcolor="gray">
			<td>Supplier Name</td>
			<td>Supplier Contact Details</td>
		</tr>


		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.pname}</td>
				<td>${product.desc}</td>
				<td>${product.price}</td>
				<td>${product.stockAvailable}</td>
				<td><a href="productDesc/${product.pid}"> <img
						src="<c:url value="/resources/**${product.pid}.jpg"/>"
						width="50px" height="50px" /></a></td>
				<td align="center"><a href=""><span
						class="glyphicon glyphicon-info-sign">| |</span></a></td>

			</tr>
		</c:forEach>

		<!-- 	<tr>
			<td align="center"><a
				href=<c:url value="/all/supplier/viewsupplier/${sup.sid}"/>><span
					class="glyphicon glyphicon-info-sign">| |</span></a> <a
				href=<c:url value="/all/supplier/editform/${sup.sid}"/>><span
					class="glyphicon glyphicon-pencil">| |</span></a> <a
				href=<c:url value="/all/deletesupplier/${sup.sid}"/>><span
					class="glyphicon glyphicon-trash"></span></a>
		</tr>
	 -->
	</table>

</body>
</html>