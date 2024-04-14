package in.NoteX.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import in.NoteX.Dao.RegdaoImp;
import in.NoteX.Dao.UserDaoImpl;
import in.NoteX.model.StudentUser;
import in.NoteX.model.TeacherUser;
import in.NoteX.model.User;

@WebServlet("/registrationProcessServle")
@MultipartConfig(maxFileSize = 16177215) // 16MB
public class registrationProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected String fullname, email, username, usertype, linkedin, mobile, password, confirm_password, terms;
	protected Part collegeid;
	InputStream inputStream = null;

	void insertIntoStudent(StudentUser std) {
		//StudentUser std = new StudentUser();
		std.setFullname(fullname);
		std.setUsername(username);
		std.setEmail(email);
		std.setLinkedin(linkedin);
		std.setMobile(mobile);
		std.setUsertype(usertype);
		std.setInputStream(collegeid);
		std.setPassword(password);
		std.setTerms(terms);
	}

	void insertIntoTeacher(TeacherUser tech) {
		

		tech.setFullname(fullname);
		tech.setUsername(username);
		tech.setEmail(email);
		tech.setLinkedin(linkedin);
		tech.setMobile(mobile);
		tech.setUsertype(usertype);
		tech.setInputStream(collegeid);
		tech.setPassword(password);
		tech.setTerms(terms);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Register.jsp?error=1");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.fullname = request.getParameter("fullname");
		this.email = request.getParameter("email");
		this.username = request.getParameter("username");
		this.usertype = request.getParameter("usertype");
		try {
			linkedin = request.getParameter("linkedin");
		} catch (Exception e) {
			this.linkedin = null;
		}
		try {
			this.mobile = request.getParameter("mobile");
		} catch (Exception e) {
			this.mobile = null;
		}
		this.password = request.getParameter("password");
		this.confirm_password = request.getParameter("confirm_password");
		this.terms = request.getParameter("terms");

		try {
			this.collegeid = request.getPart("collegeid");

//			System.out.println(this.fullname);
//			System.out.println(usertype);
//			System.out.println(linkedin);
//			System.out.println(mobile);
//			System.out.println(terms);
//			System.out.print(confirm_password);
			
			if (collegeid != null) {
				// prints out some information for debugging
				System.out.println("/n name img = " + collegeid.getName());
				System.out.println("img size = " + collegeid.getSize());
				System.out.println("conatent type =" + collegeid.getContentType());
				inputStream = collegeid.getInputStream();
			}
		} catch (Exception e) {
			System.out.println("error in file or image ");
			response.sendRedirect("Register.jsp?error=5");

		}
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.print("its RegistrationProcess servlet");

		if (this.password.equals(this.confirm_password)) {
			if (this.usertype.equals("student")) {
							StudentUser std = new StudentUser();
							insertIntoStudent(std);
							
							if (RegdaoImp.addUserUnderReviews(std)) {
								response.sendRedirect("Register.jsp?registration=success");
							} else {
								response.sendRedirect("Register.jsp?error=1");
							}
							outPrintWriter.print("its RegistrationProcess servlet st");
			} else if (usertype.equals("teacher")) {
						TeacherUser tech = new TeacherUser();
						insertIntoTeacher(tech);
						if (RegdaoImp.addUserUnderReviews(tech)) {
							response.sendRedirect("Register.jsp?registration=success");
							// response.sendRedirect("login.jsp?registration=success");
						} else {
							response.sendRedirect("Register.jsp?error=1");
						}
						outPrintWriter.print("its RegistrationProcess servlet TR");
					} 
			else {
				response.sendRedirect("Register.jsp?error=3");
			}
		} 
		else {
			response.sendRedirect("Register.jsp?error=4");
		}

		

	}

}

