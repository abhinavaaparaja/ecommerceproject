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
 	/*
   margin-left:1px;
   margin-right:1px;
   margin-top:1px;
   margin-bottom:1px;
  
    border:1px solid green;    
   
    border-radius:15px;*/
   }
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
<%@ include file="guest_navibar.jsp" %>
<div class="container" style="margin-top:70px">

td><img src="resources/Products/P00001${VW_P_XPS_S.productid}.jpg" width="100"
		height="150"></td>

	<td>${VW_P_XPS_S.get(0).productname}<br>
		${VW_P_XPS_S.get(0).productdescription}
	</td>
	</tr>

	<br>
	<table class="table table-stripped fixed_headers" id="tablesortsearch">

		<thead>


			<tr>
				<th>Supplier</th>
				<th>Price</th>
				<th>Options</th>
				
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${views}" var="v">
				<tr>
				
									
					<td> ${v.suppliername}</td>
					<br>
					<td><i class="fa fa-rupee"></i>${v.xpsprice}</td>
					<td><a
						
						href="reqUserAddXpsToCart?xpsid=${v.xpsid}&pid=${v.productid}">AddToCart</a></td>
						
						
				</tr>
			
				
			</c:forEach>
		</tbody>
	</table>

</div>
	<div class="col-sm-12">
		<c:forEach items="${reviews}" var="r">
		 	<div class="row" style="padding-bottom:10px">
			<div class="col-sm-2">
				<img src="resources/customers/${r.customerid}.jpg" width="70px" hight="50px"/>
				<br>
				${r.custname}
			</div>
			<div class="col-sm-2">
				<c:if test="${r.isratinggiven==true}">
						<c:if test="${r.rating>=3.8}">
									<span class="label label-success">
										<i class="glyphicon glyphicon-star" ></i>
										<b>${r.rating} </b>
									</span>											
										
								</c:if>
								<c:if test="${r.rating<3.8 && r.rating>=2.8}">
										<span class="label label-warning">
											<i class="glyphicon glyphicon-star"></i>
											<b>${r.rating} </b>
										</span>
								</c:if>
								<c:if test="${r.rating<2.8}">
										<span class="label label-danger">
											<i class="glyphicon glyphicon-star"></i>
											<b>${r.rating} </b>
										</span>
								</c:if>
					</c:if>
			</div>
			<div class="col-sm-8">
				<b>${r.reviewtitle}</b>
				<br>
				${r.reviewbody}
			</div>
			</div>
		</c:forEach>
		<%@ include file= "footer.jsp" %>	
	</div>
	





</body>
</html>