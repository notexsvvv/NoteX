<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="css\Register.css" rel="stylesheet">
<title>NoteX - Notes and PYQs</title>
</head>
<body>
 <div class="container">
		

    <h2>Register</h2>
      <%-- Display error message if registration fails --%>
         <% String success = request.getParameter("registration");
           if (success != null && success.equals("success")) { %>
            <p style="color: yellow;">Registration success. registration Under review  .</p>
        <% } %>
        <% String error = request.getParameter("error");
           if (error != null && error.equals("1")) { %>
            <p style="color: red;">Registration failed. Please try again.</p>
        <% } %>
        <% String fileerror = request.getParameter("error");
           if (fileerror != null && fileerror.equals("3")) { %>
            <p style="color: red;">file must be Student OR  Teacher  .</p>
        <% } %>
        <% String imgerr = request.getParameter("error");
           if (imgerr != null && imgerr.equals("2")) { %>
            <p style="color: red;">Select User Type must be in img , png , jpg format  .</p>
        <% } %>
        <% String passerr = request.getParameter("error");
           if (passerr != null && passerr.equals("4")) { %>
            <p style="color: red;">Confirm Password: must be same as Password.</p>
        <% } %>
        <% String imgSizeerr = request.getParameter("error");
           if (imgSizeerr != null && imgSizeerr.equals("5")) { %>
            <p style="color: red;">Image Size must be less than 16 MB .</p>
        <% } %>
    <form action="registrationProcessServlet" method="post" enctype="multipart/form-data">
        <label for="fullname">Full Name:</label>
        <input type="text" id="fullname" name="fullname" required><br><br>
        
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="username">Username:</label>	
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="usertype">User Type:</label>
        <select id="usertype" name="usertype" required>
            <option value="">Select User Type</option>
            <option value="student">Student</option>
            <option value="teacher">Teacher</option>
        </select><br><br>
        
        <label for="linkedin">LinkedIn URL:</label>
        <input type="url" id="linkedin" name="linkedin"><br><br>
        
        <label for="mobile">Mobile No:</label>
        <input type="tel" id="mobile" name="mobile"><br><br>
        
        <label for="collegeid">College ID Card Photo:</label>
        <input type="file" id="collegeid" name="collegeid" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <label for="confirm_password">Confirm Password:</label>
        <input type="password" id="confirm_password" name="confirm_password" required><br><br>
        
        <input type="checkbox" id="terms" name="terms" required> 
        <label for="terms">Agree to our terms and conditions</label> <br><br>
        
        <input type="submit" value="Submit"> <br>
        <br>
        <input type="reset" value="Reset">
    </form>



    
        <p><a href="index.html">Back to Home</a></p>
    
      
      </div>
</body>
 

</html>