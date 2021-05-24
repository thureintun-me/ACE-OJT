package studentmanagement.controller;

import java.io.IOException;
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
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassServiceImpl cimpl = new ClassServiceImpl();
		ClassRequestDTO cdto = new ClassRequestDTO();
		cdto.setClassId("");
		cdto.setClassName("");
		
		List<ClassResponseDTO> list = cimpl.select(cdto);
		request.getServletContext().setAttribute("classlist", list);

		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentName(request.getParameter("name"));
		dto.setStudentId("");
		dto.setClassName("");
		StudentServiceImpl simpl = new StudentServiceImpl();
		StudentResponseDTO res = simpl.selectStudent(dto).get(0);
		StudentBean bean = new StudentBean();
		bean.setStudentId(res.getStudentId());
		bean.setStudentName(res.getStudentName());
		bean.setClassName(res.getClassName());
		bean.setYear(res.getRegisterDate().substring(0, 4));
		bean.setMonth(res.getRegisterDate().substring(5, 7));
		bean.setDay(res.getRegisterDate().substring(8, 10));
		bean.setStatus(res.getStatus());

		request.setAttribute("bean", bean);
		request.getRequestDispatcher("BUD002-01.jsp").forward(request, response);
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
			dto.setStudentId(bean.getStudentId());
			dto.setStudentName(bean.getStudentName());
			dto.setStatus(bean.getStatus());
			dto.setClassName(bean.getClassName());
			dto.setRegisterDate(bean.getYear() + "-" + bean.getMonth() + "-" + bean.getDay());
			StudentServiceImpl impl = new StudentServiceImpl();
			
			
			
				int res = impl.updateStudent(dto);
				if (res > 0)
					request.setAttribute("msg", "update successful");
				else
					request.setAttribute("err", "update fail");
			

		
		  } else request.setAttribute("err", "Fields must not be null");
		 
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("BUD001.jsp").forward(request, response);
	}

}
