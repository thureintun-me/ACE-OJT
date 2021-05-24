package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	public String getName() {
	return name;
	}
	public void setName(String name) {
	this.name = name;
	}
	public String getSayWelcome() {
	if ("".equals(name) || name == null) {
	return "Ajax message : User name is must empty!";
	} else {
	return "Ajax message : Welcome " + name;
	}
	}
}
