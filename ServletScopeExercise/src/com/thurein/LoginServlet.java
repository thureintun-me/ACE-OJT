package com.thurein;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		ServletContext context = getServletContext();
		String nameinScope= (String)context.getAttribute("name");
		String passinScope= (String)context.getAttribute("password");
		
		if(name.equals("") || password.equals("")) {
			out.println("<p style='color:red'>Fill tthe blank!!!</p>");
			request.getRequestDispatcher("login.html").include(request, response);
		}else if(!nameinScope.equals(name) || !passinScope.equals(password)) {
			out.println("<p style='color:red'>Username and password do not match</p>");
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			out.println("<h2>Successfully login " + name + "</h2>");
		}
	}

}
