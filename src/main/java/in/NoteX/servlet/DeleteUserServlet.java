package in.NoteX.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.NoteX.Dao.UserDaoImpl;
import jakarta.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username from request parameter
        String username = request.getParameter("username");

        // Perform deletion operation (Replace this with your own logic)
        boolean success = UserDaoImpl.deleteFromDatabase(username);

        // Set response content type
        response.setContentType("application/json");

        // Create JSON response
        PrintWriter out = response.getWriter();
        if (success) {
            out.println("{\"success\": true}");
        } else {
            out.println("{\"success\": false, \"error\": \"Failed to delete user\"}");
        }
        out.close();
    }

    // Method to delete user from database (Replace this with your own database logic)
    
}

