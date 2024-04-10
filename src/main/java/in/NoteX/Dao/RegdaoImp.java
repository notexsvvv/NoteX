package in.NoteX.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.NoteX.model.StudentUser;
import in.NoteX.model.TeacherUser;
import in.NoteX.model.User;
import in.NoteX.util.DBcon;

public class RegdaoImp {

	public static boolean addUserUnderReviews(StudentUser user) {
		String query = "INSERT INTO UserUnderReview (fullname, username, email, linkedin,mobile,usertype,collegeid,password,terms) VALUES (?, ?, ?,?, ?, ?,?, ?, ?)";

		try (Connection connection = DBcon.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getUsername());		
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getLinkedin());
			preparedStatement.setString(5,( user.getMobile().length()>=11?user.getMobile().substring(1):user.getMobile()));
			preparedStatement.setString(6, user.getUsertype());
			preparedStatement.setBlob(7, user.getInputStreamFILE());
			preparedStatement.setString(8, user.getPassword());
			preparedStatement.setString(9, user.getTerms());

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean addUserUnderReviews(TeacherUser user) {
		String query = "INSERT INTO UserUnderReview (fullname, username, email, linkedin,mobile,usertype,collegeid,password,terms) VALUES (?, ?, ?,?, ?, ?,?, ?, ?)";

		try (Connection connection = DBcon.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getUsername());		
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getLinkedin());
			preparedStatement.setString(5,( user.getMobile().length()>=11?user.getMobile().substring(1):user.getMobile()));
			preparedStatement.setString(6, user.getUsertype());
			preparedStatement.setBlob(7, user.getInputStreamFILE());
			preparedStatement.setString(8, user.getPassword());
			preparedStatement.setString(9, user.getTerms());

			int rowsAffected = preparedStatement.executeUpdate();

			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
