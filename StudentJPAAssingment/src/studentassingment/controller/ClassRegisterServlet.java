package studentassingment.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentassingment.dao.ClassDAO;
import studentassingment.dto.ClassDTO;
import studentmanagement.model.ClassBean;
import studentmanagement.model.UserBean;


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
			
				
				ClassDTO dto = new ClassDTO();
				ClassDTO cdto = new ClassDTO();
				ClassDAO dao = new ClassDAO();
				cdto.setClassId(bean.getClassId());
				dto.setClassId(bean.getClassId());
				dto.setClassName(bean.getClassName());
				List<ClassDTO> list = new ArrayList<ClassDTO>();
				list=dao.selectClass(cdto);
				
				if (list.size() != 0)
					request.setAttribute("err", "Class has been already exist!");
				else {
					int counter = dao.insertClass(dto);
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
