package com.exercise.model;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.exercise.dao.ClassDAO;
import com.exercise.dto.ClassDTO;

@ManagedBean(name = "studentclass")
@RequestScoped
public class ClassBean {
	private String id;
	private String name;
	private ClassDAO dao = new ClassDAO();

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

	public ArrayList<ClassDTO> classList() {
		ArrayList<ClassDTO> list = dao.selectAll();
		return list;
	}

	public String save() {
		ClassDTO dto = new ClassDTO();
		dto.setId(id);
		dto.setName(name);

		ClassDTO dtos = new ClassDTO();
		dtos.setId(id);

		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();
		list = dao.selectOne(dtos);
		if (list.size() == 0) {
			int result = dao.insertData(dto);
			if (result != 0)
					showMessage("Save Successful");
			else
					errMessage("Insert Fail!");
			return "BUD003.xhtml";
		} else {
			errMessage("Class Id is already exist");
			return "BUD003.xhtml";
		}
		

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
