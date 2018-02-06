<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<table border="2px">
		<tr>
			<th>Product Name</th>
		</tr>
		<c:forEach items="${plist1}" var="pdt">
			<tr>
				<td><c:out value="${pdt.pname}"></c:out></td>
			</tr>


			<!-- <tr>
				<td><c:out value="${pdt.desc}"></c:out></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr> -->
		</c:forEach>
	</table>
	</form>
</body>
</html>