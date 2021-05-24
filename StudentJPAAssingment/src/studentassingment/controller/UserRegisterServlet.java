package studentassingment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentassingment.dao.UserDAO;
import studentassingment.dto.UserDTO;
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
	
		UserBean bean = new UserBean();
		bean.setUserId(request.getParameter("userId"));
		bean.setUserName(request.getParameter("userName"));
		bean.setPassword(request.getParameter("userPass"));
		bean.setConfirmPass(request.getParameter("userCon"));
		
		
		if(!bean.getUserId().equals("") || !bean.getUserName().equals("") || !bean.getPassword().equals("")
	|| !bean.getConfirmPass().equals("")) {
			
			if(bean.getPassword().equals(bean.getConfirmPass())) {
				
				UserDTO dto = new UserDTO();
				
				UserDTO usrDto = new UserDTO();
				usrDto.setUserId(bean.getUserId());
				
				
				UserDAO  dao = new UserDAO();
				dto.setUserId(bean.getUserId());
				dto.setUserName(bean.getUserName());
				dto.setPassword(bean.getPassword());
				
				
				
				List<UserDTO> isDTO = dao.selectUser(usrDto);
				
				
				if(isDTO.size()!=0) 
					request.setAttribute("err", "UserId has been already exist!");
				else {
					int counter = dao.insertUser(dto);
					if(counter>0)
					  request.setAttribute("msg", "Insert Successful");
					else 
				
						request.setAttribute("msg", "Insert fail...");
					request.getRequestDispatcher("USR002.jsp").forward(request, response);
				}
				}else 
				  request.setAttribute("err", "Password do not match!!");
			
		}else 
			request.setAttribute("err", "fields must not be null");
		
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("USR002.jsp").forward(request, response);
			
			
	}
	}


