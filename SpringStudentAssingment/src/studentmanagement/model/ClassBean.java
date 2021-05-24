package studentmanagement.model;

import javax.validation.constraints.NotEmpty;

public class ClassBean {

	@NotEmpty
	private String classId;
	@NotEmpty
	private String className;
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
