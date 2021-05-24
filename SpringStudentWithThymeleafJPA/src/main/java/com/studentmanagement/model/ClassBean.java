package com.studentmanagement.model;

import javax.validation.constraints.NotEmpty;

public class ClassBean {

	@NotEmpty(message = "Class Id cannot be empty!!!")
	private String classId;
	@NotEmpty(message = "Class Name cannot be empty!!!")
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
