package nl.saxion.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.saxion.helpers.ServletContext;
import nl.saxion.model.Kamer;
import nl.saxion.model.Model;
import nl.saxion.model.User;
import nl.saxion.views.Table;

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
		Model model = (Model) request.getServletContext().getAttribute(nl.saxion.helpers.ServletContext.MODEL_STRING);
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
		
		
		
		writer.write(Table.getSearchRoomsTable(model.searchRooms(surface, price, place)));
		doGet(request, response);
	}

}
