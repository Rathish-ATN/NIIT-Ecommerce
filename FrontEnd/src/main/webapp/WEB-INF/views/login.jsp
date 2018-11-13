<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="header.jsp"%>
<title>Login</title>
</head>
<body>
	<h1>Login</h1>

	<form action="<c:url value='/j_spring_security_check'></c:url>"
		method="post">
		<table style="with: 50%">
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" type="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>