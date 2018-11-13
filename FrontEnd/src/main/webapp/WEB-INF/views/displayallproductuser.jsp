<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%@ include file="header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Products</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/dallpuser.css'></c:url>">

</head>
<body>
<br> <br>
	<script src="/resources/javascript/reg.js"></script>
	<table border=1>
		<c:forEach items="${up}" var="pro">
			<div class="col-md-2 column productbox" >
				<img src="<c:url value="/resources/image/${pro.id}.png"/>" style="width=:460; height:250;" class="img-responsive">
				<div class="producttitle">${pro.getProductname()}</div>
				<div class="productprice">
					<div class="pull-right">
						<a href="<c:url value= "/displayProduct/${pro.id}"/>" class="btn btn-danger btn-sm" role="button">BUY</a>
					</div>
					<div class="pricetext">INR : ${pro.getPrice()}</div>
				</div>
			</div>
		</c:forEach>
	</table>
</body>
</html>