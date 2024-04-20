package in.NoteX.Dao;
import in.NoteX.util.DBcon;
import in.NoteX.model.StudentUser;
import in.NoteX.model.TeacherUser;
import in.NoteX.model.User;
import in.NoteX.servlet.LoginServlet;

import java.io.Console;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.valves.rewrite.Substitution.StaticElement;

public class UserDaoImpl  {

	
	public static  boolean addUser(User user) {
				 String query = "INSERT INTO login_info (username, email, password,usertype) VALUES (?, ?, ?,?)";
		
			        try (Connection connection = DBcon.getConnection();
			             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		
			            preparedStatement.setString(1, user.getUsername());
			            preparedStatement.setString(2, user.getEmail());
			            preparedStatement.setString(3, user.getPassword());
			            preparedStatement.setString(4, user.getUsertype());
		
			            int rowsAffected = preparedStatement.executeUpdate();
		
			            return rowsAffected > 0;
			        } catch (SQLException e) {
			            e.printStackTrace();
			            return false;
			        }
	}


	public static  boolean isValidUser(String username, String password) {
		String query = "SELECT * FROM login_info WHERE username = ? AND password = ?";
   	 try (Connection connection = DBcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
	}
	
   	public static String getUserTypeString(String username, String password) {
   		String userType ="";
   		String query = "SELECT * FROM login_info WHERE username = ? AND password = ?";
   	 try (Connection connection = DBcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	String usernameString = resultSet.getString("username"); 
            	String passString = resultSet.getString("password");
            	 userType = resultSet.getString("usertype");
				
			}

            return userType ;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
   	 
	}
   	
   	public static  boolean  setTokenforLogin ( String username, String token) {
   	
   		String query = "UPDATE login_info SET token = ? WHERE username =?";
   	 try (Connection connection = DBcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
   		 
            preparedStatement.setString(1, token);
            preparedStatement.setString(2, username);

            int rowsAffected = preparedStatement.executeUpdate();
           // System.out.print("Token at db set = "+ token);
            if (rowsAffected > 0) {
            	return true;
				
			}
            else {
            	return false ;
            }

          
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error at setToken "+ e.getLocalizedMessage());
            return false;
        }
   	}
   	
   	public static String getTokenforVerification(String username) {
        String query = "SELECT token FROM login_info WHERE username = ?";
        try (Connection connection = DBcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        		
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String storedToken = resultSet.getString("token");
                   System.out.print("Token at db set = "+ storedToken);
                    return storedToken; // Compare stored token with provided token
                } else {
                    System.out.print("no match found for the token ");
                    return null;
                }
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
            return null;
        }
    }
   	
   	
   	public static boolean deleteFromDatabase(String username) {
        	
	 String query = "delete from userunderreview where username =?";
   	 try (Connection connection = DBcon.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
   		 
            preparedStatement.setString(1, username);

            int rowsAffected = preparedStatement.executeUpdate();
           // System.out.print("data deleted for "+ username);
            if (rowsAffected > 0) {
            	return true;
				
			}
            else {
            	return false ;
            }

          
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error at setToken "+ e.getLocalizedMessage());
            return false;
        }
   	
 }
   	
   	public static boolean insertIntoDb(String username) {
   		
   		 String usertype = getuserType(username);
   		 
   		 if (usertype.equals("student")) {
   			StudentUser user = new StudentUser();
   			
   				String query = "SELECT *  FROM userunderreview  WHERE username = ?";
		   	   	 try (Connection connection = DBcon.getConnection();
		   	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {		
		   	            preparedStatement.setString(1, username);		
		   	            ResultSet resultSet = preparedStatement.executeQuery();		   	            
		   	         while (resultSet.next()) {
		                 user.setFullname(resultSet.getString("fullname"));
		                 user.setUsername(resultSet.getString("username"));
		                 user.setEmail(resultSet.getString("email"));
		                 user.setLinkedin(resultSet.getString("linkedin"));
		                 user.setMobile(resultSet.getString("mobile"));
		                 user.setUsertype(resultSet.getString("usertype"));
		                 user.setInputStreamFILE(resultSet.getBinaryStream("collegeid") ,1);
		                  user.setPassword(resultSet.getString("password")); 
		                 user.setTerms(resultSet.getString("terms"));
		   	         }

		   	            
		   	            
		   			 
		   		 }
		   	   	 catch (Exception e) {
					System.out.print(e.getLocalizedMessage());
				}
		   	   	 
		   		Boolean rsBoolean=  addUser(user);
			   	 Boolean iBoolean =  RegdaoImp.addUser(user);
			   	 
			   	 if(rsBoolean && iBoolean) {
			   		 return true;
			   	 }
			   	 else {
			   		 return false ;
			   	 }
   		 }
   			
   		 else if(usertype.equals("teacher")){
   			TeacherUser user = new TeacherUser();
   			
				String query = "SELECT *  FROM userunderreview  WHERE username = ?";
	   	   	 try (Connection connection = DBcon.getConnection();
	   	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {		
	   	            preparedStatement.setString(1, username);		
	   	            ResultSet resultSet = preparedStatement.executeQuery();		   	            
	   	         while (resultSet.next()) {
	                 user.setFullname(resultSet.getString("fullname"));
	                 user.setUsername(resultSet.getString("username"));
	                 user.setEmail(resultSet.getString("email"));
	                 user.setLinkedin(resultSet.getString("linkedin"));
	                 user.setMobile(resultSet.getString("mobile"));
	                 user.setUsertype(resultSet.getString("usertype"));
	                 user.setPassword(resultSet.getString("password")); 
	                 user.setInputStreamFILE(resultSet.getBinaryStream("collegeid") ,1);
	                 user.setTerms(resultSet.getString("terms"));
	   	         }

	   	            
	   	            
	   			 
	   		 }
	   	   	 catch (Exception e) {
				System.out.print(e.getLocalizedMessage());
			}
	   	   	Boolean rsBoolean=  addUser(user);
	   	 Boolean iBoolean =  RegdaoImp.addUser(user);
	   	 
	   	 if(rsBoolean && iBoolean) {
	   		 return true;
	   	 }
	   	 else {
	   		 return false ;
	   	 }
   		 }
   		 
   		 else {
   			 System.out.println("Yoser type not found ");
   			 return false;
   		 }
   		
   	 
   	}

	private static String getuserType(String username) {
		String userType ="";
	   		String query = "SELECT usertype  FROM userunderreview  WHERE username = ?";
	   	 try (Connection connection = DBcon.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, username);
	           

	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	
	            	 userType = resultSet.getString("usertype");
					
				}
	            return userType;
	            
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
		
	}




}
