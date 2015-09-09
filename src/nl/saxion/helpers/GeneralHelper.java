package nl.saxion.helpers;

import javax.servlet.http.HttpServletRequest;

public class GeneralHelper {

	private static final String INGELOGDE_USER = "ingelogdeUser";
	
	public static void logout(HttpServletRequest request) {
		request.getSession(false).setAttribute(INGELOGDE_USER, null);
	}
}
