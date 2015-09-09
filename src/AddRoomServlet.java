

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ServletContext;
import model.Huurder;
import model.Model;
import model.User;

/**
 * Servlet implementation class AddRoomServlet
 */
@WebServlet("/AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoomServlet() {
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
		Model model = (Model) getServletContext().getAttribute(ServletContext.MODEL_STRING);
		User u = (User) request.getSession().getAttribute(ServletLogin.INGELOGDE_USER);
		if(u == null || u instanceof Huurder){
			request.getSession().invalidate();
			response.sendRedirect("login.html");
			return;
		}
		if(request.getParameter("surface").isEmpty() || request.getParameter("price").isEmpty() || request.getParameter("country").isEmpty() ){
			request.getRequestDispatcher("addroom.html").forward(request, response);
			return;
		}
		int surface = Integer.parseInt((String) request.getParameter("surface"));
		int price = Integer.parseInt((String) request.getParameter("price")) ;
		String place = (String) request.getParameter("country");
		model.addRoom(surface, price, place, u);
		response.sendRedirect("ShowRoomsServlet");
		
		doGet(request, response);
	}

}
