<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Homepage</title>
<%@ include file="header.jsp" %>
</head>
<body>

<div class="container">
  <h2>Carousel Example</h2>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="resources/images/shopping1.jpg" alt="Shop3" style="width:100%height:100%;">
        <div class="carousel-caption">
          <h3>Shopping</h3>
          <p>Shopping is always so much fun!</p>
        </div>
      </div>

      <div class="item">
        <img src="resources\images\shopping2.jpg" alt="Shop2" style="width:100%height:100%;">
        <div class="carousel-caption">
          <h3>Electronics</h3>
          <p>Thank you, Customers!</p>
        </div>
      </div>
    
      <div class="item">
        <img src="resources\images\shopping3.jpg" alt="Shop1" style="width:100%height:100%;">
        <div class="carousel-caption">
          <h3>Shopping</h3>
          <p>Shopping Life!</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>

</body>
</html>