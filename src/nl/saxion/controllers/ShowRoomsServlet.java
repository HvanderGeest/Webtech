package nl.saxion.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import nl.saxion.model.Kamer;
import nl.saxion.model.Model;
import nl.saxion.model.User;
import nl.saxion.views.Table;

/**
 * Servlet implementation class ShowRoomsServlet
 */
@WebServlet("/ShowRoomsServlet")
public class ShowRoomsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRoomsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model model = (Model) request.getServletContext().getAttribute(nl.saxion.helpers.ServletContext.MODEL_STRING);
		User ingelogdeUser = (User) request.getSession().getAttribute(ServletLogin.INGELOGDE_USER);
		PrintWriter writer = response.getWriter();
		if(ingelogdeUser == null){
			writer.write("U bent nog niet ingelogd, ga naar de inlog pagina om in te loggen");
			return;
		}
		
		
		writer.write(Table.getRoomsFromVerhuurderTable(model.getRoomsFromLandLord(ingelogdeUser)));
		writer.append("<a href= 'addroom.html'>Klik here to add a room</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
