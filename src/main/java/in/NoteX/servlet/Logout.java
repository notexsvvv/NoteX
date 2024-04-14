package in.NoteX.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Logout() {
        super();
       
    }

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		Cookie cookie[]= request.getCookies();
		for(int i=0;i<cookie.length;i++){  
			System. out.println(cookie[i].getName()+" "+cookie[i].getValue() );//printing name and value of cookie  
			cookie[i].setValue(null);
			}  
		
		
		/* System.out.print(cookie); */
		Cookie ck=new Cookie("JSESSIONID","");
		Cookie ck2=new Cookie("token","");
		response.addCookie(ck2);
		response.addCookie(ck);
		response.sendRedirect("login.jsp?logout=success");
	}

}
