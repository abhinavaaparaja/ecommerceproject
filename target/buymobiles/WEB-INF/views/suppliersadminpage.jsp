<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp"%>
<%@ include file="links.jsp" %>
<%@ include file="script.jsp" %>
</head>
<%@ include file="admin_navibar.jsp"%>
<body>
	<br>
<%@include file="message.jsp" %>
	


	<div class="container" style="margin-top: 50px">
				<div class="container">
<div class="container" style="background-color:#ffb3b3;border-radius:10px;">
			<spring:form action="reqAdminSendSupplierDataToDB"
				modelAttribute="supplierObj" enctype="multipart/form-data">

				<div class="col-sm-4 col-wrap">
				Supplier Name <br>
				<spring:input path="suppliername" /><spring:errors path="suppliername" style="color:red;"></spring:errors>
			</div>
			<div class="col-sm-3 col-wrap">
				Supplier Description <br>
				<spring:input path="supplierdescription" /> <spring:errors path="supplierdescription" style="color:red;"></spring:errors>
			</div>
			<div class="col-sm-3 col-wrap">
				Select Image : <br>
				<spring:input type="file" path="imageFile" />
			</div>
			<div class="col-sm-2 col-wrap">
			</div>
			<spring:button>Add Supplier</spring:button>
			</spring:form>
			</div>
			</div>
			
		
			<table class="table table-stripped fixed_headers" id="tablesortsearch">
	
			
				<thead>
					<tr>
						<th>Supplier ID</th>
						<th>Supplier Name</th>
						<th>Supplier Desc</th>
						<th>Is Supplier Available</th>
						<th>Image</th>
						<th>Option</th>
					</tr>
				</thead>
				<br>
				
				<tbody>
					<c:forEach items="${supplier}" var="s">
						<tr>
							<td>${s.supplierid}</td>
							<td>${s.suppliername}</td>
							<td>${s.supplierdescription}</td>
							<td>${s.isavaliable}</td>
							<td><img src="resources/suppliers/${s.supplierid}.jpg"
								height="50" width="80" />
							<td><a href="reqAdminEditSupplier?sid=${s.supplierid}">
									<span
									class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span>
							</a> <a href="reqAdminDeleteSupplier?sid=${s.supplierid}"> <span
									class="glyphicon glyphicon-trash btn btn-warning btn-large"></span>
							</a>
						</tr>
					
					</c:forEach>
					<%@ include file= "footer.jsp" %>
				</tbody>
			
			</table>
</body>

</body>
</html>