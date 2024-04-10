<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Approval</title>
</head>

<body>
<nev> <a href="Logout" method ="post"><button>LOGOUT </button></a> </nev>
<%	
        // Retrieve the session object
        HttpSession ss = request.getSession(false);

        // Check if the session is not null and the username attribute is set
        if (ss != null && ss.getAttribute("username") != null  && ss.getAttribute("usertype") != null ) {
        	if( ((String)ss.getAttribute("usertype")).equals("admin")){
        		
        	
            // Get the username from the session
            String username = (String) ss.getAttribute("username");
            String pass = (String) ss.getAttribute("pass");
            
    %>
		<h1> Wellcome <%=username %></h1>
       <div id="userData"></div>
 <script
src="https://code.jquery.com/jquery-3.7.1.js"
	  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	  crossorigin="anonymous"></script>
    <script src ="js/getdata.js">  </script>

    <%
        
        		}
        	%>
        	<h1> You are not admin </h1>
        	<%
        	} else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
        }
    %>
   
</body>
</html>
