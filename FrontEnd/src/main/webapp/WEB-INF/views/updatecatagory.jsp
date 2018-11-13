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
<c:url value="/admin/Addcat" var="url"/>
	<form:form method="post" action="${url}">
		<table>
			<tr>
				<td><form:hidden path="cid" /></td>
			</tr>
			<tr>
				<td><form:label path="catagoryname">Enter Catagory Name</form:label>
				</td>
				<td><form:input path="catagoryname" type="text"  />
				<form:errors path="catagoryname" cssStyle="color:red"></form:errors>
				</td>
			<tr>
			<%-- <tr>
				<td><form:label path="description">Enter Description</form:label>
				</td>
				<td><form:textarea path="description" />
				<form:errors path="description" cssStyle="color:red"></form:errors>
				</td>
			<tr> --%>
			<tr>
				<td><input type="submit" value="Edit Catagory"></td>
				</tr>
		</table>
	</form:form>
</body>
</html>