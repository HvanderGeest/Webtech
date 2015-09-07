

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class ServletEE
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, User> users;
	public static final String REGISTERED_USERS_SESSION = "registered users";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegister() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute(REGISTERED_USERS_SESSION) == null){
			session.setAttribute(REGISTERED_USERS_SESSION, new HashMap<String, User>());
		} 
		users =  (HashMap<String, User>) session.getAttribute(REGISTERED_USERS_SESSION);
		
		
		PrintWriter writer  = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		if(type != null && !username.isEmpty() && !password.isEmpty() && !users.containsKey(username)){
			users.put(username, new User(username, password, type));
		
			response.sendRedirect("login.html");
		} else {
			writer.println("niet alle gegevens zijn ingevuld of de gebruikersnaam bestaat al");
		}
		doGet(request, response);
	}
	@Override
	public void init() throws ServletException {
		
		
		
		super.init();
	}

}
