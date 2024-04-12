package in.NoteX.servlet;


import in.NoteX.Dao.GetAprovalUser;
import in.NoteX.model.StudentUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@WebServlet("/UserAproval")
public class UserAproval extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        System.out.println("Servlet called");
        GetAprovalUser approvalUser = new GetAprovalUser();
        List<StudentUser> userList = null;
        try {
            userList = approvalUser.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception
        }

        StringBuilder jsonBuilder = new StringBuilder("[");
        for (StudentUser user : userList) {
            jsonBuilder.append("{");
            jsonBuilder.append("\"fullname\":").append("\"").append(user.getFullname()).append("\",");
            jsonBuilder.append("\"username\":").append("\"").append(user.getUsername()).append("\",");
            jsonBuilder.append("\"email\":").append("\"").append(user.getEmail()).append("\",");
            jsonBuilder.append("\"linkedin\":").append("\"").append(user.getLinkedin()).append("\",");
            jsonBuilder.append("\"mobile\":").append("\"").append(user.getMobile()).append("\",");
            jsonBuilder.append("\"usertype\":").append("\"").append(user.getUsertype()).append("\",");
            jsonBuilder.append("\"password\":").append("\"").append(user.getPassword()).append("\",");
            jsonBuilder.append("\"terms\":").append("\"").append(user.getTerms()).append("\",");
            
            System.out.println("#### until Colge id ");
            jsonBuilder.append("\"collegeid\":").append("\"").append(encodeImage(user.getInputStreamFILE())).append("\"");
            // Add more fields if necessary
            jsonBuilder.append("},");
        }
        if (!userList.isEmpty()) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // Remove the last comma
        }
        jsonBuilder.append("]");
        
        // Write the JSON response
        out.println(jsonBuilder.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // Encode image data to Base64
    private String encodeImage(InputStream inputStream) throws IOException {
        byte[] imageBytes = inputStream.readAllBytes();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
        
    
}