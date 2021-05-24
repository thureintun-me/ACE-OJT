package studentmanagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


import studentmanagement.dao.UserDAO;
import studentmanagement.dto.UserRequestDTO;
import studentmanagement.dto.UserResponseDTO;

@ManagedBean(name = "user")
@RequestScoped
public class UserBean {
	private String id;
	private String name;
	private String password;
	private String confirm;
	private UserDAO dao=new UserDAO();
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
	
	public String search(UserBean user) {
		UserRequestDTO dto=new UserRequestDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		UserDAO dao=new UserDAO();
		List<UserResponseDTO> list = dao.select(dto);
		if (list.size() == 0)
			requestMap.put("msg", "User not found!");
		else
			requestMap.put("userlist", list);
		return "USROO1.xhtml";
	}
	public String save() {
		UserBean bean = new UserBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPassword(password);
		bean.setConfirm(confirm);
		if (!bean.getId().equals("") && !bean.getName().equals("") && !bean.getPassword().equals("")
				|| !bean.getConfirm().equals("")) {
			if (bean.getPassword().equals(bean.getConfirm())) {
				requestMap.put("bean", bean);
				UserRequestDTO dto = new UserRequestDTO();
				dto.setId(bean.getId());
				dto.setName(bean.getName());
				dto.setPassword(bean.getPassword());
				UserDAO dao = new UserDAO();
				List<UserResponseDTO> list = dao.select(dto);
				if (list.size() != 0) {
					requestMap.put("err", "UserId has been already exist!");
					return "USR002.xhtml";
				}
				else {
					int res = dao.insert(dto);
					if (res > 0)
						showMessage("Insert Successful");
					else
						requestMap.put("err", "Insert fail");
					return "USR002.xhtml";
				}
			} else {
				requestMap.put("err", "Password are not match");
				requestMap.put("bean", bean);
				return "USR002.xhtml";
			}
		} else {
			requestMap.put("err", "Fields must not be null");
			requestMap.put("bean", bean);
			return "USR002.xhtml";
		}
	}

	
	public static void showMessage(String msg){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage("Notice",msg);
		context.addMessage(null, message);
	}
	
	
}


















