<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Access</title>
<%@ include file="header.jsp"%>
</head>
<body>
<br>
<br>
<br>
<br>
    <div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-2"><a href="<c:url value='/admin/displayallcatagory'/>"class="btn btn-primary" role="button"><h4> Category </h4></a></div>
    <div class="col-sm-4"></div>
    <div class="col-sm-2"><a href="<c:url value='/admin/displayallproduct'/>"class="btn btn-primary" role="button"><h4> Product  </h4></a></div>
 </div>
</body>
</html>