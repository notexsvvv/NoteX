<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Approve Notes Pyq </title>
</head>
<%	
    // Retrieve the session object
    HttpSession ss = request.getSession(false);
    // Check if the session is not null and the username attribute is set
    if (ss != null && ss.getAttribute("username") != null && ss.getAttribute("usertype") != null) {
        if (((String)ss.getAttribute("usertype")).equals("admin")) {
            // Get the username from the session
            String username = (String) ss.getAttribute("username");
            String token = (String) ss.getAttribute("token");
            // Cookie cookie[]= request.getCookies(); // Uncomment if needed
%>

<body>
	<h1> Approve Notes Pyq </h1>
</body>
<%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
        }
    }
%>
</html>