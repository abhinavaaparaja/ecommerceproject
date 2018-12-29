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


	<div class="container" style="margin-top: 100px">
		<%@ include file="message.jsp"%>
<div class="container">
			<div class="col-sm-2">
				Order ID <br>
				<b>${order.orderid}</b>
			</div>
			<div class="col-sm-2">
				Order Date <br>
				<b>${order.orderdate}</b>
			</div>
			<div class="col-sm-2">
				No.of Items ordered <br>
				<b>${order.noitems}</b>
			</div>
			<div class="col-sm-2">
				Order Total <br>
				<b>${order.ordertotal}</b>
			</div>
			<div class="col-sm-4">
				Shipping address <br>
				<b>${order.shipmentAddress}</b>
			</div>			
		</div>		
			<div class="container" style="margin-top: 20px">
				<div class="col-sm-12">
					
		<table class="table table-stripped fixed_headers" id="tablesortsearch">
			<thead>
				<tr>
								<th style="text-align:center">OrderDetails ID</th>
								<th style="text-align:center">Product</th>
								<th style="text-align:center">Supplier</th>
								<th style="text-align:center">Quantity</th>
								<th style="text-align:center">Price</th>
								<th style="text-align:center">Itemwise Total</th>	
								<th style="text-align:center">Rating </th>	
								<th style="text-align:center">Review</th>																				
							</tr>
						</thead>						
						<tbody style="text-align:center">
											
				<c:forEach items="${orderdetails}" var="od">
					<tr>
						<td style="vertical-align: middle">${od.orderDetid}</td>
						<td style="vertical-align:middle">
									<img src="resources/Products/${od.productid}.jpg" hight="80px" width="100px"/>
									 
									<br>${od.productname}								
									</td>
									<td style="vertical-align:middle">
									<img src="resources/suppliers/${od.supplierid}.jpg" hight="80px" width="100px"/>									
									<br>
									${od.suppliername}
									</td>
									<td style="vertical-align:middle">${od.quantity}</td>
									<td style="vertical-align:middle"><i class="fa fa-rupee"></i> ${od.productprice}</td>
									<td style="vertical-align:middle"><i class="fa fa-rupee"></i>${od.productprice * od.quantity}</td>
									
									
									
										<td style="vertical-align:middle">
										<c:if test="${od.isratinggiven==true}">
											${od.rating}
										</c:if>
									<c:if test="${od.isratinggiven==false}">	
						<form action="reqUserAddProductRatig" method="POST">
													
						<input type="radio" name="rating" value="5"/>5
						<input type="radio" name="rating" value="4"/>4
						<input type="radio" name="rating" value="3"/>3
						<input type="radio" name="rating" value="2"/>2
						<input type="radio" name="rating" value="1"/>1
																						
							<input type="submit" value="Give Rating"/>	
							<input type="text" value="${od.productid}"  hidden name="pid"/>
							<input type="text" value="${od.orderid}" hidden name="oid"/>
							<input type="text" value="${od.orderDetid}" hidden name="ordetid"/>										
						</form>									
											
			</c:if>									
			</td>
						<td style="vertical-align:middle">									
						<c:if test="${od.isreviewgiven==true}">
											${od.reviewtitle}
						</c:if>
						<c:if test="${od.isreviewgiven==false}">										
						<a href="reqUserReviewProductPage?ordetid=${od.orderDetid}">Review the product</a>
										</c:if>											
						</td>
						</tr>	
						</c:forEach>
						<%@ include file= "footer.jsp" %>
			</tbody>
		</table>
	</div>




						
</body>
</html>