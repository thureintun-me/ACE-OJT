package studentmanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.dao.UserDAO;
import studentmanagement.dto.UserRequestDTO;
import studentmanagement.model.UserBean;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(request.getParameter("id"));
		UserDAO dao = new UserDAO();
		request.setAttribute("bean", dao.select(dto).get(0));
		request.getRequestDispatcher("USR002-01.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBean bean = new UserBean();
		bean.setId(request.getParameter("userId"));
		bean.setName(request.getParameter("userName"));
		bean.setPassword(request.getParameter("userPass"));
		bean.setConfirm(request.getParameter("userCon"));

		if (!bean.getName().equals("") || !bean.getPassword().equals("") || !bean.getConfirm().equals("")) {
			if (bean.getPassword().equals(bean.getConfirm())) {

				UserRequestDTO dto = new UserRequestDTO();
				dto.setId(bean.getId());
				dto.setName(bean.getName());
				dto.setPassword(bean.getPassword());
				UserDAO dao = new UserDAO();
				int res = dao.update(dto);
				if (res > 0)
					request.setAttribute("msg", "Update successful");
				else
					request.setAttribute("err", "Update fail");
				request.getRequestDispatcher("USR001.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Password are not match");
				request.setAttribute("bean", bean);
				request.getRequestDispatcher("USR002-01.jsp").forward(request, response);
			}

		} else {

			request.setAttribute("err", "Fields must not be null");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("USR002-01.jsp").forward(request, response);
		}
	}

}
