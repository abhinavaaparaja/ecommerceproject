<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp" %>
<%@ include file="script.jsp" %>
<body>
<%@ include file="admin_navibar.jsp" %>
<div class="container" style="margin-top:50px">

<%@ include file="message.jsp" %>
<spring:form modelAttribute="xpsObject" action="reqAdminSendXPSToDb">
	
		<spring:hidden path="supplierid" value="${supid}"/>
		<div class="col-sm-6">
			Select Product for <b>${supid}</b>	
			<spring:select path="productid">
				<c:forEach items="${products}" var="p">
					<option value="${p.productid}">${p.productid}  -  ${p.productname}</option>
				</c:forEach>
			</spring:select>		
		</div>
		<div class="col-sm-2">
			Price <spring:input path="xpsprice" size="5"/> <spring:errors path="xpsprice" style="color:red;"></spring:errors>
	
		</div>
		<div class="col-sm-2">
		Stock <spring:input path="xpsstock" size="5"/>  <spring:errors path="xpsstock" style="color:red;"></spring:errors>
	
		</div>
		<div class="col-sm-2">
		<spring:button>Add XPS</spring:button>
		</div>
	</spring:form>
	
	</div>
	</head>

</html>