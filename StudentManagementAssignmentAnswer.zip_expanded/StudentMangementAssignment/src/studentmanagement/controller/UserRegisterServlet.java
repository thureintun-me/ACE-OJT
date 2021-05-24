package studentmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.dao.UserDAO;
import studentmanagement.dto.UserRequestDTO;
import studentmanagement.dto.UserResponseDTO;
import studentmanagement.model.UserBean;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		if (!bean.getId().equals("") || !bean.getName().equals("") || !bean.getPassword().equals("")
				|| !bean.getConfirm().equals("")) {
			if (bean.getPassword().equals(bean.getConfirm())) {
				UserRequestDTO dto = new UserRequestDTO();
				dto.setId(bean.getId());
				dto.setName(bean.getName());
				dto.setPassword(bean.getPassword());
				UserDAO dao = new UserDAO();
				List<UserResponseDTO> list = dao.select(dto);
				if (list.size() != 0)
					request.setAttribute("err", "UserId has been already exist!");
				else {
					int res = dao.insert(dto);
					if (res > 0)
						request.setAttribute("msg", "Insert successful");
					else
						request.setAttribute("err", "Insert fail");
					request.getRequestDispatcher("USR001.jsp").forward(request, response);
				}
			} else
				request.setAttribute("err", "Password are not match");
		} else
		request.setAttribute("err", "Fields must not be null");
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("USR002.jsp").forward(request, response);
	}

}
