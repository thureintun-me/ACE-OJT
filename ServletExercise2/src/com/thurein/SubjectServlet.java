package com.thurein;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] subjects = request.getParameterValues("subject");
		PrintWriter out = response.getWriter();
		
		if(subjects==null) {
			out.println("<p style='color:red;'>Choose One!!! </p>");
			//request.getRequestDispatcher("chooseSubjectError.html").forward(request, response);
			request.getRequestDispatcher("chooseSubject.html").include(request, response);
			//
		}else {
			out.println("Your profession is ");
			out.println();
			for(int i=0;i<subjects.length;i++) {
				out.println((i+1) + ". "+ subjects[i]);
			}
		}
 	}

}
