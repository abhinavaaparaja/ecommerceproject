<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp" %>

<%@ include file="script.jsp" %>
<style>
 .table-striped>tbody>tr:nth-child(odd)>td, 
.table-striped>tbody>tr:nth-child(odd)>th {
   background-color: #bfd7ff;
 }
 .table-striped>tbody>tr:nth-child(even)>td, 
.table-striped>tbody>tr:nth-child(odd)>th {
   background-color: #c7fccd;
 }
</style>

 </head>
<body>

Product form
<br>
<%@ include file="admin_navibar.jsp" %>
<br>
<%@ include file="message.jsp" %>





<div class="container"  style="margin-top:50px">
	
	<div class="container" style="background-color:#ffb3b3;border-radius:10px;">
<spring:form action="reqAdminSendProductDataToDB" modelAttribute="productObj" enctype="multipart/form-data">
	<div class="col-sm-3 col-wrap">
					Product Name 
					<br><spring:input path="productname" /> <spring:errors path="productname" style="color:red;"></spring:errors>
	
				</div>
				<div class="col-sm-3 col-wrapr">	
					Product Description
					<br><spring:input path="productdescription" /> <spring:errors path="productdescription" style="color:red;"></spring:errors>
	
				</div>
				<div class="col-sm-3 col-wrap">	
					Select Image : 
					<br><spring:input type="file" path="imageFile" />
				</div>
				<div class="col-sm-3 col-wrap">	
					<spring:button>Add Product</spring:button>
					
				</div>	
					<br>
		</spring:form>
	<hr>
</div>

<table class="table table-striped fixed_headers" id="tablesortsearch">
	<thead>
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Product Description</th>
			<th>IsProductavaiable</th>
			<th>Image</th>
			<th>Options</th>
		</tr>
	</thead>
	<br>
	<tbody>
		<c:forEach items="${product}" var="p">
			<tr>
				<td>${p.productid}</td>
				<td>${p.productname}</td>
				<td>${p.productdescription}</td>
				<td>${p.isproductavaliable}</td>
				<td><img src="resources/Products/${p.productid}.jpg" height="100" width="120"></td>
				<td><a href="reqAdminEditProductPage?productid=${p.productid}">
				<span class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span>
				</a>
			
			<a href="reqAdminDeleteProductPage?productid=${p.productid}">
			<span class="glyphicon glyphicon-trash btn btn-warning btn-large"></span>
			</a>
		
			</tr>
		</c:forEach>
		<%@ include file= "footer.jsp" %>
	</tbody>
</table>
</body>
</html>