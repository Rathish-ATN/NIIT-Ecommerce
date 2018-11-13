<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:url value="/admin/Addsupp" var="url"/>
	<form:form method="post" action="${url}">
		<table>
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="suppliername">Enter Supplier Name</form:label>
				</td>
				<td><form:input path="suppliername" type="text"  />
				<form:errors path="suppliername" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<tr>
				<td><form:label path="address">Enter Address</form:label>
				</td>
				<td><form:textarea path="address" />
				<form:errors path="address" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<tr>
				<td><form:label path="email"> Enter Email Id</form:label></td>
				<td><form:input path="email" />
				<form:errors path="email" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit Supplier"></td>
				</tr>
		</table>
	</form:form>
</body>
</html>