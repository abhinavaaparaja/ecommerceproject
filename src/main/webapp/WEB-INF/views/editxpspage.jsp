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
EDITPAGE!!!!
<%@ include file="admin_navibar.jsp" %>
<div class="container" style="margin-top:50px">
<spring:form  action ="reqAdminUpdateXPS" modelAttribute="Xps"  enctype="multipart/form-data">
	XPS Id<spring:hidden path="xpsid"/>
	<br>
	XPS Price<spring:input path="xpsprice"/>  <br>
	XPS Stock<spring:input path="xpsstock"/> <br>
	<spring:radiobutton path="xpsisavaliable" value="true"/>true
	<br>
	<spring:radiobutton path="xpsisavaliable" value="false"/>false
	<br>
	<spring:button>Add XPS</spring:button>

	</spring:form>
<table class="table table-stripped fixed_headers" id="tablesortsearch">
		<tr>
			<th>XPS ID</th>
			<th>Product</th>
			<th>Supplier</th>
			<th>XPS Price</th>
			<th>XPS Stock</th>
			<th>XPS Available</th>
		
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
</tr>
</c:forEach>
</tbody>
</table>
</div>


</body>
</html>