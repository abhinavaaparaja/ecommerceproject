<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="links.jsp" %>
<style>

.row-flex {
  display:flex;
  flex-wrap:wrap;   
}
.col-wrap{
overflow-wrap:break-word;
justify-content: space-between;
}
</style>
</head>
<body>

	<div class="container" style="margin-top: 70px">
		
		<div class="row row-flex">
		<div class="col-sm-6" style="text-align:right;vertical-align:middle">
			<img src="resources/Products/${product.productid}.jpg" width="300" height="250"/>
		</div>
		<div class="col-sm-6" style="text-align:left;vertical-align:middle">
			<div class="col-sm-6" style="text-align:left;vertical-align:middle">
			<h1><b>${product.productname}</b></h1>
			<br>
			
		</div>
	
		</div>
		<form action = "reqSendProductReviewToDb">
			<input type="text" value="${ordetid}" name="ordetid" hidden />
		
			Review Title
			<br>
			<input type="text" name="reviewtitle"/>
			<br>
			Review
			<br>
			<input type="text" name="reviewbody" cols="40" rows="5" style="width:200px; height:50px;" />
			<br>
			<input type="submit" value="Add Review"/>
		
			
		</form>
	
	</div>
	

</div>
</body>

</body>
</html>