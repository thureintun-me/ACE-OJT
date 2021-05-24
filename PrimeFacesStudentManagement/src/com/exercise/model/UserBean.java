package com.exercise.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import com.exercise.dao.UserDAO;
import com.exercise.dto.UserRequestDTO;
import com.exercise.dto.UserResponseDTO;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {

	private String id;
	private String name;
	private String password;
	private String confirm;

	private UserDAO dao = new UserDAO();

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public ArrayList<UserResponseDTO> userList() {
		ArrayList<UserResponseDTO> list = dao.selectAll();
		return list;
	}

	public String search(UserBean userBean) {

		FacesContext context = FacesContext.getCurrentInstance();
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(userBean.getId());
		dto.setName(userBean.getName());
		UserDAO dao = new UserDAO();
		List<UserResponseDTO> userlist = dao.select(dto);
		if (userlist.size() == 0) {
			return "USR001.xhtml?faces-redirect=true";
		} else {
			context.getExternalContext().getSessionMap().put("userList", userlist);
			return "USR001.xhtml?faces-redirect=true";
		}
		// return null;
	}

	

	public String save() {

		if (password.equals(confirm)) {
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(id);
			dto.setName(name);
			dto.setPassword(password);
			List<UserResponseDTO> list = dao.select(dto);
			if (list.size() != 0) {
				errMessage("UserId has been already exist!");
				return "USR002.xhtml";
			} else {
				int result = dao.insert(dto);

				if (result != 0) {
					showMessage("Save Sucessful!!");
					return "USR002.xhtml";
				} else {
					errMessage("Insert Fail!!");
					return "USR002.xhtml";
				}
			}
		} else {
			errMessage("Password do not match!!");
			return "USR002.xhtml";
		}
	}

	public String edit(String id) {

		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(id);
		UserResponseDTO res = dao.selectOne(dto);
		UserBean user = new UserBean();
		user.setId(res.getId());
		user.setName(res.getName());
		user.setPassword(res.getPassword());
		sessionMap.put("editUser", user);
		return "/USR002-01.xhtml?faces-redirect=true";
		// return null;
	}

	public String update(UserBean userBean) {
		if (userBean.getPassword().equals(userBean.getConfirm())) {
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(userBean.getId());
			dto.setName(userBean.getName());
			dto.setPassword(userBean.getPassword());
			int result = dao.update(dto);
			if (result != 0) {
				ArrayList<UserResponseDTO> list = dao.selectAll();
				sessionMap.put("userList", list);
				showMessage("Update Sucessful!!");
				return "USR001.xhtml";
			} else {
				errMessage("Update Fail!!");
				return "USR002-01.xhtml";
			}

		} else {
			errMessage("Password do not match!!");
			return "USR002-01.xhtml";
		}
	}

	public String delete(String id) {
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(id);
		dao.delete(dto);
		List<UserResponseDTO> list = dao.selectAll();
		sessionMap.put("userList", list);
		return "USR001.xhtml?faces-redirect=true";
	}

	public String login(UserBean userBean) {
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(userBean.getId());
		List<UserResponseDTO> list = dao.select(dto);
//		UserBean user = new UserBean();
//		user.setId(list.get(0).getId());
//		user.setName(list.get(0).getName());
		FacesContext context = FacesContext.getCurrentInstance();
		if (list.size() == 0) {
			errMessage("User Not Found!!");
			return "LGN001.xhtml";
		}else if (userBean.getPassword().equals(list.get(0).getPassword())) {
			java.util.Date date = new java.util.Date();
			context.getExternalContext().getSessionMap().put("loginUser", list.get(0));
			context.getExternalContext().getSessionMap().put("date", date);
			return "M00001.xhtml";
		}else {
			errMessage("Password is incorrect!!");
			return "LGN001.xhtml";
		}
//		UserBean user = new UserBean();
//		user.setId(res.getId());
//		user.setId(res.getId());
//		user.setName(res.getName());
//		user.setPassword(res.getPassword());
//		FacesContext context = FacesContext.getCurrentInstance();
//		if (user.getName() == null) {
//
//			return "LGN001.xhtml?faces-redirect=true";
//
//		} else {
//			java.util.Date date = new java.util.Date();
//			context.getExternalContext().getSessionMap().put("loginUser", user);
//			context.getExternalContext().getSessionMap().put("date", date);
//			return "M00001.xhtml?faces-redirect=true";
//
//		}

	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "LGN001.xhtml?faces-redirect=true";
	}

	public String reset() {
		id = "";
		name = "";
		sessionMap.put("userList", null);
		return "USR001.xhtml?faces-redirect=true";
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
