package bookmanagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import bookmanagement.dao.BookDAO;
import bookmanagement.dto.BookRequestDTO;
import bookmanagement.dto.BookResponseDTO;

@ManagedBean(name="book")
@RequestScoped
public class BookBean {

	private String bookCode;
	private String bookTitle;
	private String bookAuthor;
	private String bookPrice;
	private BookDAO dao = new BookDAO();
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public BookDAO getDao() {
		return dao;
	}

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}

	public Map<String, Object> getRequestMap() {
		return sessionMap;
	}

	public void setRequestMap(Map<String, Object> requestMap) {
		this.sessionMap = requestMap;
	}

	public ArrayList<BookResponseDTO> bookList() {
		List<BookResponseDTO> list = new ArrayList<BookResponseDTO>();
		for(BookResponseDTO b:list) {
			System.out.println("b.Name" + b.getBookTitle());
		}
		return dao.selectAll();
	}

	public String save() {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(bookCode);
		dto.setBookTitle(bookTitle);
		dto.setBookAuthor(bookAuthor);
		dto.setBookPrice(Double.valueOf(bookPrice));
		int result = dao.insertData(dto);
		if (result != 0)
			return "index.xhtml?faces-redirect=true";
		else
			return "addbook.xhtml?faces-redirect=true";
	}

	public String edit(String code) {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(code);
		BookResponseDTO res = dao.selectOne(dto);
		BookBean book = new BookBean();
		book.setBookCode(res.getBookCode());
		book.setBookTitle(res.getBookTitle());
		book.setBookAuthor(res.getBookAuthor());
		book.setBookPrice(String.valueOf(res.getBookPrice()));
		sessionMap.put("editBook", book);
		return "/updatebook.xhtml?face;s-redirect=true";
	}

	public String update(BookBean book) {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(book.getBookCode());
		dto.setBookTitle(book.getBookTitle());
		dto.setBookAuthor(book.getBookAuthor());
		dto.setBookPrice(Double.valueOf(book.getBookPrice()));
		int result = dao.updateData(dto);
		if (result != 0)
			return "index.xhtml?faces-redirect=true";
		else
			return "updatebook.xhtml?faces-redirect=true";
	}

	public void delete(String code) {
		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(code);
		dao.deleteData(dto);
	}
}
