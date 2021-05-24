package studentmanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.dto.StudentRequestDTO;
import studentmanagement.service.StudentServiceImpl;

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(request.getParameter("id"));
		System.out.println("bean"+request.getParameter("id"));
		StudentServiceImpl impl = new StudentServiceImpl();
		int res = impl.deleteStudent(dto);
		System.out.println("res"+res);
		if (res > 0)
			request.setAttribute("msg", "Delete successful");
		else
			request.setAttribute("err", "Delete fail");
		request.getRequestDispatcher("BUD001.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
