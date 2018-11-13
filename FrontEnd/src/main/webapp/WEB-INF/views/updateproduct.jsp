<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update product</title>
</head>
<body>

 <c:url value="/admin/Addprod" var="url"/>
	<form:form method="post" action="${url}" modelAttribute="product" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="productname">Enter Product Name</form:label>
				</td>
				<td><form:input path="productname" type="text"  />
				<form:errors path="productname" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<tr>
				<td><form:label path="description">Enter Product Description</form:label>
				</td>
				<td><form:textarea path="description" />
				<form:errors path="description" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<tr>
				<td><form:label path="price"> Enter price</form:label></td>
				<td><form:input path="price" />
				<form:errors path="price" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="quantity">Enter Quantity</form:label></td>
				<td><form:input path="quantity" />
				<form:errors path="quantity" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<%-- <tr>
			<td>Select Catagory</td>
			<td>		
			<form:select path="catagory.cid">
			 <c:forEach items="${catagories}" var="c" ><!-- c refers to an Object of type Category -->
			 <form:option value="${c.cid }">${c.catagoryname }</form:option>
			 </c:forEach>
			 </form:select>
			
			</td>
			</tr> --%>
			<tr>
			<td>Upload image for the product</td>
			<td><form:input path="image" type="file"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit Product"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>