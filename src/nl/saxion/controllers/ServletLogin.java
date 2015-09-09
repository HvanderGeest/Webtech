package nl.saxion.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.saxion.helpers.ServletContext;
import nl.saxion.model.Huurder;
import nl.saxion.model.Model;
import nl.saxion.model.User;
import nl.saxion.model.Verhuurder;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;
	public static final String INGELOGDE_USER = "ingelogdeUser";
       
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
		PrintWriter w = response.getWriter();
		model = (Model) getServletContext().getAttribute(ServletContext.MODEL_STRING);
		String inputUserName = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		User u = model.getUser(inputUserName);
		if(u != null){
			if(u.getPassword().equals(inputPassword)){
				request.getSession().setAttribute(INGELOGDE_USER, u);
				if(u instanceof Verhuurder){
					
					request.getRequestDispatcher("addroom.html").forward(request, response);
					
					
				} else if(u instanceof Huurder){
					request.getRequestDispatcher("WEB-INF/huurder.html").forward(request, response);
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
