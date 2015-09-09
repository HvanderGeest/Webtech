package nl.saxion.controllers;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.saxion.model.Huurder;
import nl.saxion.model.Model;
import nl.saxion.model.User;
import nl.saxion.model.Verhuurder;

/**
 * Servlet implementation class ServletEE
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model m;
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
	
		
		
		PrintWriter writer  = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		m = (Model) getServletContext().getAttribute(nl.saxion.helpers.ServletContext.MODEL_STRING);
		if(type != null && !username.isEmpty() && !password.isEmpty() && !m.userNameExists(username)){
			if(type.equals("huurder")){
				m.addUser(new Huurder(username, password));
			} else if(type.equals("verhuurder")){
				m.addUser(new Verhuurder(username, password));
			}
			
			
		
			response.sendRedirect("login.html");
		} else {
			writer.append("niet alle gegevens zijn ingevuld of de gebruikersnaam bestaat al");
		}
		doGet(request, response);
	}
	@Override
	public void init() throws ServletException {
		
		
		
		super.init();
	}

}
