<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier Registration</title>
</head>
<body>
	<h1>Register Here</h1>
	 <c:url value="/admin/Addsupp" var="url"/>
	<form:form action="${url}" method="post"> 
		<table style="with: 50%">
			<tr>
				<td>Supplier Name</td>
				<td><form:input path="suppliername" type="text" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" type="text" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" type="text" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
		</form:form>
</body>
</html>