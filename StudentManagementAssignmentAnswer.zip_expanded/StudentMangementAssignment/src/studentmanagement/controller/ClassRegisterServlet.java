package studentmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.dao.ClassDAO;
import studentmanagement.dto.ClassRequestDTO;
import studentmanagement.dto.ClassResponseDTO;
import studentmanagement.model.ClassBean;

/**
 * Servlet implementation class ClassRegisterServlet
 */
@WebServlet("/ClassRegisterServlet")
public class ClassRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassBean bean = new ClassBean();
		bean.setId(request.getParameter("id"));
		bean.setName(request.getParameter("name"));

		if (!bean.getId().equals("") || !bean.getName().equals("")) {
			ClassRequestDTO dto = new ClassRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			ClassDAO dao = new ClassDAO();
			List<ClassResponseDTO> list = dao.select(dto);
			if (list.size() != 0)
				request.setAttribute("err", "Class has been already exist!");
			else {
				int res = dao.insert(dto);
				if (res > 0)
					request.setAttribute("msg", "Insert successful");
				else
					request.setAttribute("err", "Insert fail");
			}
		} else
			request.setAttribute("err", "Fields must not be null");
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("BUD003.jsp").forward(request, response);
	}

}
