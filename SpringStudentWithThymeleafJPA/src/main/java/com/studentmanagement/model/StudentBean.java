package com.studentmanagement.model;

import javax.validation.constraints.NotEmpty;

public class StudentBean {

	@NotEmpty(message = "Student Id cannot be empty!!!")
	private String studentId;
	@NotEmpty(message = "Student Name cannot be empty!!!")
	private String studentName;
	@NotEmpty(message = "Day cannot be empty!!!")
	private String day;
	@NotEmpty(message="month cannot be empty!!!")
	private String month;
	@NotEmpty(message = "year cannot be empty!!!")
	private String year;
	@NotEmpty(message = "status cannnot be empty!!!")
	private String status;
	@NotEmpty(message = "class name cannot be empty!!!")
	private String className;
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
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
