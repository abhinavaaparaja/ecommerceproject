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
<%@ include file="admin_navibar.jsp"%>
	<div class="container" style="background-color:#ffb3b3;color:blue; border-radius:10px;margin-top:50px">
		
			<div class="col-sm-12">Users Admin Page</div>
	<c:if test="${not empty message}">
		<div class="container">
			<c:if test="${message.messageType.equals('INF')}">
			<div class="alert alert-success alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Success!</strong> ${message.messageBody}
			</div>
			</c:if>
			<c:if test="${message.messageType.equals('ERR')}">
			<div class="alert alert-danger alert-dismissible">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				<strong>Error!</strong> ${message.messageBody}
			</div>
			</c:if>
		</div>
	</c:if>
		<div class="col-sm-12">
			<table class="table table-stripped fixed_headers" id="tablesortsearch">
				<thead>
					<tr>
						<th>Customer ID</th>
						<th>E-Mail ID</th>
						<th>Present Status</th>
						<th>Option</th>																
					</tr>
				</thead>
				<tbody >
					<c:forEach items="${custusers}" var="c">
						<tr>
							<td>${c.customerid}</td>
							<td>${c.custemailid}</td>
							<td>${c.enabled}</td>	
							<td>
							<c:if test="${c.enabled==true}">							
							<a href="reqAdminDisableCustomer?custid=${c.customerid}" class="btn btn-primary">
								Disable
							</a>
							</c:if>
							<c:if test="${c.enabled==false}">
							<a href="reqAdminEnableCustomer?custid=${c.customerid}" class="btn btn-primary">
								Enable
							</a>
							</c:if>
							
							
							</td>					
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>