<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Invoice</title>
</head>
<body>



<div class="container">
    <div class="row">
        <div class="col-xs-12">
    		<div class="invoice-title">
    			<h2>Invoice</h2><h3 class="pull-right">Order Processed</h3>
    		</div>
    		<hr>
   
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Billed To:</strong><br>
    					${Invoicebind2.getName()}<br>
    					${Invoicebind1.getBillingaddress().getApartmentnumber()},${Invoicebind1.getBillingaddress().getStreetname()}<br>
    					${Invoicebind1.getBillingaddress().getCity()},${Invoicebind1.getBillingaddress().getState()}<br>
    					${Invoicebind1.getBillingaddress().getCountry()}-${Invoicebind1.getBillingaddress().getZipcode()}.
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
        			<strong>Shipped To:</strong><br>
    					${Invoicebind2.getName()}<br>
    					${Invoicebind1.getShippingaddress().getApartmentnumber()},${Invoicebind1.getShippingaddress().getStreetname()}<br>
    					${Invoicebind1.getShippingaddress().getCity()},${Invoicebind1.getShippingaddress().getState()}<br>
    					${Invoicebind1.getShippingaddress().getCountry()}-${Invoicebind1.getShippingaddress().getZipcode()}.
    				</address>
    			</div>
    		</div>

    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    					<!-- <strong>Payment Method:</strong><br>
    					Visa ending **** 4242<br>
    					jsmith@email.com -->
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
    					<strong>Order Date:</strong><br>
    					March 7, 2014<br><br>
    				</address>
    			</div>
    		</div>
    	</div>
    </div>
    
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Order summary</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Item</strong></td>
        							<td class="text-center"><strong>Price</strong></td>
        							<td class="text-center"><strong>Quantity</strong></td>
        							<td class="text-right"><strong>Totals</strong></td>
                                </tr>
    						</thead>
    						<tbody>
    						<c:set var="totalPrice" value="0"></c:set>
    							<c:forEach items="${Invoicebind}" var="inv">
    							<tr>
    								<td>${inv.getProduct().getProductname() }</td>
    								<td class="text-center">${inv.getTotalPrice()/inv.getQuantity() }</td>
    								<td class="text-center">${inv.getQuantity() }</td>
    								<td class="text-right">${inv.getTotalPrice() }</td>
    								<c:set var="totalPrice"
								value="${totalPrice + inv.totalPrice }"></c:set>
    							</tr></c:forEach>
                         
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Total</strong></td>
    								<td class="no-line text-right">${totalPrice}</td>
    							</tr>
    						</tbody>
    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</div>

</body>
</html>