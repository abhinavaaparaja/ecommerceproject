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
XPS PAGE!!!
<br>

<%@ include file="admin_navibar.jsp" %>
<div class="container"  style="margin-top:50px">
	<%@ include file="message.jsp" %>
<div class="container">		
			<div class="col-sm-12">
				<b>Select Supplier and click Next to add new XPS record.</b>
				</div>
				</div>

	<div class="container" style="background-color:#ffb3b3;border-radius:10px;">
<form action="reqAdminGetProudctsForSupplierXPS" method="post">
<br>
	<select name="supid">
		<c:forEach items="${supplier}" var="s">
			<option value="${s.supplierid}">${s.supplierid}-${s.suppliername}</option>
		</c:forEach>
		</select>
	
	
	<input type="submit" value="Get Products"/>
	
</form>
		</div>	
<hr>

</div>
<br>
XPS Data

	<thead>
	<table class="table table-stripped fixed_headers" id="tablesortsearch">
		<tr>
			<th>XPS ID</th>
			<th>Product</th>
			<th>Supplier</th>
			<th>XPS Price</th>
			<th>XPS Stock</th>
			<th>XPS Available</th>
			<th>Option</th>
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${xps}" var="x"> 
			<tr>
				<td>${x.xpsid}</td>
				<td>${x.productid}</td>
				<td>${x.supplierid}</td>
				<td>${x.xpsprice}</td>
				<td>${x.xpsstock}</td>
				<td>${x.xpsisavaliable}</td>				
				<td><a href="reqAdminEditXPS?xpsid=${x.xpsid}">
					<span class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span>
					</a> 
				<a href="reqAdminDeleteXPS?xpsid=${x.xpsid}">
					<span class="glyphicon glyphicon-trash btn btn-warning btn-large"></span>
					</a>
			</tr>
		</c:forEach>
		
	</tbody>
</table>

</body>


</body>
</html>