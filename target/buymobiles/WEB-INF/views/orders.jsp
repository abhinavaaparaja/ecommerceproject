<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp" %>

</head>
<body>
<%@ include file="user_navibar.jsp" %>


<div class="container"  style="margin-top:100px">
	<%@ include file="message.jsp" %>
	
 <table class="table table-stripped fixed_headers" id="tablesortsearch">>
	<thead>
		<tr>
		<th>orderid</th>
			<th>customerid</th>
			<th>orderdate</th>
			<th>noitems</th>
			<th>ordertotal</th>
			<th>shippingAddress</th>
			
		</tr>
	</thead>
	<br>
	<tbody>
		<c:forEach items="${orders}" var="o">
			<tr>
			<td>
			<a href="reqOrderDetails?orderid=${o.orderid}">${o.orderid}</a>
			</td>
				<td>${o.customerid}</td>
				<td>${o.orderdate}</td>
				<td>${o.noitems}</td>
				<td>${o.ordertotal}</td>
				<td>${o.shippingAddress}</td>
				</tr>
		</c:forEach>
		<%@ include file= "footer.jsp" %>
		</tbody>
		</table>
		

	
	
</body>
</html>