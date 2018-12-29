<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp" %>
<%@ include file="script.jsp" %>
</head>
<body>
<h2>EditPage!!!</h2>
<%@ include file="admin_navibar.jsp" %>

<div class="container"  style="margin-top:50px">

<spring:form  action ="reqAdminUpdateProductPage" modelAttribute="products"  enctype="multipart/form-data">
	<spring:hidden path="productid"/>
	<br>
	Product Name<spring:input path="productname"/> <br>
	Product Description<spring:input path="productdescription"/> <br>
	<spring:radiobutton path="isproductavaliable" value="true"/>true
	<br>
	<spring:radiobutton path="isproductavaliable" value="false"/>false
	<br>
	<spring:button>Add Product</spring:button>

	</spring:form>
	
<table class="table table-stripped fixed_headers" id="tablesortsearch">
	<thead>
		<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Product Description</th>
			<th>IsProductavaiable</th>
			<th>Image</th>
			
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
				<td><img src="resources/images/${p.productid}.jpg" height="100" width="120"></td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		
</body>
</html>