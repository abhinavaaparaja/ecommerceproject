<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp"%>
<%@ include file="script.jsp"%>
</head>
<body>
	<%@ include file="user_navibar.jsp"%>

	<div class="container" style="margin-top: 150px">

		<%@ include file="message.jsp"%>



		<div class="col-sm-12" style="text-align: right">

<c:if test="${customer.cart.grandtotal!=0}">
			<button type="button" class="btn btn-success">GrandTotal:${customer.cart.grandtotal}</button>
			</c:if>
		</div>
		
		<!--  <button type="button" class="btn btn-info">Clear All Items From Cart</button>-->
		
		<div class="col-sm-12" style="text-align: left">
		
		
<c:if test="${customer.cart.grandtotal!=0}">
		<a href="reqclearcartitems?cartid=${customer.cart.cartid}" class="btn btn-info">clearcart</a>
		</c:if>
		</div>
		
				 	
				 	<table class="table table-stripped fixed_headers"
	id="tablesortsearch">


				<thead>
					<tr>
						<th style="text-align: center">Item</th>
						<th style="text-align: center">Supplier</th>
						<th style="text-align: center">Price</th>
						<th style="text-align: center">Quantity</th>
						<th style="text-align: center">Itemwise Total</th>
						<th style="text-align: center">Option</th>
					</tr>

				</thead>

				<tbody style="text-align: center">
					<c:forEach items="${cartitems}" var="ci">
						<tr>
							<td><img src="resources/Products/${ci.productid}.jpg"
								height="50" width="60" /> <br> ${ci.productname}</td>
							<td><img src="resources/suppliers/${ci.supplierid}.jpg"
								height="50" width="60" /> <br> ${ci.suppliername}</td>
							<td>${ci.xpsprice}</td>
							<td>${ci.quantity}<br> <c:if test="${ci.quantity<=4}">
									<a href="reqUserIncrQuantity?cartitemid=${ci.cartitemid}"
										class="label label-success"> <span
										class="glyphicon glyphicon-plus"></span>
									</a>
								
								</c:if> <c:if test="${ci.quantity>=5}">
									<span class="glyphicon glyphicon-plus"></span>
								</c:if> / <c:if test="${ci.quantity>=2}">
									<a href="reqUserDecrQuantity?cartitemid=${ci.cartitemid}"
										class="label label-warning"> <span
										class="glyphicon glyphicon-minus"></span>
									</a>
								</c:if> <c:if test="${ci.quantity<=1}">
									<span class="glyphicon glyphicon-minus"></span>
								</c:if>
							</td>
							<td>${ci.quantity * ci.xpsprice}</td>
							<td><a
								href="reqUserDeleteItemFromCart?cartitemid=${ci.cartitemid}"
								style="font-size: 20px"> <span
									class="glyphicon glyphicon-trash"></span>
									</a>	
									
						</tr>
						
						
						
					</c:forEach>
				</tbody>
			</table>
			
			<br><br>
			
		<div class="col-sm-12" style="text-align: center">
				 	<span class="btn btn-success" style="font-size:15px">
						<a href="reqCheckout?cartid=${customer.cart.cartid}">Check Out</a>
				 	</span>		
	
	</div>
<%@ include file= "footer.jsp" %>
</body>
</html>