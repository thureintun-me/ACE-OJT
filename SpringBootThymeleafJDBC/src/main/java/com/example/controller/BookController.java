package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.BookDAO;
import com.example.dto.BookRequestDTO;
import com.example.dto.BookResponseDTO;
import com.example.model.BookBean;

@Controller
public class BookController {

	@Autowired
	private BookDAO bookDao;

	@ModelAttribute("bookBean")
	public BookBean getBookBean() {
		return new BookBean();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayView(ModelMap model) {
		List<BookResponseDTO> list = bookDao.selectAll();
		model.addAttribute("list", list);
		return "index";
	}

	@RequestMapping(value = "/setupaddbook", method = RequestMethod.GET)
	public ModelAndView setupaddbook() {
		return new ModelAndView("addbook", "bookBean", new BookBean());
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addbook(@ModelAttribute("bookBean") @Validated BookBean bean,

			BindingResult bs, ModelMap model) {
		if (bs.hasErrors()) {
			return "addbook";
		}
		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(bean.getBookCode());
		dto.setBookTitle(bean.getBookTitle());
		dto.setBookAuthor(bean.getBookAuthor());
		dto.setBookPrice(Double.valueOf(bean.getBookPrice()));
		int rs = bookDao.insertData(dto);
		if (rs == 0) {
			model.addAttribute("error", "Insert Failed");
			return "addbook";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/setupUpdateBook", method = RequestMethod.GET)
	public ModelAndView setupUpdatebook(@RequestParam("code") String bookCode) {

		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(bookCode);
		return new

		ModelAndView("updatebook", "bookBean", bookDao.selectOne(dto));
	}

	@RequestMapping(value = "/updatebook", method = RequestMethod.POST)
	public String updatebook(@ModelAttribute("bookBean") @Validated BookBean bean,

			BindingResult bs, ModelMap model) {
		if (bs.hasErrors()) {
			return "updatebook";
		}
		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(bean.getBookCode());
		dto.setBookTitle(bean.getBookTitle());
		dto.setBookAuthor(bean.getBookAuthor());
		dto.setBookPrice(Double.valueOf(bean.getBookPrice()));
		int rs = bookDao.updateData(dto);
		if (rs == 0) {
			model.addAttribute("error", "Update Failed");
			return "updatebook";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String deleteBook(@RequestParam("code") String bookCode, ModelMap model) {

		BookRequestDTO dto = new BookRequestDTO();
		dto.setBookCode(bookCode);
		int res = bookDao.deleteData(dto);
		if (res == 0) {
			model.addAttribute("error", "Delete Failed");
		}
		return "redirect:/";
	}
}
