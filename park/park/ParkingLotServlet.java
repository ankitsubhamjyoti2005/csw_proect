import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParkingLotServlet")
public class ParkingLotServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Map<String, String> vehicles = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registrationNumber = request.getParameter("registrationNumber");
        String color = request.getParameter("color");

        vehicles.put(registrationNumber, color);

        response.sendRedirect("index.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registrationNumber = request.getParameter("registrationNumber");
        String color = request.getParameter("color");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.println("<html><body>");

        if (registrationNumber != null) {
            if (vehicles.containsKey(registrationNumber)) {
                out.println("Registration Number: " + registrationNumber + "<br>");
                out.println("Color: " + vehicles.get(registrationNumber) + "<br>");
            } else {
                out.println("Vehicle not found with registration number: " + registrationNumber + "<br>");
            }
        } else if (color != null) {
            boolean found = false;
            for (Map.Entry<String, String> entry : vehicles.entrySet()) {
                if (entry.getValue().equalsIgnoreCase(color)) {
                    out.println("Registration Number: " + entry.getKey() + ", Color: " + entry.getValue() + "<br>");
                    found = true;
                }
            }
            if (!found) {
                out.println("No vehicles found with color: " + color + "<br>");
            }
        } else {
            out.println("Invalid request<br>");
        }

        out.println("</body></html>");
    }
}
