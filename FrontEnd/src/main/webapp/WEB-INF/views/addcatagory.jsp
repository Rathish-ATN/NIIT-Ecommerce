<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Catagory</title>
</head>
<body>
	<h1>Catagory </h1>
	 <c:url value="/admin/Addcat" var="url"/>
	<form:form action="${url}" method="post">
		<table style="with: 50%">
			<tr>
			
				<td>Catagory Name</td>
				<td><form:input path="catagoryname" type="text" /></td>
			</tr>
			<%-- <tr>
				<td>Description</td>
				<td><form:input path="description" type="text" /></td>
			</tr> --%>
			
		</table>
		<input type="submit" value="Submit" />
		</form:form>
</body>
</html>