package com.studentmanagement.dto;

public class StudentResponseDTO {

	private String studentId;
	private String studentName;
	private String className;
	private String registerDate;
	private String status;
	
	
	public StudentResponseDTO(String studentId, String studentName, String className, String registerDate,
			String status) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.className = className;
		this.registerDate = registerDate;
		this.status = status;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
