package ServletView;

import dao.MembershipTypeDAO;
import model.MembershipType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MembershipTypeServlet")
public class MembershipTypeServlet extends HttpServlet {

    private MembershipTypeDAO membershipTypeDAO = new MembershipTypeDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get parameters from the request
        String membershipName = request.getParameter("membershipName");
        int maxBooks;
        float price;
        
        try {
            maxBooks = Integer.parseInt(request.getParameter("maxBooks"));
            price = Float.parseFloat(request.getParameter("price"));
        } catch (NumberFormatException e) {
            // Handle invalid number format
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid maxBooks or price format.");
            return;
        }

        // Create and populate MembershipType
        MembershipType membershipType = new MembershipType();
        membershipType.setMembershipName(membershipName);
        membershipType.setMaxBooks(maxBooks);
        membershipType.setPrice(price);

        try {
            // Save the MembershipType using DAO
            membershipTypeDAO.saveMembershipType(membershipType);
            response.sendRedirect("MembershipTypesuccess.html"); 
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error saving Membership Type.");
            e.printStackTrace();
        }
    }
}
