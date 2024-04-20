
  package in.NoteX.servlet;
  
  import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException; import
  jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.Cookie;
  import jakarta.servlet.http.HttpServlet; import
  jakarta.servlet.http.HttpServletRequest; import
  jakarta.servlet.http.HttpServletResponse; import java.io.IOException; import
  java.io.PrintWriter;
  
  import in.NoteX.Dao.UserDaoImpl;
  
  public class acceptUser extends HttpServlet {
  
  protected void doPost(HttpServletRequest request, HttpServletResponse
  response) throws ServletException, IOException {
	  
	  
	  String cusername = "";
      
      // Retrieve username from cookie
      Cookie[] cookies = request.getCookies();
      if (cookies != null) {
          for (Cookie cookie : cookies) {
              if (cookie.getName().equals("username")) {
                  cusername = cookie.getValue();
                  break;
              }
             System.out.println("cookie username - "+ cusername);
          }
      }
      String providedToken = request.getParameter("token");
       System.out.println("Token from parameter = "+ providedToken);
//        // Retrieve the token associated with the username
        String storedToken = UserDaoImpl.getTokenforVerification(cusername);
//        //System.out.println("Stored token in db ="+storedToken);
//        // Check if the provided token matches the stored token
        if (!providedToken.equals(storedToken)) {

           response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return;
        }
 	
        
        
        
        
        
        
     // Retrieve username from request parameter
     String username = request.getParameter("username");
    

     // Perform deletion operation (Replace this with your own logic)
     boolean success = UserDaoImpl.insertIntoDb(username);

     // Set response content type
     response.setContentType("application/json");

     // Create JSON response
     PrintWriter out = response.getWriter();
     if (success) {
    	 
    	 RequestDispatcher rDispatcher = request.getRequestDispatcher("deleteUser");
    	 rDispatcher.include(request, response);
         out.println("{\"success\": true}");
     } else {
         out.println("{\"success\": false, \"error\": \"Failed to Accept  user\"}");
     }
     out.close();
   
   }
  }