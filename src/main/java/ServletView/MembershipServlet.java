package ServletView;

import dao.MembershipDAO;
import dao.MembershipTypeDAO;
import dao.UserDAO;
import model.Membership;
import model.MembershipType;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/MembershipServlet")
public class MembershipServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve and validate form parameters
            String membershipCode = request.getParameter("membershipCode");
            String membershipStatus = request.getParameter("membershipStatus");
            String membershipTypeId = request.getParameter("membershipTypeId");
            String personId = request.getParameter("personId");
            String expiringTimeStr = request.getParameter("expiringTime");

            // Fetch the Users entity by readerId
            Users reader = getReaderById(personId);

            // Initialize Membership entity
            Membership membership = initializeMembership(membershipCode, membershipStatus, expiringTimeStr, reader);

            // Set MembershipType
            setMembershipType(membershipTypeId, membership);

            // Save the membership and redirect on success
            saveMembership(membership, response);

        } catch (Exception e) {
            // Handle errors and display message on error page
            request.setAttribute("errorMessage", "Error during membership registration: " + e.getMessage());
            request.getRequestDispatcher("/MembershipErrorHandling.jsp").forward(request, response);
        }
    }

    // Method to parse and fetch user by ID
    private Users getReaderById(String personId) throws Exception {
        UserDAO userDAO = new UserDAO();
        Users reader = userDAO.getUserById(Long.parseLong(personId));
        if (reader == null) {
            throw new Exception("Reader not found with ID: " + personId);
        }
        return reader;
    }

    // Method to initialize Membership
    private Membership initializeMembership(String membershipCode, String membershipStatus, String expiringTimeStr, Users reader) throws ParseException {
        Membership membership = new Membership();
        membership.setMembershipCode(membershipCode);
        membership.setMembershipStatus(membershipStatus);
        membership.setRegistrationDate(new Date());
        membership.setReader(reader);

        if (expiringTimeStr != null && !expiringTimeStr.isEmpty()) {
            Date expiringTime = parseDate(expiringTimeStr);
            membership.setExpiringTime(expiringTime);
        }
        return membership;
    }

    // Method to set MembershipType
    private void setMembershipType(String membershipTypeId, Membership membership) throws Exception {
        MembershipTypeDAO membershipTypeDAO = new MembershipTypeDAO();
        MembershipType membershipType = membershipTypeDAO.getMembershipTypeById(Long.parseLong(membershipTypeId));
        if (membershipType != null) {
            membership.setMembershipType(membershipType);
        } else {
            throw new Exception("Membership Type not found with ID: " + membershipTypeId);
        }
    }

    // Method to save membership and handle success
    private void saveMembership(Membership membership, HttpServletResponse response) throws Exception {
        MembershipDAO membershipDAO = new MembershipDAO();
        if (membershipDAO.saveMembership(membership)) {
            response.sendRedirect("MembershipSuccess.html");
        } else {
            throw new Exception("Error saving membership.");
        }
    }

    // Helper method to parse date strings
    private Date parseDate(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateStr);
    }
}
