<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notex - Logout</title>
</head>
<body>
<%
		 HttpSession ss = request.getSession(false);
		ss.invalidate();
		
			String  s =(String) ("Ok Sucessfully Logout ");
			
		
%>


<h1> <%= s %></h1>
</body>
</html>