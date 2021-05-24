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
import studentmanagement.dto.UserRequestDTO;
import studentmanagement.model.ClassBean;
import studentmanagement.model.UserBean;
import studentmanagement.service.ClassServiceImpl;
import studentmanagement.service.UserServiceImpl;

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
		ClassBean bean = new ClassBean();
		bean.setClassId(request.getParameter("id"));
		bean.setClassName(request.getParameter("name"));
		
		
		if(!bean.getClassId().equals("") || !bean.getClassName().equals("")){
			
				
				ClassRequestDTO dto = new ClassRequestDTO();
				ClassRequestDTO cdto = new ClassRequestDTO();
				ClassServiceImpl impl = new ClassServiceImpl();
				cdto.setClassId(bean.getClassId());
				dto.setClassId(bean.getClassId());
				dto.setClassName(bean.getClassName());
				List<ClassResponseDTO> list = new ArrayList<ClassResponseDTO>();
				list=impl.select(cdto);
				if (list.size() != 0)
					request.setAttribute("err", "Class has been already exist!");
				else {
					int counter = impl.classInsert(dto);
					if(counter>0) {
						request.setAttribute("msg", "Insert Successful");
					}else 
						request.setAttribute("msg", "Insert fail...");
				}
				
			
		}else 
			request.setAttribute("err", "fields must not be null");
		
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BUD003.jsp").forward(request, response);
			
		
	}

}
