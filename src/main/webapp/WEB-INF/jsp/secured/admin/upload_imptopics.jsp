<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UploadIMPTopics-NoteX</title>
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
 <style>
			body {
			    font-family: Arial, sans-serif;
			    background: #ad5389; /* fallback for old browsers */
			    background: -webkit-linear-gradient(to top, #a8edea, #fed3e3);
			    background: linear-gradient(to left, #a8edea, #fed2e3);
			    margin: 0;
			    padding: 0;
			}
			
			.containernotes {
			    max-width: 500px;
			    margin: 50px auto;
			    padding: 20px;
			    background-color: transparent;
			    border-radius: 10px;
			    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			}
			
			h2 {
			    text-align: center;
			    color: #000000;
			}
			
			form {
			    padding: 20px;
			}
			
			label {
			    display: block;
			    margin-bottom: 5px;
			    font-weight: bold;
			    color: #333; /* Change label color */
			}
			
			input[type="text"],
			input[type="file"],
			select,
			textarea {
			    width: 100%;
			    padding: 10px;
			    margin-bottom: 15px;
			    border: 1px solid #f6efef;
			    border-radius: 5px;
			    box-sizing: border-box;
			}
			
			textarea {
			    resize: vertical;
			}
			
			input[type="submit"] {
			    background-color: #007bff;
			    color: #fff;
			    padding: 10px 20px;
			    border: none;
			    border-radius: 5px;
			    cursor: pointer;
			    font-size: 16px;
			}
			
			input[type="submit"]:hover {
			    background-color: #0056b3;
			}
</style>

<div class="containernotes">
        <h2>Upload Important Topics </h2>
        <form action="upload_notes.php" method="post" enctype="multipart/form-data">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4" required></textarea>

            <label for="class">Class:</label>
            <select id="class" name="class" required>
                <option value="First Year">First Year</option>
                <option value="Second Year">Second Year</option>
                <option value="Third Year">Third Year</option>
                <option value="Fourth Year">Fourth Year</option>
                <!-- Add more options as needed -->
            </select>

            <label for="course">Course:</label>
            <select id="course" name="course" required>
                <option value="B.Tech">B.Tech</option>
                <option value="M.Tech">M.Tech</option>
                <option value="BCA">BCA</option>
                <!-- Add more options as needed -->
            </select>

            <label for="semester">Semester:</label>
            <select id="semester" name="semester" required>
                <option value="1st">1st</option>
                <option value="2nd">2nd</option>
                <option value="3rd">3rd</option>
                <option value="4th">4th</option>
                <option value="5th">5th</option>
                <option value="6th">6th</option>
                <option value="7th">7th</option>
                <option value="8th">8th</option>
                <!-- Add more options as needed -->
            </select>

            <label for="subject">Subject/Area:</label>
            <input type="text" id="Subject" name="Subject" required>

            <label for="year">Year:</label>
            <select id="year" name="year" required>
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <!-- Add more options as needed -->
            </select>

            <label for="branch">Branch:</label>
            <select id="branch" name="branch" required>
                <option value="CSE">CSE</option>
                <option value="IT">IT</option>
            </select>

            <label for="owner">Owner/Author:</label>
            <input type="text" id="owner" name="owner" required>

            <label for="file">File Upload:</label>
            <input type="file" id="file" name="file" required>

            <input type="submit" value="Upload">
        </form>
    </div>
  </div>
</body>
<%
        } else {
            // Redirect to the login page if the session is not valid
            response.sendRedirect("login.jsp");
        }
    }
%>
</html>