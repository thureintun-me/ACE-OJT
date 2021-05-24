package studentmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagement.dao.UserDAO;
import studentmanagement.dto.UserDTO;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO dto = new UserDTO();
		dto.setUserId(request.getParameter("id"));
		UserDAO dao = new UserDAO();
		List<UserDTO> usrList = dao.select(dto);
		
		
		request.setAttribute("bean", usrList.get(0));
		
		request.getRequestDispatcher("USR002-01.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean bean = new UserBean();
		bean.setUserId(request.getParameter("userId"));
		bean.setUserName(request.getParameter("userName"));
		bean.setPassword(request.getParameter("userPass"));
		bean.setConfirmPass(request.getParameter("userCon"));
		
		if(!bean.getUserId().equals("") || !bean.getUserName().equals("") || !bean.getPassword().equals("")
	|| !bean.getConfirmPass().equals("")) {
			
			if(bean.getPassword().equals(bean.getConfirmPass())) {
				
				UserDTO dto = new UserDTO();
				UserDAO impl = new UserDAO();
				dto.setUserId(bean.getUserId());
				dto.setUserName(bean.getUserName());
				dto.setPassword(bean.getPassword());
				
				int counter = impl.updateUser(dto);
				if(counter>0) {
					request.setAttribute("msg", "Update Successful");
				}else 
					request.setAttribute("msg", "update fail...");
			}else 
				request.setAttribute("err", "Password do not match!!");
		}else 
			request.setAttribute("err", "fields must not be null");
		
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("USR001.jsp").forward(request, response);
			
		
	}

}
