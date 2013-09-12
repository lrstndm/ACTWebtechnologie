

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowPersonsServlet
 */
@WebServlet("/ShowPersonsServlet")
public class ShowPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPersonsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			date = cookie.getValue();
		}
		
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Model model = (Model) request.getServletContext().getAttribute("model");
        String html = "<html>"
		+ "<body>"
		+ "<h1>ShowPersonsServlet</h1><br>"
		+ "<h3>Logged in as : " + request.getSession().getAttribute("username") + "</h3>"
		+ "<h5>Last login: " + date + "</h5>"
		+ "<form action=SearchRoomServlet method=post>"
		+ "<input type=submit text=submit value=uitloggen></form><br>"
		+ "<h3>Current users:</h3>"
		+ "<table border=1>"
		+ "<tr><td>Username</td><td>Password</td><td>Group</td></tr>";
		
        for (User user : model.getUsers()) {
			html += "<tr><td>" + user.getUsername() + "</td><td>" + user.getPassword() + "</td><td>" + user.getSoort() + "</td></tr>";
		}
        
        html += "</table>"
        		+ "</body>"
        		+ "<html>";
        out.print(html);
        
        
        
        Calendar cal = java.util.Calendar.getInstance();
        String datum = cal.get(Calendar.YEAR) + " - " + cal.get(Calendar.MONTH) + " - " + cal.get(Calendar.DAY_OF_MONTH) + "  " + cal.get(Calendar.HOUR) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND); 
//        System.out.println(cal.toString(). + "");
        Cookie cookie = new Cookie("lastView", datum);
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
