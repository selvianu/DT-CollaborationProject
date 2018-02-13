<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="springForm"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.4/css/mdb.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.4/js/mdb.min.js"></script>
<link rel="stylesheet"
	href=https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css>
<c:set var="contextRoot" value="${pageContext.request.contextPath}">
</c:set>

</head>
<body>
	<nav class="navbar navbar info-color-dark bg-dark fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="glyphicon glyphicon-menu-hamburger"></span>
				</button>
				<a class="navbar-brand" href="#">Kidoo's Book Shelf</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#"><span
							class="glyphicon glyphicon-home aria-hidden=true"></span> Home</a></li>

					<li><a href="${pageContext.request.contextPath}/admin/adding">Admin</a>
					<li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#add"><span
							class="glyphicon glyphicon-home aria-hidden=true"></span> Admin</a></li>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/admin/suppList">Supplier</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/showProducts">Product</a></li>
						<li><a
							href="${pageContext.request.contextPath}/admin/catList">Category</a></li>
						<li>
					</ul>



					<c:url value="/admin/addproduct" var="url1"></c:url>
					<li><c:if
							test="${pageContext.request.userPrincipal.name!=null }">
							<security:authorize access="hasRole('ROLE_ADMIN')">
								<a href="${url1}">Add Product</a>

							</security:authorize>
						</c:if></li>
					<c:url value="/admin/addcategory" var="url2"></c:url>
					<li><c:if
							test="${pageContext.request.userPrincipal.name!=null }">
							<security:authorize access="hasRole('ROLE_ADMIN')">
								<a href="${url2}">Add category</a>

							</security:authorize>
						</c:if></li>





					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Product</a>
						<ul class="dropdown-menu">
							<c:forEach var="productList" items="${productList}">
								<li><a
									href="${pageContext.request.contextPath}/pdtCustList?cid=${productList.cid}">${productList}</a>
							</c:forEach>
						</ul>
						<button type="button" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#id">
							<span class="glyphicon glyphicon-user"></span> Add
						</button>
						<div class="modal fade" id="id" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog cascading-modal" role="document">
								<!--Content-->
								<div class="modal-content">

									<!--Modal cascading tabs-->
									<div class="modal-c-tabs">

										<!-- Nav tabs -->
										<ul class="nav nav-tabs tabs-3" role="tablist">
											<li class="nav-item"><a class="nav-link active"
												data-toggle="tab" href="#id01" role="tab"><i
													class="fa fa-user mr-1"></i> supplier</a></li>
											<li class="nav-item"><a class="nav-link"
												data-toggle="tab" href="#id02" role="tab"><i
													class="fa fa-user-plus mr-1"></i> category</a></li>
											<li class="nav-item"><a class="nav-link"
												data-toggle="tab" href="#id03" role="tab"><i
													class="fa fa-user-plus mr-1"></i> product</a></li>
										</ul>

										<!-- Tab panels -->
										<div class="tab-content">
											<!--Panel 7-->
											<div class="tab-pane fade in show active" id="#id01"
												role="tabpanel">

												<!--   Body -->
												<div class="modal-body mb-1">

													<%@ include file="addsupplier.jsp"%>
													<div class="text-center mt-2">
														<button class="btn btn-info" type="submit" form="form2"
															value="saveproduct">Submit</button>
														<button type="button"
															class="btn btn-primary waves-effect ml-auto"
															data-dismiss="modal">Close</button>
													</div>
												</div>


											</div>
											<!--/.Panel 7-->
											<!--Panel 8-->
											<div class="tab-pane fade" id="id02" role="tabpanel">

												<!--Body-->
												<div class="modal-body mb-1">

													<%@include file="addcategory.jsp"%>
													<div class="text-center mt-2">
														<button class="btn btn-info" type="submit" form="form3"
															value="saveproduct">Submit</button>

														<button type="button"
															class="btn btn-primary waves-effect ml-auto"
															data-dismiss="modal">Close</button>
													</div>
												</div>

											</div>
											<div class="tab-pane fade" id="id03" role="tabpanel">
												<div class="modal-body mb-1">
													<%@include file="addproduct.jsp"%>
													<div class="text-center mt-2">
														<button class="btn btn-info" type="submit" form="form1"
															value="saveproduct">Submit</button>
														<button type="button"
															class="btn btn-primary waves-effect ml-auto"
															data-dismiss="modal">Close</button>
													</div>

												</div>

											</div>


										</div>

									</div>
								</div>
							</div>
						</div>
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item"><a class="nav-link active"
								data-toggle="tab" href="#id1" role="tab"> <span
									class="glyphicon glyphicon-user"></span> Login
							</a><i class="fa fa-user mr-1"></i></li>

						</ul>

						<div class="tab-pane fade" id="id1" role="tabpanel">
							<div class="modal-body mb-1">
								<%@include file="login.jsp"%>
								<div class="text-center mt-2">
									<button class="btn btn-info" type="submit" form="form1"
										value="saveproduct">Submit</button>
									<button type="button"
										class="btn btn-primary waves-effect ml-auto"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
			</div>

			<div class="tab-pane fade" id="id2" role="tabpanel">
				<div class="modal-body mb-1">
					<%@include file="login.jsp"%>
					<div class="text-center mt-2">
						<button class="btn btn-info" type="submit" form="form1">Submit</button>
						<button type="button" class="btn btn-primary waves-effect ml-auto"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		</div>
	</nav>

</body>
</html>