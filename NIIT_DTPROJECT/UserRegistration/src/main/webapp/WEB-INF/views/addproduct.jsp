<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Products</title>
</head>
<body>
	<h1>Add Product</h1>
	<form action="addProduct" method="post" class="modal-content">
		Product Name:<input type="text" name="pname"> </br>
		</br>Product Price:<input type="text" name="price"></br>
		</br> Enter no of products available:<input type="text" name="available">
		</br>
		</br>Enter the supplier Id:<input type="text" name="supplierId"> </br>
		</br>Enter Category Id:<input type="text" name="cId"></br>
		</br>
		</br> <input type="submit" value="add Product">
	</form>
</body>
</html>