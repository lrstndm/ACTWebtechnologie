

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true); // TODO meneer zei false maar dan krijg ik een error bij het uitloggen en daarna weer inloggen
		Model model = (Model)getServletContext().getAttribute("model");
		ArrayList<User> users = model.getUsers();
		if (users != null) {
			boolean found = false;
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			for (User u : users) {
				System.out.println("found: " + u.username + " - " + u.password + " - " + u.soort);
				if (u.username.equals(username) && u.password.equals(password)) {
					System.out.println("MATCH - " + u.soort);
					switch (u.soort) {
					case "verhuurder":
						found = true;
						session.setAttribute("username", u.getUsername());
						response.sendRedirect("ShowRoomsServlet");
						break;
					case "huurder":
						found = true;
						session.setAttribute("username", u.getUsername());
						response.sendRedirect("SearchRoomServlet");
						break;
					case "beheerder":
						found = true;
						session.setAttribute("username", u.getUsername());
						response.sendRedirect("ShowPersonsServlet");
					default:
						break;
					}
				}
			}
			if (!found) {
				response.sendRedirect("wrongLogin.html");
			}
		} else {
			response.sendRedirect("wrongLogin.html");
		}
	}

}
