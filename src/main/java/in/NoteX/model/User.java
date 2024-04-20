package in.NoteX.model;

import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.http.Part;

public class User {
	private String username;
	 private String password;
	 private String email;
	 private String fullname;
	 private String usertype;
	 private String linkedin;
	 private String mobile;
	 private String terms;
	 private Part inputStream = null;
	 public InputStream inputStreamFILE = null;
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setTerms(String terms) {
		this.terms = terms;
//		try {
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public void setInputStream(Part file) {
		this.inputStream = file;
		setInputStreamFILE(file);
		System.out.println(file +"file at user  "+ file.getName());
	}	
	public void setInputStreamFILE(Part inputStreamFILE) 
	{
		try {	this.inputStreamFILE = inputStreamFILE.getInputStream();
				System.out.println("setInput Stream ruyns ");
			}
		catch(Exception e) 
		{
			System.out.println("Error InputStream file ");
			System.out.println(e.getStackTrace()+""+ e.getCause() +"  "+ e.getMessage());
			
		}
	}	
	public void setInputStreamFILE(InputStream inputStreamFILE , int x)
{
			try {	
					this.inputStreamFILE = inputStreamFILE;
				}
			catch(Exception e) {
				System.out.println("Error InputStream file ");
				System.out.println(e.getStackTrace()+""+ e.getCause() +"  "+ e.getMessage());
				
			}
}
	

	public String getUsername() {
			return username;
		}
	public String getEmail() {
		return email;
	}
	public String getFullname() {
		return fullname;
	}
	public String getUsertype() {
		return usertype;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public String getMobile() {
		return mobile;
	}
	public String getTerms() {
		return terms;
	}	
	public InputStream getInputStreamFILE() {
		System.out.println("at return inputstreamfile"+inputStreamFILE);
		return inputStreamFILE;
	}	 
	public String getPassword() {
		return password;
	}
	
	public void printUser(){
	System.out.println("\n user called ");
	System.out.println("username " +username);

	System.out.println("password "+password);

	System.out.println("email ="+email);

	
	}

}
