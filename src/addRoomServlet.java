

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addRoomServlet
 */
@WebServlet("/addRoomServlet")
public class addRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int squaremeter = Integer.parseInt(request.getParameter("squaremeter"));
		int price = Integer.parseInt(request.getParameter("price"));
		String city = request.getParameter("city");
		
		Model model = (Model) request.getServletContext().getAttribute("model");
		model.getRooms();
		model.addRoom(new Room(squaremeter, price, city));
		System.out.println("Room added= \r\nSquareMeters: " + squaremeter + "\r\nPrice: " + price + "\r\nCity: " + city);
	}

}
