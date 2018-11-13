<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Shopping</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<li class="navbar-brand"><a href="<c:url value='/'/>">Online Shopping</a></li>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/FrontEnd/">Home</a></li>
					<li><a href="#">Catagories</a></li> -->

					<!-- <li><div class="dropdown">
							<button class="btn btn-default btn-sm dropdown-toggle" type="button"
								data-toggle="dropdown">
								Catagories <span class="caret"></span>
							</button>
							<ol class="dropdown-menu"> -->

								<li><a href="<c:url value= "/displayallproduct"/>">Display
										All Products</a></li>
								<!-- <li><a href="#">CSS</a></li>
								<li><a href="#">JavaScript</a></li>
							</ol>
						</div></li> -->

					<li><a href="aboutus">About</a></li>
					<li><a href="#">Contact</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${pageContext.request.userPrincipal.name ==null}">
						<!-- check if principal object is null -->
						<li><a href="<c:url value= "/register"/>"><span
								class="glyphicon glyphicon-registration-mark"></span> Register</a></li>
						<li><a href="<c:url value= "/login"/>"><span
								class="glyphicon glyphicon-log-in"></span> Log In</a></li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name!=null }">
						<li><security:authorize access="hasRole('ROLE_ADMIN')">
								<li><a href="<c:url value="/admin"></c:url>">Admin</a></li>
							</security:authorize></li>
						<li><a>Welcome ${pageContext.request.userPrincipal.name }</a></li>
						<li><a href="<c:url value='/cart/purchasedetails'></c:url>"><span
								class="glyphicon glyphicon-shopping-cart"></span>(${sessionScope.cartSize })</a></li>
						<li><a
							href="<c:url value='/j_spring_security_logout'></c:url>">Sign
								out</a></li>
					</c:if>
					<!--  <li><a href="<c:url value= "register"/>"><span class="glyphicon glyphicon-registration-mark"></span> Register</a></li>
        <li><a href="<c:url value= "login"/>"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li> -->
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>