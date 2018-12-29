<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp" %>



<style>

.row-flex {
  display:flex;
  flex-wrap:wrap;   
}
.col-wrap{
overflow-wrap:break-word;
justify-content: space-between;
}
.brdr{
 	
    border-radius:15px;
   }
   .zoom {  	
    transition: transform .04s; 
}
.zoom:hover {
	background-color:rgba(255,192,192,0.4);
	border-radius:10px;
	padding-bottom:10px;
    transform: scale(1.15); 
}
</style>

</head>


<body>

<%@ include file="guest_navibar.jsp" %>
<div class="container" style="margin-top:100px">

<%@ include file ="message.jsp" %>
<div class="row row-flex">

<div class="col-sm-5" style="background-color:#ff8080; border-radius:13px;">
 <div class="conatiner">
 
 
 <div class="col-sm-12" style="text-align:center; font-size:40px; font-weight:bold;color:black;">
			SignUp Page
		</div>
 <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#basic">Basic</a></li>
    <li><a data-toggle="tab" href="#address">Address</a></li>
 </ul>
 
 <spring:form modelAttribute="customer" action="reqSendSignupToDB" enctype="multipart/form-data" method="post">
	<spring:hidden path="billingAddress.houseno"/>
	<spring:hidden path="cart.cartid"/>
	
 
 
 <div class="tab-content" style="padding-bottom:10px">
 	<div id="basic" class="tab-pane fade in active">
 		<div style="margin-top:20px"></div>
 		
 		<div class="form-group" style="text-align:left">
   			 <label>Customer Name</label>
   			 <spring:input path="custname" class="form-control" placeholder="Enter Customer Name"/>  		
   		</div>
   		<spring:errors path="custname" style="color:red;"/>
   		
 		<div class="form-group" style="text-align:left">
   			 <label>Customer Email ID</label>
   			 <spring:input path="custemailid" class="form-control" placeholder="Enter Customer E-Mail ID"/>  		
   		</div>   		
     	<spring:errors path="custemailid" style="color:red;"/>
     	
 		<div class="form-group" style="text-align:left">
   			 <label>Customer Mobile No.</label>
   			 <spring:input path="custmobileno" class="form-control" placeholder="Enter Customer Mobile No."/>  		
   		</div>  
   		<spring:errors path="custmobileno" style="color:red;"/>		
	
 		<div class="form-group" style="text-align:left">
   			 <label>Customer picture</label>
   			 <spring:input type="file" path="imageFile"/>   		
   		</div>  
   		
 		<div class="form-group" style="text-align:left; padding-top:25px">
   			 <label>Password</label>
   			 <spring:input type="password" class="form-control" path="userDetails.password"/>   		
   		</div>  	
		<spring:errors path="userDetails.password" style="color:red;"/>	
     	
     
    </div>
    <div id="address" class="tab-pane fade">
    	<div style="margin-top:10px"></div>
    	<div class="col-sm-3 form-group" style="text-align:left">
   			 <label>House No.</label>
   		</div>
   		<div class="col-sm-9 form-group" style="text-align:left">	
   			 <spring:input path="shippingAddress.houseno" class="form-control" placeholder="Enter House No."/>  		
   		</div>
    	<div class="col-sm-3 form-group" style="text-align:left">
   			 <label>Street No.</label>
   		</div>
   		<div class="col-sm-9 form-group" style="text-align:left">	
   			 <spring:input path="shippingAddress.street" class="form-control" placeholder="Enter Street No."/>  		
   		</div>   		
    	<div class="col-sm-3 form-group" style="text-align:left">
   			 <label>Area</label>
   		</div>
   		<div class="col-sm-9 form-group" style="text-align:left">	
   			 <spring:input path="shippingAddress.area" class="form-control" placeholder="Enter Area"/>  		
   		</div>     	
    	<div class="col-sm-3 form-group" style="text-align:left">
   			 <label>City</label>
   		</div>
   		<div class="col-sm-9 form-group" style="text-align:left">	
   			 <spring:input path="shippingAddress.city" class="form-control" placeholder="Enter City"/>  		
   		</div>     	
    	<div class="col-sm-3 form-group" style="text-align:left">
   			 <label>State</label>
   		</div>
   		<div class="col-sm-9 form-group" style="text-align:left">	
   			 <spring:input path="shippingAddress.state" class="form-control" placeholder="Enter State"/>  		
   		</div>	
    	<div class="col-sm-3 form-group" style="text-align:left">
   			 <label>Country</label>
   		</div>
   		<div class="col-sm-9 form-group" style="text-align:left">	
   			 <spring:input path="shippingAddress.country" class="form-control" placeholder="Enter Country"/>  		
   		</div>		
    	<div class="col-sm-3 form-group" style="text-align:left">
   			 <label>Pincode</label>
   		</div>
   		<div class="col-sm-9 form-group" style="text-align:left">	
   			 <spring:input path="shippingAddress.pincode" class="form-control" placeholder="Enter Pincode"/>  		
   		</div>
	
	<br> <spring:button class="btn" style="width:100%;font-size:25px">Signup </spring:button>
	<br>
	
	<spring:errors path="*" style="color:red;"/>
    </div>
 </div>
  
  </spring:form>
    </div>
    
    
</div>
<div class="col-sm-7">	
 	<%@ include file="carosal.jsp" %>
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
							<a href="reqGuestMoreSuppliersForProduct?pid=${v.productid}">
							
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
						<a href="reqGuestMoreSuppliersForProduct?pid=${v.productid}">
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


</div>
</div>
<%@ include file="footer.jsp" %>

</body>
</html>