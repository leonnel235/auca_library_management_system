package ServletView;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Location;
import model.LocationType;
import dao.LocationDAO; // Import the LocationDAO class

@WebServlet("/LocationServlet")
public class LocationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LocationDAO locationDAO; // DAO instance

    public LocationServlet() {
        super();
        locationDAO = new LocationDAO(); // Initialize the DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String locationCode = request.getParameter("locationCode");
        String locationName = request.getParameter("locationName");
        String locationTypeStr = request.getParameter("locationType");

        // Validate and set LocationType
        LocationType locationType;
        try {
            locationType = LocationType.valueOf(locationTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "Invalid Location Type");
            request.getRequestDispatcher("/ErrorHandlingServlet").forward(request, response);
            return;
        }

        // Create a new Location object
        Location location = new Location();
        location.setLocationCode(locationCode);
        location.setLocationName(locationName);
        location.setLocationType(locationType);

        // Persist the Location object using the DAO
        try {
            locationDAO.saveLocation(location); // Use the DAO to save the location
            response.sendRedirect("Locationsuccess.html"); // Redirect to a success page
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Database Error: " + e.getMessage());
            request.getRequestDispatcher("/ErrorHandlingServlet").forward(request, response);
        }
    }
}
