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
<%@ include file ="user_navibar.jsp" %>
<div class="container" style="margin-top:50px">
<%@ include file ="message.jsp" %>
<h1>Password Change Screen</h1>

<form action="reqUserChangePwdToDB" method="post">
Current Password <input type="password" name="currentpwd" required="true"/>
<br>
New Password <input type="password" name="newpwd" required="true" />
<br>
Confirm Password <input type="password" name="confirmpwd" required="true"/>
<br>
<input type="submit" value="Change Password"/>

</form>
</div>


</body>

</body>
</html>