<html lang="en">
<head>
<%@ include file="header.jsp" %>
<link rel="stylesheet" href="<c:url value='/resources/css/displayproduct.css'></c:url>">
<script type="text/javascript" src="<c:url value='/resources/javascript/displayproduct.js'/>"></script>
<style>
/*
** Style Simple Ecommerce Theme for Bootstrap 4
** Created by T-PHP https://t-php.fr/43-theme-ecommerce-bootstrap-4.html
*/
.bloc_left_price {
    color: #c01508;
    text-align: center;
    font-weight: bold;
    font-size: 150%;
}
.category_block li:hover {
    background-color: #007bfg;
}
.category_block li:hover a {
    color: #ffffff;
}
.category_block li a {
    color: #343a40;
}
.add_to_cart_block .price {
    color: #c01508;
    text-align: center;
    font-weight: bold;
    font-size: 200%;
    margin-bottom: 0;
}
.add_to_cart_block .price_discounted {
    color: #343a40;
    text-align: center;
    text-decoration: line-through;
    font-size: 140%;
}
.product_rassurance {
    padding: 10px;
    margin-top: 15px;
    background: #ffffff;
    border: 1px solid #6c757d;
    color: #6c757d;
}
.product_rassurance .list-inline {
    margin-bottom: 0;
    text-transform: uppercase;
    text-align: center;
}
.product_rassurance .list-inline li:hover {
    color: #343a40;
}
.reviews_product .fa-star {
    color: gold;
}
.pagination {
    margin-top: 20px;
}
footer {
    background: #343a40;
    padding: 40px;
}
footer a {
    color: #f8f9fa!important
}

</style>
<title>Display Product</title>
</head>
<body>


<form action="<c:url value= "/cart/addtocart/${p.id}"/>" var="url">
	<div class="container">
		<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="preview col-md-6">

						<div class="preview-pic tab-content">
							<div class="tab-pane active" id="pic-1">
								<img src="<c:url value="/resources/image/${p.id}.png"/>" class="img-responsive">
							</div>
						</div>

					</div>
					<%--  --%>
					<div class="details col-md-6">
						<h2 class="product-title">${p.getProductname()}</h2>
						<br>
						<p class="product-description"><h3>Product Description: <br> ${p.getDescription()}</h3></p>
						
						
						<div class="form-group">
                            <label>Quantity :</label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
                                        <i class="fa fa-minus"></i>
                                    </button>
                                </div>
                                <input type="number" class="form-control"  id="requestedQuantity" name="requestedQuantity" min="1" max=${p.getQuantity()} value="1">
                                <div class="input-group-append">
                                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
                                        <i class="fa fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                        
                        
						<div class="action">
							<!-- <button class="add-to-cart btn btn-default" type="button">add to cart</button> -->
							<%-- <security:authorize access="hasRole('ROLE_USER)"> --%>
							<input type="submit" class="add-to-cart btn btn-default" role="button" value="ADD TO CART" />
							<%-- <a href="<c:url value= "/cart/addtocart/${p.id}"/>" class="add-to-cart btn btn-default" role="button">ADD TO CART</a> --%>
							
							<br>
							<br>
							<h3>Category: ${c.getCatagoryname()}</h3>
							<br>
						
							<h3>Price: ${p.getPrice()}</h3>
						</div>
					</div>
				
				</div>
			</div>
		</div>
	</div>
</form>	
<script>
$(document).ready(function(){
    var requestedQuantity = 1;

    $('.quantity-right-plus').click(function(e){
        e.preventDefault();
        var requestedQuantity = parseInt($('#requestedQuantity').val());
        $('#requestedQuantity').val(requestedQuantity + 1);
    });

    $('.quantity-left-minus').click(function(e){
        e.preventDefault();
        var requestedQuantity = parseInt($('#requestedQuantity').val());
        if(requestedQuantity > 1){
            $('#requestedQuantity').val(requestedQuantity - 1);
        }
    });

});
</script>
</body>
</html>

