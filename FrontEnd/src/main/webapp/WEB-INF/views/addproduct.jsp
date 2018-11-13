<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- <link href="/css/regformstyle.css" rel="stylesheet" id="bootstrap-css">-->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Add</title>
<%@ include file="header.jsp"%>
</head>
<body>
<!-- <div class="container"> --> 
<h1 class="well">Product Registration</h1>

								
 <c:url value="/admin/Addprod" var="url"/>
	<form:form action="${url}" modelAttribute="product" enctype="multipart/form-data" method="post"> 
	
	
		<table style="with: 50%">
	
			<tr>
				<td>Enter Product Name</td>
				<td><form:input path="productname" />
				<form:errors path="productname" cssStyle="color:red"></form:errors></td>
				</tr>
			<tr>
				<td>Description</td>
				<td><form:input path="description" type="text" /></td>
				<form:errors path="description" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="quantity" type="text" /></td>
				<form:errors path="quantity" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><form:input path="price" type="text" /></td>
				<form:errors path="price" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
			<td>Select Catagory</td>
			<td>
			
			 <form:select path="catagory.cid">
			 <c:forEach items="${catagories}" var="c" ><!-- c refers to an Object of type Category -->
			 <form:option value="${c.cid }">${c.catagoryname }</form:option>
			 </c:forEach>
			 </form:select>
			</td>
			</tr>
			<tr>
			<td>Upload image for the product</td>
			<td><form:input path="image" type="file"></form:input></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
		</form:form>
</body>
</html>