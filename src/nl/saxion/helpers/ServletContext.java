package nl.saxion.helpers;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.saxion.model.Admin;
import nl.saxion.model.Model;

/**
 * Servlet implementation class ServletContext
 */
@WebListener
public class ServletContext  implements ServletContextListener {
	private static final long serialVersionUID = 1L;
	
	public static final String MODEL_STRING = "ModelString";
       
  

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Model model = new Model();
		arg0.getServletContext().setAttribute(MODEL_STRING, model);
		
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
