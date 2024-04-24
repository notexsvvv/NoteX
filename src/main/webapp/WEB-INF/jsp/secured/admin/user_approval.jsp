
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

  <script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
  
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
    crossorigin="anonymous"></script>
  


</head>
<body>

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
<div id = "Userapproval"></div> 
<div id="userTableDiv">
    <table id="userTable">
        <thead>
            <tr>
                <th>Full Name</th>
                <th>Username</th>
                <th>Email</th>
               <!--  <th class ="linkedin-th">LinkedIn</th> -->
                <th>Mobile</th>
                <th>User Type</th>
                <!-- <th>Password</th> -->
                <th>Terms</th>
                <th>College ID Image</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <!-- Table rows will be dynamically added here -->
        </tbody>
    </table>
</div>
  </div>






<%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
        }
    }
%>


</body>
</html>