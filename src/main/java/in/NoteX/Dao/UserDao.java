package in.NoteX.Dao;
import in.NoteX.model.User;
public interface UserDao {
	boolean addUser(User user);
	 boolean isValidUser(String username, String password);
}
