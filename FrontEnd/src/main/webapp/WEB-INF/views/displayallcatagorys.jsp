<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="header.jsp"%>
<title>Category-Display</title>

</head>
<body>
	<br> <br> <br>
	<div class="row">
		<div class="col-sm-5"></div>
		<div class="col-sm-3">
			<a href=<c:url value="/admin/Addcatagory"/> role="button"
				class="btn btn-info">Add Catagory</a>
		</div>
		<br> <br>
	</div>


	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><h3>ID</h3></th>
					<th><h3>Catagory Name</h3></th>
					<th><h3>Delete</h3></th>
					<th><h3>Update</h3></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${up}" var="pro">
					<tr>
						<td>${pro.getCid()}</td>
						<td>${pro.getCatagoryname()}</td>
						<c:url value="/admin/deleteCatagory/${pro.cid}" var="urldel" />
						<td><a href="${urldel}" class="btn btn-danger" role="button">Delete</a></td>
						<c:url value="/admin/updateCatagory/${pro.cid}" var="urlupdate" />
						<td><a href="${urlupdate}" class="btn btn-primary" role="button">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>