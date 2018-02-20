<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
</head>
<body>
	<h1>Add Product</h1>
	<springForm:form action="${contextRoot}/admin/addProduct" method="POST"
		class="form-horizontal" id="form2" enctype="multipart/form-data">
			Product Name:<input type="text" name="pname">
		</br>
		</br> Product
			Description:<input type="text" name="desc">
		</br>
		</br> Product Price:<input type="text" name="price">
		</br>
		</br> Enter no of products available:<input type="text"
			name="stockAvailable">
		</br>
		</br>
		<input type="file" name="imgName">
		<!-- 		<input type="submit" value="enter">
			 -->
		</br> Select Category
			<select name="cat">
			<c:forEach var="cat" items="${category}" begin="1" end="5">
				<option label="${cat.cname}" />
			</c:forEach>
		</select>
		<!-- <input type="submit">-->
		<br>
		<br>
	</springForm:form>
</body>
</html>