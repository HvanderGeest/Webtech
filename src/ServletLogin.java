

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter w = response.getWriter();
		HashMap<String, User> users = (HashMap<String, User>) session.getAttribute(ServletRegister.REGISTERED_USERS_SESSION);
		String inputUserName = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		User u = users.get(inputUserName);
		if(u != null){
			if(u.getPassword().equals(inputPassword)){
				if(u.getType().equals(User.VERHUURDER_STRING)){
					response.sendRedirect("addroom.html");
				} else if(u.getType().equals(User.HUURDER_STRING)){
					response.sendRedirect("huurder.html");
				}
			} else {
				w.write("password incorect");
			}
		} else {
			w.write("username not found");
		}
		
		doGet(request, response);
	}

}
