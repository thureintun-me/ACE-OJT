package studentmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.dto.ClassRequestDTO;
import studentmanagement.dto.ClassResponseDTO;
import studentmanagement.dto.StudentRequestDTO;
import studentmanagement.dto.StudentResponseDTO;
import studentmanagement.model.StudentBean;
import studentmanagement.service.ClassServiceImpl;
import studentmanagement.service.StudentServiceImpl;

/**
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClassRequestDTO dto = new ClassRequestDTO();
		dto.setClassId("");
		dto.setClassName("");
		ClassServiceImpl impl = new ClassServiceImpl();
		List<ClassResponseDTO> list = new ArrayList<ClassResponseDTO>();
		list = impl.select(dto);
		
		request.getServletContext().setAttribute("classlist", list);
		request.getRequestDispatcher("BUD002.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentBean bean = new StudentBean();
		bean.setStudentId(request.getParameter("id"));
		bean.setStudentName(request.getParameter("name"));
		bean.setDay(request.getParameter("day"));
		bean.setMonth(request.getParameter("month"));
		bean.setYear(request.getParameter("year"));
		bean.setStatus(request.getParameter("status"));
		bean.setClassName(request.getParameter("className"));
		
		
		if (!bean.getStudentId().equals("") || !bean.getStudentName().equals("") || !bean.getStatus().equals("")
				|| !bean.getClassName().equals("") || !bean.getDay().equals("Day") || !bean.getMonth().equals("Month")
				|| !bean.getYear().equals("Year")) {
			StudentRequestDTO dto = new StudentRequestDTO();
			StudentRequestDTO stdto = new StudentRequestDTO();
			stdto.setStudentId(bean.getStudentId());
			
			dto.setStudentId(bean.getStudentId());
			dto.setStudentName(bean.getStudentName());
			dto.setStatus(bean.getStatus());
			dto.setClassName(bean.getClassName());
			dto.setRegisterDate(bean.getYear() + "-" + bean.getMonth() + "-" + bean.getDay());
			StudentServiceImpl impl = new StudentServiceImpl();
			List<StudentResponseDTO> list = impl.selectStudent(stdto);
			if (list.size()!=0) 
				request.setAttribute("err", "StudentId has been already exist!");
			else {
				int res = impl.insertStudent(dto);
				if (res > 0)
					request.setAttribute("msg", "Insert successful");
				else
					request.setAttribute("err", "Insert fail");
			}

		
		  } else request.setAttribute("err", "Fields must not be null");
		 
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("BUD002.jsp").forward(request, response);
	}

}
