

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowRoomsServlet
 */
@WebServlet("/ShowRoomsServlet")
public class ShowRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Model model = (Model) request.getServletContext().getAttribute("model");
        String html = "<html>"
		+ "<body>"
		+ "<h1>ShowRoomsServlet</h1><br>"
		+ "<h3>Logged in as: " + request.getSession().getAttribute("username") + "</h3>"
		+ "<form action=SearchRoomServlet method=post>"
		+ "<input type=submit text=submit value=uitloggen></form><br>"
		+ "<a href=addRoom.html>Add a new Room</a><br>"
		+ "<h3>Current rooms:</h3>"
		+ "<table border=1>"
		+ "<tr><td>SqaureMeters</td><td>Price</td><td>City</td></tr>";
		
        for (Room room : model.getRooms()) {
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
//		request.getSession().removeAttribute("username");
		request.getSession().invalidate();
		response.sendRedirect("login.html");
	}

}
