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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		ServletContext context = getServletContext();
		ProfileBean bean = new ProfileBean();
		
		
		PrintWriter out = response.getWriter();
		String password = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPass");
		
	if(!password.equals(confirmPass)) {
			out.println("<p style='color:red'>Password do not match</p>");
			request.getRequestDispatcher("profileRegister.jsp").include(request, response);
		}else {
			bean.setEmail(request.getParameter("email"));
			bean.setPassword(request.getParameter("password"));
			bean.setConfirmPassword(request.getParameter("confirmPass"));
			bean.setName(request.getParameter("name"));
			bean.setGender(request.getParameter("gender"));
			bean.setCourse(request.getParameter("course"));
			bean.setEducation(request.getParameter("education"));
			

			context.setAttribute("bean", bean);

			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
