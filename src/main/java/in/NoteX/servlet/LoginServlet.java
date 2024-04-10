package in.NoteX.servlet;
import in.NoteX.Dao.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (UserDaoImpl.isValidUser(username, password)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);
	            response.sendRedirect("welcome.jsp");
	            //System.out.println("Hi - "+username);
	        } else {
	            response.sendRedirect("login.jsp?error=1");
	        	System.out.println("Error A gya");
	        }
}


	}


