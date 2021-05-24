package com.studentmanagement.dto;



/**
 * Entity implementation class for Entity: ClassDTO
 *
 */

public class ClassRequestDTO {

	
	
	private String classId;
	private String className;
	
	public ClassRequestDTO() {
		super();
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
