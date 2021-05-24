package com.exercise.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.exercise.dao.ClassDAO;
import com.exercise.dao.StudentDAO;
import com.exercise.dto.ClassDTO;
import com.exercise.dto.StudentDTO;


@ManagedBean(name = "student")
@RequestScoped
public class StudentBean {
	private String id;
	private String name;
	private String className;
	private Date registerDate;
	private String status;
	private StudentDAO dao = new StudentDAO();
	private ClassDAO cdao = new ClassDAO();
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private UIComponent component;

	public UIComponent getComponent() {
		return component;
	}

	public void setComponent(UIComponent component) {
		this.component = component;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<StudentDTO> studentList() {
		ArrayList<StudentDTO> list = dao.selectAll();
		return list;
	}

	public ArrayList<ClassDTO> classList() {
		ArrayList<ClassDTO> list = cdao.selectAll();
		return list;
	}

	public String save() {
		StudentDTO dtos = new StudentDTO();
		dtos.setId(id);
		StudentDTO dto = new StudentDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setClassName(className);
		dto.setRegisterDate(registerDate);
		dto.setStatus(status);
		List<StudentDTO> list = dao.select(dtos);
		if (list.size() != 0) {
			errMessage("StudentId has been already exist!");
			return "BUD002.xhtml";
		} else {
			int result = dao.insertData(dto);
			if (result != 0) {
				showMessage("Save Sucessful!!");
				return "BUD002.xhtml";
			}
			else {
				errMessage("Insert Fail!!");
				return "BUD002.xhtml";
			}
		}

	}

	public String search(StudentBean student) {
		StudentDTO dto = new StudentDTO();
		dto.setId(student.getId());
		dto.setName(student.getName());
		dto.setClassName(student.getClassName());
		List<StudentDTO> list = dao.select(dto);
		if (list.size() == 0) {
			System.out.println("User not found");
			return "BUD001.xhtml?faces-redirect=true";
		} else {
			sessionMap.put("searchStudentList", list);
			return "BUD001.xhtml?face;s-redirect=true";
		}

	}

	public String edit(String id) {
		StudentDTO dto = new StudentDTO();
		dto.setId(id);
		StudentDTO res = dao.selectOne(dto);
		StudentBean bean = new StudentBean();
		bean.setId(res.getId());
		bean.setName(res.getName());
		bean.setClassName(res.getClassName());
		bean.setRegisterDate(res.getRegisterDate());
		bean.setStatus(res.getStatus());
		sessionMap.put("editStudent", bean);
		return "/BUD002-01.xhtml?face;s-redirect=true";
	}

	public String update(StudentBean bean) {
		StudentDTO dto = new StudentDTO();
		System.out.println("bean in" + bean.getId());
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setClassName(bean.getClassName());
		dto.setRegisterDate(bean.getRegisterDate());
		dto.setStatus(bean.getStatus());
		int result = dao.updateData(dto);
		if (result != 0) {
			List<StudentDTO> list = dao.selectAll();
			sessionMap.put("searchStudentList", list);
			showMessage("Update successful!!");
			return "BUD001.xhtml";
		}
		else {
			errMessage("Update fail!!");
			return "BUD002-01.xhtml";
		}
	}

	public String delete(String id) {
		StudentDTO dto = new StudentDTO();

		dto.setId(id);
		int result = dao.deleteData(dto);
		if (result != 0) {
			List<StudentDTO> list = dao.selectAll();
			sessionMap.put("searchStudentList", list);
			return "BUD001.xhtml?faces-redirect=true";
		} else {
			return "BUD001.xhtml";
		}

	}

	public String reset() {
		id = "";
		name = "";
		className = "";
		status = "";
		sessionMap.put("searchStudentList", null);
		return "BUD001.xhtml?faces-redirect=true";
	}

	public static void showMessage(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));

	}

	public static void errMessage(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", msg));

	}

}
