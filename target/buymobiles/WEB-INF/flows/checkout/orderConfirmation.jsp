<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<html>
<head>
<%@ include file="/WEB-INF/views/links.jsp"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(new Date());
%>
<%@ include file="/WEB-INF/views/user_navibar.jsp"%>

</head>

<body>



	<div class="container" style="margin-top: 50px">
		<div class="page-header">
			<h1>Order</h1>

			<p class="lead">Order confirmation</p>
		</div>

		<div class="container">

			<div class="row">

				<spring:form commandName="order" class="form-horizontal">

					<div
						class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

						<div class="txt-center">
							<h1>Receipt</h1>
						</div>
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Shipping Address</strong><br />
									${order.cart.customer.shippingAddress.street} <br />
									${order.cart.customer.shippingAddress.city},
									${order.cart.customer.shippingAddress.state} <br />
									${order.cart.customer.shippingAddress.country},
									${order.cart.customer.shippingAddress.pincode}
								</address>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 text-right">
								<p>
									Order Date: <b><%=date%></b>
								</p>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Billing Address</strong><br />
									${order.cart.customer.billingAddress.street} <br />
									${order.cart.customer.billingAddress.city},
									${order.cart.customer.billingAddress.state} <br />
									${order.cart.customer.billingAddress.country},
									${order.cart.customer.billingAddress.pincode}
								</address>
							</div>
						</div>

						<div class="row">
							<table class="table table-hover">
								<thead>
									<tr>
										<td>Product</td>
										<td>Supplier</td>
										<td>No.of Items</td>
										<td class="text-center">Price</td>
										<td class="text-center">Total</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="cartItem"
										items="${cartItemsCheckout.vwCartItems}">

										<tr>
											<td class="col-md-4"><em> ${cartItem.productid} <br>
													${cartItem.productname} <br><img src="resources/Products/${cartItem.productid}.jpg" height="100" width="120"></td>



											</em></td>
											<td class="col-md-4"><em> ${cartItem.supplierid} <br>
													${cartItem.suppliername} <br><img src="resources/suppliers/${cartItem.supplierid}.jpg" height="100" width="120"></td>

											</em></td>
											<td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
											<td class="col-md-1" style="text-align: center">${cartItem.xpsprice}</td>
											<td class="col-md-2" style="text-align: center">${cartItem.quantity * cartItem.xpsprice}</td>
										</tr>
									</c:forEach>

									<tr>
										<td></td>
										<td></td>
										<td class="text-right">
											<h4>
												<strong>Grand Total:</strong>
											</h4>
										</td>
										<td class="text-center">

											<h4>
												<strong><i class="fa fa-rupee"
													style="font-size: 25px"></i> ${order.cart.grandtotal}</strong>
											</h4>
										</td>
									</tr>

								</tbody>
							</table>
						</div>


						<input type="hidden" name="_flowExecutionKey" /> <br />
						<br />

						<button class="btn btn-default"
							name="_eventId_backToCollectShippingDetail">Back</button>

						<input type="submit" value="Submit Order" class="btn btn-default"
							name="_eventId_orderConfirmed" />

						<button class="btn btn-default" name="_eventId_cancel">Cancel</button>
					</div>
				</spring:form>
				<%@ include file= "/WEB-INF/views/footer.jsp" %>
			</div>
		</div>
	</div>
</body>
</html>
