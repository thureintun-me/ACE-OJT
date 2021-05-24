package bookmanagement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmanagement.model.BookBean;
import bookmanagement.persistant.dto.BookRequestDTO;
import bookmanagement.persistant.dto.BookResponseDTO;
import bookmanagement.service.BookServiceImpl;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(request.getParameter("code"));
		BookServiceImpl impl = new BookServiceImpl();
		BookResponseDTO res = impl.selectOne(dto);
		request.setAttribute("res", res);

		request.getRequestDispatcher("updatebook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookBean bean = new BookBean();
		String code = request.getParameter("code");
		bean.setBookCode(code);
		bean.setBookTitle(request.getParameter("title"));
		bean.setBookAuthor(request.getParameter("author"));
		bean.setBookPrice(request.getParameter("price"));
		if (bean.getBookCode().equals("") || bean.getBookTitle().equals("") || bean.getBookAuthor().equals("")
				|| bean.getBookPrice().equals("")) {
			request.setAttribute("error", "Field cannot be blank!");
			request.setAttribute("bean", bean);

			request.getRequestDispatcher("update.jsp").forward(request, response);
		} else {
			BookServiceImpl impl = new BookServiceImpl();
			BookRequestDTO dto = new BookRequestDTO();
			dto.setBookCode(bean.getBookCode());
			dto.setBookTitle(bean.getBookTitle());
			dto.setBookAuthor(bean.getBookAuthor());
			dto.setBookPrice(Double.valueOf(bean.getBookPrice()));
			int i = impl.updateData(dto);
			if (i > 0)
				response.sendRedirect("DisplayServlet");
			else {
				request.setAttribute("error", "Update Fail!");
				request.setAttribute("bean", bean);

				request.getRequestDispatcher("addbook.jsp").forward(request, response);

			}
		}
	}

}
