<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="header.jsp"%>
<title>Product-Display</title>

</head>
<br> <br> <br>
	<div class="row">
		<div class="col-sm-5"></div>
		<div class="col-sm-3">
			<a href=<c:url value="/admin/Addproduct"/> role="button"
				class="btn btn-info">Add Product</a>
		</div>
		<br> <br>
	</div>

<body>

<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><h3>ID</h3></th>
					<th><h3>Image</h3></th>
					<th><h3>Name</h3></th>
					<th><h3>Description</h3></th>
					<th><h3>Quantity</h3></th>
					<th><h3>Price</h3></th>
					<th><h3>DELETE</h3></th>
					<th><h3>UPDATE</h3></th>
				</tr>
		
			</thead>
			<tbody>
				<c:forEach items="${up}" var="pro">
					<tr>
						<td><h4>${pro.getId()}</h4></td>
						<td><img src="<c:url value="/resources/image/${pro.id}.png"/>" width="100" height="100"/></td>
						<td><h4>${pro.getProductname()}</h4></td>
						<td><h4>${pro.getDescription()}</h4></td>
						<td><h4>${pro.getQuantity()}</h4></td>
						<td><h4>${pro.getPrice()}</h4></td>
						
						<c:url value="/admin/deleteProduct/${pro.id}" var="urldel" />
						<td><a href="${urldel}" class="btn btn-danger" role="button">Delete</a></td>
						<c:url value="/admin/updateProduct/${pro.id}" var="urlupdate" />
						<td><a href="${urlupdate}" class="btn btn-primary" role="button">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>
			