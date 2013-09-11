

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
        		+ "<h1>ShowRoomsServlet</h1><br>        "
        		+ "<form action=FoundRoomsServlet method=&quot;post&quot;>        "
        		+ "Square meter: <input type=&quot;text&quot; name=&quot;sqauremeter&quot;><br>        "
        		+ "Max price: <input type=&quot;text&quot; name=&quot;maxprice&quot;><br>        "
        		+ "City: <input type=&quot;text&quot; name=&quot;city&quot;><br>       "
        		+ "<input type=submit text=Submit value=Search></input><br>        "
        		+ "</form>        "
        		+ "</body>        "
        		+ "</html>");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
