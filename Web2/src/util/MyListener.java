package util;

import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	ServletContext con=se.getSession().getServletContext();
    	Object num=con.getAttribute("num");
		if(Objects.isNull(num)) {
			int i=1;
			con.setAttribute("num",i);
		}
		else {
			int i=Integer.parseInt(String.valueOf(num));
			i++;
			con.setAttribute("num",i);
		}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext con=se.getSession().getServletContext();
		Object num=con.getAttribute("num");
		if(Objects.isNull(num)) {
			int i=1;
			con.setAttribute("num", i);
		}
		else {
			int i=Integer.parseInt(String.valueOf(num));
			i--;
			con.setAttribute("num",i);
		}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	int i=0;
    	sce.getServletContext().setAttribute("num",i);
    }
	
}