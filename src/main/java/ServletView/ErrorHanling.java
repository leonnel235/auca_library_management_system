package ServletView;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorHandlingServlet")
public class ErrorHanling extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        handleError(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        handleError(req, res);
    }

    private void handleError(HttpServletRequest req, HttpServletResponse res) throws IOException {
        // Get the status code from the request attributes
        Integer status = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
        String errorMessage = (String) req.getAttribute("javax.servlet.error.message");

        if (servletName == null) {
            servletName = "Unknown Error";
        }

        // Set the content type for the response
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Generate the error response based on the status code
        out.println("<html><body>");
        out.println("<h2>Error Occurred</h2>");
        out.println("<p>Servlet Name: " + servletName + "</p>");

        if (status != null) {
            switch (status) {
                case 404:
                    out.println("<p>The resource you are looking for is not available (404).</p>");
                    break;
                case 500:
                    out.println("<p>Server Error, please try again later (500).</p>");
                    break;
                default:
                    out.println("<p>An unexpected error occurred. Please try again later.</p>");
                    break;
            }
        } else {
            out.println("<p>An unknown error occurred. Please try again later.</p>");
        }

        // Display any additional error message if available
        if (errorMessage != null) {
            out.println("<p>Error Message: " + errorMessage + "</p>");
        }

        out.println("<p><a href='CreateLocation.html'>Go back to the home page</a></p>");
        out.println("</body></html>");
    }
}
