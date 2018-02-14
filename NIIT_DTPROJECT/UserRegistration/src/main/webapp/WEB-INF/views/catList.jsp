<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List</title>
</head>
<body>
	<table border="1" cellspacing="2" align="center">
		<tr bgcolor="gray">
			<td>Category Name</td>
		</tr>


		<c:forEach items="${productListById}" var="catproduct">
			<tr>
				<td>${catproduct.cname}</td>
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