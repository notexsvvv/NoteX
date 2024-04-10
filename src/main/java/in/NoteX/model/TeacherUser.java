package in.NoteX.model;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.http.Part;

public class TeacherUser extends User {

	private String fullname;
	private String usertype;
	private String linkedin;
	private String mobile;
	private String terms;
	private Part inputStream = null;
	public InputStream inputStreamFILE = null;

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
//	public void setInputStream(Part inputStream) {
//		this.inputStream = inputStream;
//	}
//	
	
		public void setInputStreamFILE(InputStream inputStreamFILE) {
			try {	this.inputStreamFILE = inputStream.getInputStream();
		}
			catch(Exception e) {
				System.out.println("Error at StudentUser InputStream file ");
				
				
			}
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
		try {
			printall();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setInputStream(Part file) {
		this.inputStream = file;
		
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
		return inputStreamFILE;
	}
	 
	void printall() throws IOException
	{	 
		System.out.println(" \n  stdunent class  ");
		System.out.println("name " +fullname);
		System.out.println("user type "+usertype);
		System.out.println("linkedin " +linkedin);
		System.out.println("mobile no " +mobile);
		System.out.println("trems " + terms);
		if (inputStream != null) {
            // prints out some information for debugging
            System.out.println("/n name img = " + inputStream.getName());
            System.out.println("img size = "+ inputStream.getSize());
            System.out.println("conatent type ="+  inputStream.getContentType());
            
            // obtains input stream of the upload file
            inputStreamFILE = inputStream.getInputStream();
        }
		super.printUser();
		
	
	}
	
	
	
	

}
