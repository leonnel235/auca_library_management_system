package ServletView;

import dao.UserDAO; // Import the UserDAO
import model.Location;
import model.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
  
    private static final long serialVersionUID = 1L;

    @SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String phoneNumber = request.getParameter("phoneNumber");
            String role = request.getParameter("role");
            String villageId2 = request.getParameter("villageId");

            // Create a new user object
            Users newUser = new Users();
            newUser.setFirstname(firstName);
            newUser.setLastname(lastName);
            newUser.setGender(gender);
            newUser.setUsername(userName);
            newUser.setPassword(password); // Consider hashing the password before storing it
            newUser.setPhonenumber(phoneNumber);
            newUser.setRole(role);
            Location villageId = null; // Set village based on villageId if needed
            newUser.setVillage(villageId);

            // Create UserDAO instance
            UserDAO userDAO = new UserDAO();

            // Attempt to save the user
            try {
                userDAO.saveUser(newUser); // Use the DAO to save the user
                response.sendRedirect("RegistrationSuccess.html"); // Redirect to a success page
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Database Error: " + e.getMessage());
                request.getRequestDispatcher("/UserErrorHandling.jsp").forward(request, response); // Forward to error page
            }
        } catch (Exception e) {
            // Handle exceptions and set error attributes
            request.setAttribute("errorMessage", "Failed to register user: " + e.getMessage());
            request.setAttribute("javax.servlet.error.status_code", 500);
            request.getRequestDispatcher("/UserErrorHandling.jsp").forward(request, response);
        }
    }
}
