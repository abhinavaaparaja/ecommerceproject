<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@  include file="links.jsp"%>
</head>


<body>
	<%@ include file="user_navibar.jsp"%>
	<div class="container" style="margin-top:150px">
	
	<%@ include file="message.jsp" %>
	</div>
	
	<div class="container">
	<div class="row row-flex">
			
	<c:forEach items="${views}" var ="v">
	
	<div class="col-sm-4 col-wrap" style="padding-bottom:35px;">
			 <div class="col-sm-1"></div>
			 <div class="col-sm-10 zoom" style="text-align:center">	
				<div class="row row-flex" style="color:black;display:inline-block">	
					<div class="col-sm-6" style="text-align:left">
						<c:if test="${v.xpsstock>=10}">	
							<a href="reqmoredetails?pid=${v.productid}">
							
								<img src="resources/Products/${v.productid}.jpg" height="120" width="180" style="padding-top:10px"	/>
							</a>
						</c:if>
						<c:if test="${v.xpsstock<10}">	
							<img src="resources/Products//${v.productid}.jpg" height="120" width="180"
							style="opacity: 0.3;"/>								
						</c:if>
					</div>
					<div class="col-sm-6" style="text-align:right">
						<c:if test ="${v.no_rating>=1}">
							
							<div style="font-size:20px; padding-top:25px; vertical-align:middle">									
								<c:if test="${v.product_ratings>=3.8}">
										<span class="label label-success">
											<i class="glyphicon glyphicon-star"></i><b>${v.product_ratings} </b>
										</span>
								</c:if>
								<c:if test="${v.product_ratings<1.5 && v.product_ratings>=2.8}">
										<span class="label label-warning">
											<i class="glyphicon glyphicon-star"></i><b>${v.product_ratings} </b>
										</span>
								</c:if>
								<c:if test="${v.product_ratings<2.8}">
										<span class="label label-danger">
											<i class="glyphicon glyphicon-star"></i><b>${v.product_ratings} </b>
										</span>
								</c:if>							
							</div>
							
							<div style="font-size:12px; padding-top:10px">
								${v.no_rating} ratings
							</div>
							<div style="font-size:12px;">
								${v.no_itemssold} items sold
							</div>
						</c:if>			
					</div>
				</div>
				
				<div class="row row-flex" style="color:black;padding-top:10px;text-align:left;" >	
					<div class="col-sm-12" >
						Name : <b>${v.productname}</b>
						<br>
						Supplier : <b>${v.suppliername}</b>							
					</div>
					<div class="col-sm-8" >
						Best Price : <b> <i class="fa fa-rupee"></i> ${v.xpsprice}</b>	
						<br>
						<div style="padding-top:5px;" >
						<a href="reqmoredetails?pid=${v.productid}">
							<span class="label label-primary" style="font-size:13px">						
								More Details
							</span>
						</a>	
						</div>
					</div>				
					<div class="col-sm-3" style="background-color:#ccebff; border-radius:10px;text-align: center">
						
						<c:if test="${v.xpsstock>=10}">												
							<a href="reqUserAddXpsToCart?xpsid=${v.xpsid}">
								<span class="glyphicon glyphicon-shopping-cart" style="font-size:30px;color:#0066cc; padding-top:2px">
								</span>
								
							</a>
							
						</c:if>
						<c:if test="${v.xpsstock<10}">
							<div style="color:blue">						
							Out of stock
							</div>
						</c:if>
						
					</div>
					<div class="col-sm-1"></div>
				</div>
				 </div>
			   <div class="col-sm-1"></div>
			</div>
		
		
		</c:forEach>
	
	</div>
</div>

<%@ include file="footer.jsp"%>
	
</body>
</html>