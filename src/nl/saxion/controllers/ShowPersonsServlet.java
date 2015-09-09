package nl.saxion.controllers;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.saxion.helpers.ServletContext;
import nl.saxion.model.Huurder;
import nl.saxion.model.Kamer;
import nl.saxion.model.Model;
import nl.saxion.model.User;
import nl.saxion.model.Verhuurder;
import nl.saxion.views.Table;

/**
 * Servlet implementation class ShowPersonsServlet
 */
@WebServlet("/ShowPersonsServlet")
public class ShowPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VISIT_COUNT = "visitcount";
	private final String VISIT_DATE = "visitDate";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPersonsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getSession().getAttribute(ServletLogin.INGELOGDE_USER);
		if(u == null){
			response.sendRedirect("login.html");
			return;
		}
		Model model = (Model) getServletContext().getAttribute(ServletContext.MODEL_STRING);
		Cookie[] cookies = request.getCookies();
		Cookie visitDateCookie = null;
		Cookie visitCountCookie = null;
		String visitDataHtml = "";
		for(int i = 0; i < cookies.length; i++){
			Cookie c = cookies[i];
			if(c.getName().equals(VISIT_DATE)){
				visitDateCookie = c;
			} else if(c.getName().equals(VISIT_COUNT)){
				visitCountCookie =c;
			}
		}
		if(visitDateCookie != null && visitCountCookie != null){
			visitDataHtml = "<p1>Visit count: "+ visitCountCookie.getValue()+", last visit date :"+
					visitDateCookie.getValue()+"</p1> <br>";
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			visitDateCookie.setValue(dateFormat.format(date));
			int visitcount = Integer.parseInt(visitCountCookie.getValue());
			visitcount++;
			visitCountCookie.setValue(visitcount+"");
		} else {
			visitCountCookie = new Cookie(VISIT_COUNT, 1+"");
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			visitDateCookie = new Cookie(VISIT_DATE, dateFormat.format(date));
			visitDataHtml = "<p1>Visit count: "+ visitCountCookie.getValue()+", last visit date :"+
					visitDateCookie.getValue()+"</p1> <br>";
			}
		visitCountCookie.setMaxAge(3000);
		visitDateCookie.setMaxAge(3000);
		response.addCookie(visitCountCookie);
		response.addCookie(visitDateCookie);
		
		

		
		String html = visitDataHtml + Table.getUsersTable(model.getUsers());
		PrintWriter writer = response.getWriter();
		writer.write(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
