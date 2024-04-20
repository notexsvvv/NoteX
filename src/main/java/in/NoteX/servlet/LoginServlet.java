package in.NoteX.servlet;
import in.NoteX.Dao.TokenGenerator;
import in.NoteX.Dao.UserDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.PublicKey;

import org.apache.jasper.runtime.ProtectedFunctionMapper;
import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;

public class LoginServlet extends HttpServlet {
	String string;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       String username = request.getParameter("username");
	        String password = request.getParameter("password");
	      
			if (UserDaoImpl.isValidUser(username, password)/* && TokenGenerator.isTokenSet(username)*/  ) {
	        	
	        	
	        String userTypeString =	UserDaoImpl.getUserTypeString(username, password);
	        	//System.out.println(userTypeString);
	        	if(userTypeString.equals("admin")) {
	        		 HttpSession adminsession = request.getSession();
	        		 adminsession.setAttribute("usertype", userTypeString);
	        		 adminsession.setAttribute("username", username);
	        		 
	        		 String token =TokenGenerator.setToken(username) ;
	        		 adminsession.setAttribute("token",token );
						/*
						 * RequestDispatcher rd= request.getRequestDispatcher("admin");
						 * rd.forward(request, response);
						 */
	        		 Cookie c = new Cookie("token", token);
	        		 Cookie c1 = new Cookie("username", username);
	                 response.addCookie(c1);
	        		 response.addCookie(c);
						 response.sendRedirect("admin.jsp"); 
	        	}
	        	
	        	else  if(userTypeString.equals("student")){
	        		 HttpSession userSession = request.getSession();
	        		 userSession.setAttribute("usertype", userTypeString);
	        		 userSession.setAttribute("username", username);
	        		 
	        		 String token =TokenGenerator.setToken(username) ;
	        		 userSession.setAttribute("token",token );
						
	        		 Cookie c = new Cookie("token", token);
	        		 Cookie c1 = new Cookie("username", username);
	                 response.addCookie(c1);
	        		 response.addCookie(c);	
	        		 response.sendRedirect("student.jsp");
	        	}
	        	else  if(userTypeString.equals("teacher")){
	        		 HttpSession userSession = request.getSession();
	        		 userSession.setAttribute("usertype", userTypeString);
	        		 userSession.setAttribute("username", username);
	        		 
	        		 String token =TokenGenerator.setToken(username) ;
	        		 userSession.setAttribute("token",token );
						
	        		 Cookie c = new Cookie("token", token);
	        		 Cookie c1 = new Cookie("username", username);
	                 response.addCookie(c1);
	        		 response.addCookie(c); 
	        		 response.sendRedirect("teacher.jsp");
	           
	        	}
	        	
	        	
	        	
	        } else {
	            response.sendRedirect("login.jsp?error=1");
	        	System.out.println("Error A gya");
	        }
}


	}


