package com.thurein;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileRegisterServlet
 */
@WebServlet("/ProfileRegisterServlet")
public class ProfileRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileRegisterServlet() {
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
		
		
		
		
		HttpSession session = request.getSession();
		ProfileBean bean = new ProfileBean();
		
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("password", request.getParameter("password"));
		
		ProfileBean appBean = (ProfileBean) request.getServletContext().getAttribute("bean");
		
		PrintWriter out = response.getWriter();
		
		if(appBean.getEmail().equals(session.getAttribute("email")) && appBean.getPassword().equals(session.getAttribute("password"))) {
			bean.setName(appBean.getName());
			bean.setGender(appBean.getGender());
			bean.setEmail(appBean.getEmail());
			
			
			 session.setAttribute("myBean", bean); 

			 
			response.sendRedirect("showall.jsp");
		}else {
			out.println("<p style='color:red'>Incroeect name or password...</p>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

}
