<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>NoteX- Welcome User</title>
</head>
<body>


<body>
    <%	
        // Retrieve the session object
        HttpSession ss = request.getSession(false);

        // Check if the session is not null and the username attribute is set
        if (ss != null && ss.getAttribute("username") != null) {
            // Get the username from the session
            String username = (String) ss.getAttribute("username");
            String pass = (String) ss.getAttribute("pass");
            
    %>

      <div class="container">
        <h1>Welcome, <%= username %>!</h1>
        <p>We're delighted to have you on our platform.🌟</p>
        <h3>Explore, learn, and connect with our vibrant community! 🚀</h3>
        <p>Feel free to stay as long as you like, and when you're ready, <%= pass %></p> 
        you can <a href="Logout" method ="post">LOGOUT</a> securely.
        <div> </div>
    </div>

    <%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
        }
    %>


</body>
</body>
</html>