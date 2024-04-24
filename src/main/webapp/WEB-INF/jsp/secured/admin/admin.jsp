<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="jakarta.servlet.http.HttpSession" %>

<%-- <%@ include file="upload_notes.jsp" %>
 <%@ include file="upload_pyq.jsp" %>
<%@ include file="upload_placementmaterial.jsp" %>
<%@ include file="upload_imptopics.jsp" %>
<%@ include file="user_approval.jsp" %>
<%@ include file="notes_pyqapproval.jsp" %>
<%@ include file="delete_approval.jsp" %>  --%>

<!DOCTYPE html>
<html lang="en">
<head>


<!-- Scripts moved to the head for better performance -->
		<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
		  crossorigin="anonymous"></script>
		  
		 <script src="js/admin.js"></script>
		 <script src="js/userApproval.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		  integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		  crossorigin="anonymous"></script>

 <!-- <script>
 function loadTargetPage() {
	    var xhr = new XMLHttpRequest();
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState == 4 && xhr.status == 200) {
	            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
	        }
	    };
	    xhr.open("GET", "mapUploadNotes", true); // Servlet mapping
	    xhr.send();
	}
    </script> -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css\UploadNotes.css" rel="stylesheet">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>NoteX -Admin</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
  integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<link href="css/userAproval.css" rel="stylesheet">
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






		<nav class="navbar navbar-expand-lg  bg-dark border-bottom border-body sticky-top bg-body-tertiary"
		  data-bs-theme="dark">
		  <div class="container-fluid">
		
		    <a class="navbar-brand" href="admin.jsp">
		      <img src="img/Notex only logo 1080x1080 Px.png" alt="Logo" width="30" height="30"
		        class="d-inline-block align-text-top" id=logo> <b>NoteX</b>
		    </a>
		
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
		      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		
		
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Upload
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="#" onclick="loadNotesUploadPage()">Notes</a></li>
		            <li><a class="dropdown-item" href="#" onclick="loadPYQUploadPage()" >PYQ</a></li>
		            <li><a class="dropdown-item" href="#" onclick="loadPlacementMaterialUploadPage()">Placement Material</a></li>
		            <li><a class="dropdown-item" href="#" onclick="loadIMPTopicsUploadPage()">Important Topics</a></li>
		          </ul>
		
		        </li>
		
		        <li class="nav-item">
		          <a class="nav-link" href="#" onclick="loadUserApprovalPage()"> <b>User Approval</b></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#"  onclick="loadNotesPyqApprovalPage()" ><b>Notes/Pyq Approval</b></a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="#"   onclick="loadDeleteApprovalPage()"><b>Delete Approval</b></a>
		        </li>
		
		      </ul>
		      <!-- th-->
		      <div class="one-quarter" id="switch">
		        <button id="btn">Dark Mode</button>
		      </div>
		      <div class="one-quarter" id="switch">
		        <a href ="Logout">
		          <button id="logout-btn">Logout</button>
		        </a>
		      </div>
		
		    </div>
		  </div>
		</nav>
		
<!-- main --> 
		<!-- Loader -->
<div id="loader" class="loader"></div>
		
		<div id="targetPageContainer"></div>
<!--  end of main  -->		
		
		
		
		
		
		<!-- footer -->
		<footer class="container-fluid bg-grey py-5">
		  <div class="container">
		    <div class="row">
		      <div class="col-md-6">
		        <div class="row">
		          <div class="col-md-6">
		            <div class="logo-part">
		              <div class="logo-img-part">
		                <img src="img/NoteX Full Logo.png" width="900" height="100" class="w-50 logo-footer" id="logo_footer ">
		              </div>
		              <p>Let's Grow Together</p>
		              <p>Indore – Ujjain Road, Indore – 453111 <br> Madhya Pradesh, Bharat (India).</p>
		            </div>
		          </div>
		          <div class="col-md-6 px-20">
		            <h6><b>About US</b></h6>
		            <p>A Platform for Exam Help and Support for Students at Shri Vaishnav Vidyapeeth Vishwavidyalaya.</p>
		            <p>Use this tool to boost academic performance, score beyond your imagination!!</p>
		            <a href="#" class="btn-footer"><b>Contact Us</b></a>
		          </div>
		        </div>
		      </div>
		
		      <div class="col-md-6">
		        <div class="row">
		          <div class="col-md-6 ">
		            <div class="social">
		              <a href="#"><i class="bi bi-linkedin" aria-hidden="true"></i></a>
		              <a href="#"><i class="bi bi-github" aria-hidden="true"></i></a>
		              <a href="#"><i class="bi bi-instagram" aria-hidden="true"></i></a>
		            </div>
		            <br>
		            <i class="bi bi-c-circle">© NoteX 2024 - All Rights Reserved.</i>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</footer>
		

<%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
        }
    }
%>



</body>
</html>
