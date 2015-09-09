

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helpers.ServletContext;
import model.Kamer;
import model.Model;
import model.User;

/**
 * Servlet implementation class SearchRoomsServlet
 */
@WebServlet("/SearchRoomsServlet")
public class SearchRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRoomsServlet() {
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
		Model model = (Model) request.getServletContext().getAttribute(helpers.ServletContext.MODEL_STRING);
		User ingelogdeUser = (User) request.getSession().getAttribute(ServletLogin.INGELOGDE_USER);
		PrintWriter writer = response.getWriter();
		if(ingelogdeUser == null){
			writer.write("U bent nog niet ingelogd, ga naar de inlog pagina om in te loggen");
			return;
		}
		if(request.getParameter("surface").isEmpty() || request.getParameter("price").isEmpty() || request.getParameter("country").isEmpty()){
			request.getRequestDispatcher("WEB-INF/huurder.html").forward(request, response);
			return;
		}
		int surface = Integer.parseInt((String) request.getParameter("surface"));
		int price = Integer.parseInt((String) request.getParameter("price")) ;
		String place = (String) request.getParameter("country");
		
		
		String html = "<h1>Search Results</h1><br><TABLE BORDER='1'><TR> <TH>Surface (mm2)</TH> <TH>Price</TH> <TH>Place</TH><TH>Landlord</TH> </TR>";
		for(Kamer k : model.searchRooms(surface, price, place)){
			String row = "<TR> <TD>"+k.getSurfaceInMeter()+"</TD> <TD>"+k.getPriceInEuro()+"</TD> <TD>"+k.getPlace()+"</TD><TD>"+k.getLandLord().getUsername()+"</TD>  </TR>";
			html+= row;
		}
		html+="</TABLE>";
		writer.write(html);
		doGet(request, response);
	}

}
