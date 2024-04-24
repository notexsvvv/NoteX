package in.NoteX.mapjsp;
import java.io.IOException;

import in.NoteX.Dao.UserDaoImpl;
import jakarta.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class mapUploadNotes extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Retrieve existing session (if any)
        if (session != null) {
            String token = (String) session.getAttribute("token");
            String username = (String) session.getAttribute("username");

            if (token != null && token.equals(UserDaoImpl.getTokenforVerification(username))) {
                // User is logged in, allow access to the secure page
                request.getRequestDispatcher("/WEB-INF/jsp/secured/admin/upload_notes.jsp").forward(request, response);
            } else {
                // Token is null or invalid, display alert and redirect to the login page
                response.getWriter().println("<script>alert('Session expired or invalid token. Please log in again.');</script>");
                response.sendRedirect("login.jsp"); // Redirect to your login page
            }
        } else {
            // No session exists, redirect to the login page
            response.sendRedirect("login.jsp"); // Redirect to your login page
        }
    }
}