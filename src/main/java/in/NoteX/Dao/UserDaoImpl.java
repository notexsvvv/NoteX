package in.NoteX.Dao;
import in.NoteX.util.DBcon;
import in.NoteX.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl  {

	
	public static  boolean addUser(User user) {
		 String query = "INSERT INTO login_info (username, email, password) VALUES (?, ?, ?)";

	        try (Connection connection = DBcon.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	            preparedStatement.setString(1, user.getUsername());
	            preparedStatement.setString(2, user.getEmail());
	            preparedStatement.setString(3, user.getPassword());

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

}
