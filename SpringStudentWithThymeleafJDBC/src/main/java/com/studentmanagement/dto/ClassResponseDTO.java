package com.studentmanagement.dto;

public class ClassResponseDTO {

	private String classId;
	private String className;
	
	
	public ClassResponseDTO(String classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
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
