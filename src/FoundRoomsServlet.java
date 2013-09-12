

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoundRoomsServlet
 */
@WebServlet("/FoundRoomsServlet")
public class FoundRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoundRoomsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int squaremeter = 0;
		int maxPrice = 0;
		try {
			System.out.println(request.getParameter("squaremeter"));
			squaremeter = Integer.parseInt(request.getParameter("squaremeter"));
			
		} catch (NumberFormatException e) {
			System.out.println("sqauremeter not formatted, will be empty");
		}
		try {
			System.out.println(request.getParameter("maxprice"));
			maxPrice = Integer.parseInt(request.getParameter("maxprice"));
		} catch (NumberFormatException e) {
			System.out.println("maxPrice not formatted, will be empty");
		}
		String city = request.getParameter("city");
		Model model = (Model) request.getServletContext().getAttribute("model");
		ArrayList<Room> founRooms = model.search(squaremeter, maxPrice, city);
		String html = "<html>"
				+ "<body>"
				+ "<h1>FoundRoomsServlet</h1><br>"
				+ "<h3>Logged in as: " + request.getSession().getAttribute("username") + "</h3>"
        		+ "<form action=SearchRoomServlet method=post>"
        		+ "<input type=submit text=submit value=uitloggen></form><br>"
				+ "Square Meters: " + squaremeter
				+ "<br>Max rent price: " + maxPrice
				+ "<br>City: " + city
				+ "<h3>Rooms:</h3>"
				+ "<table border=1>"
				+ "<tr><td>SqaureMeters</td><td>Price</td><td>City</td></tr>";
				
		        for (Room room : founRooms) {
					html += "<tr><td>" + room.getSquareMeters() + "</td><td>" + room.getRentPrice() + "</td><td>" + room.getCity() + "</td></tr>";
				}
		        html += "</table>"
		        		+ "</body>"
		        		+ "<html>";
		        out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("username");
		request.getSession().invalidate();
		response.sendRedirect("login.html");
	}

}
