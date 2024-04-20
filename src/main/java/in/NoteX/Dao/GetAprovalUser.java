package in.NoteX.Dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.NoteX.model.StudentUser;
import in.NoteX.model.User;
import in.NoteX.util.DBcon;




public class GetAprovalUser {
    
    ResultSet resultSet;

    public List<User> getUsers() throws SQLException {
        List<User> userList = new ArrayList<>();

        Connection connection = null;
        Statement stmt = null;
        
        try {
            connection = DBcon.getConnection();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT * FROM UserUnderReview");

            while (resultSet.next()) {
                User user = new User();

                user.setFullname(resultSet.getString("fullname"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setLinkedin(resultSet.getString("linkedin"));
                user.setMobile(resultSet.getString("mobile"));
                user.setUsertype(resultSet.getString("usertype"));
           
                user.setInputStreamFILE(resultSet.getBinaryStream("collegeid") ,1);
               // System.out.println( "@@@@@@"  +resultSet.getBinaryStream("collegeid"));
                
				/* user.setPassword(resultSet.getString("password")); */
                user.setTerms(resultSet.getString("terms"));



                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources properly
            if (resultSet != null) resultSet.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }

        return userList;
    }
}