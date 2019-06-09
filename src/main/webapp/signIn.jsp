<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.vikash.bitshare.AbstractDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Welcome</title>
</head>
<body>
<%
	String userName=request.getParameter("uname");
	userName=userName.trim();
	String password=request.getParameter("psw");
	password=password.trim();
	AbstractDao ab=new AbstractDao();
	try
	{
	if(ab.getPasswordByUserName(userName).trim().equals(password))
	{
		%>
		Welcome <%=userName %>
		<% 
	}
	else
	{
		%>
		wrong password!!
		<%=userName %>
		<%=ab.getPasswordByUserName(userName) %>p<%=password %>
		<% 
		
	}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
%>

</body>
</html>