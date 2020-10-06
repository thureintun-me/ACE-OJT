package constructorcallingchange;

public class Student extends Person {
	
	
	
	private String school;
	private double grade;
	
	
	public Student() {
		super();
		System.out.println("Student Constructor is called.........");
	}


	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public double getGrade() {
		return grade;
	}


	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
	
	
	
	

}
