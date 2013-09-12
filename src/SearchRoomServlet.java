

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchPageRenter
 */
@WebServlet("/SearchRoomServlet")
public class SearchRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.print("doPost");
        response.setContentType("text/html");
        out.print("<!DOCTYPE html>        <html>        "
        		+ "<head><meta charset=&quot;ISO-8859-1&quot;>        "
        		+ "<title>Login screen</title>        "
        		+ "</head>        "
        		+ "<body>"
        		+ "<h1>FoundRoomsServlet</h1><br>"
        		+ "<h3>Logged in as: " + request.getSession().getAttribute("username") + "</h3>"
        		+ "<form action=SearchRoomServlet method=post>"
        		+ "<input type=submit text=submit value=uitloggen></form><br>"
        		+ "<form action=FoundRoomsServlet method=&quot;post&quot;>        "
        		+ "Square meter: <input type=&quot;text&quot; name=squaremeter><br>        "
        		+ "Max price: <input type=&quot;text&quot; name=maxprice><br>        "
        		+ "City: <input type=&quot;text&quot; name=city><br>       "
        		+ "<input type=submit text=Submit value=Search></input><br>        "
        		+ "</form>        "
        		+ "</body>        "
        		+ "</html>");  
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
