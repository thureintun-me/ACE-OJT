package studentmanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentmanagement.dao.UserDAO;
import studentmanagement.dto.UserDTO;

import studentmanagement.model.UserBean;


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
		HttpSession session = request.getSession(false);
		session.invalidate();
		request.getRequestDispatcher("LGN001.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean bean = new UserBean();
		bean.setUserId(request.getParameter("id"));
		bean.setPassword(request.getParameter("password"));
		if (bean.getUserId().equals("") || bean.getPassword().equals("")) {
			request.setAttribute("err", "Feilds must not be null");
			request.getRequestDispatcher("LGN001.jsp").forward(request, response);
		} else {
			UserDTO dto = new UserDTO();
			dto.setUserId(bean.getUserId());
			UserDAO impl = new UserDAO();
			List<UserDTO> list = impl.select(dto);
			if (list.size() == 0) {
				request.setAttribute("err", "User not found!");
				request.getRequestDispatcher("LGN001.jsp").forward(request, response);
			} else if (bean.getPassword().equals(list.get(0).getPassword())) {
				request.getSession().setAttribute("sesUser", list.get(0));
				request.getRequestDispatcher("M00001.jsp").forward(request, response);
			} else {
				request.setAttribute("err", "Password is incorrect!");
				request.getRequestDispatcher("LGN001.jsp").forward(request, response);
			}
		}
	}

}
