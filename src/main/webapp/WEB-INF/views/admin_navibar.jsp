<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<nav class="navbar navbar-fixed-top navbar-inverse">
			<ul class="nav navbar-nav">
			<li class="active"><a href="reqUserHome">Home <span class="glyphicon glyphicon-home"></span></a></li>
				<li>Welcome To JustClick</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="">Welcome ${customer.custname}
					<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="">Edit Profile</a></li>
						<li><a href="reqUserChangePwdPage">Change Password</a></li>
						<li><a href="j_spring_security_logout">Logout</a></li>					
					</ul>
					
					
				</li>
				
				<li><a href="reqAdminProductPage">Products</a></li>
				<li><a href="reqAdminSupplierPage">Suppliers</a></li>
				<li><a href="reqAdminXPSPage">XMAP Product_Suppliers</a></li>
				<li><a href="reqAdminUsersPage">ManageUserDetails</a></li>
			</ul>	
			</nav>	
		
 </div>
    </nav>
    </div>
    
</body>
</html>