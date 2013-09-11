

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class AppContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AppContext() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContext) {
    	System.out.println("contextInitialized");
        Model model = new Model();
        servletContext.getServletContext().setAttribute("model", model);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletContext) {
        
    }
	
}
