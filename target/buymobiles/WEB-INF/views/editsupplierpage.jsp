<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp"%>
<%@ include file="script.jsp" %>
</head>
<body>
<h2>EDITPAGE!!!</h2>
<%@ include file="admin_navibar.jsp" %>
<div class="container"  style="margin-top:50px">

<spring:form  action ="reqAdminUpdateSupplier" modelAttribute="supplier"  enctype="multipart/form-data">
	<br>
	Supplier Id<spring:hidden  path="supplierid"/>
	Supplier Name<spring:input path="suppliername"/>
	<br>
	Supplier Description<spring:input path="supplierdescription"/>
	<br>
	<spring:radiobutton path="isavaliable" value="true"/>true
	<br>
	<spring:radiobutton path="isavaliable" value="false"/>false
	<br>
	<spring:button>Add Supplier</spring:button>

	</spring:form>
<table class="table table-stripped fixed_headers" id="tablesortsearch">
	
			
				<thead>
					<tr>
						<th>Supplier ID</th>
						<th>Supplier Name</th>
						<th>Supplier Desc</th>
						<th>Is Supplier Available</th>
						<th>Image</th>
					
					</tr>
				</thead>
				
				
				<tbody>
					<c:forEach items="${suppliers}" var="s">
						<tr>
							<td>${s.supplierid}</td>
							<td>${s.suppliername}</td>
							<td>${s.supplierdescription}</td>
							<td>${s.isavaliable}</td>
							<td><img src="resources/suppliers/${s.supplierid}.jpg"
								height="50" width="80" />
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

</body>
</html>