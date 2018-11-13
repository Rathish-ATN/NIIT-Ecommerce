<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display All suppliers</title>
</head>
<body>
<table border=1>
<tr><th><h3>ID</h3></th>
<th><h3>Name</h3></th>
<th><h3>Address</h3></th>
<th><h3>Email</h3></th>
<th>DELETE</th>
<th>UPDATE</th></tr>
<c:forEach items="${up}" var="sup">
<tr><td><h3>${sup.getId()}</h3> </td>
<c:url value="/admin/displaySupplier/${sup.id}" var="urldis"/>
<td><h3><a href="${urldis}">${sup.getSuppliername()}</a></h3></td>
<td><h3>${sup.getAddress()}</h3></td>
<td><h3>${sup.getEmail()}</h3></td>
<c:url value="/admin/deleteSupplier/${sup.id}" var="urldel"/>
<td><a href="${urldel}">DEL </a></td>
<c:url value="/admin/updateSupplier/${sup.id}" var="urlupdate"/>
<td><a href="${urlupdate}">EDIT </a></td></tr>
</c:forEach>
</table>
</body>
</html>