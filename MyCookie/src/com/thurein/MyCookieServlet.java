package com.thurein;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyCookieServlet
 */
@WebServlet("/MyCookieServlet")
public class MyCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyCookieServlet() {
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
		
		response.setContentType("text/html");
		String name = request.getParameter("name");
		Cookie[] cookie = request.getCookies();
		PrintWriter out = response.getWriter();
		String myName = "";
		
		
		if(cookie != null) {
			for(Cookie ck:cookie) {
				if(ck.getValue().equals(name)) {
					myName = ck.getValue();
				}						
			}
					
		}
		
		
		
		if(name.equals(myName)) {
			out.println("Welcome back,th visitor");
			request.getRequestDispatcher("index.html").include(request, response);
			
		}else {
			out.println("Welcome Abroad");
			out.println("You are the first visitor!");
			Cookie c = new Cookie(name, name);
			response.addCookie(c);
			request.getRequestDispatcher("index.html").include(request, response);
			
		}
		
	
		
		
		
}
}
