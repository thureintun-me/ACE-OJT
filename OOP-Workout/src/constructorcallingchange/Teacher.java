package constructorcallingchange;

public class Teacher extends Person {
	
	private String subject;

	public Teacher() {
		super();
		System.out.println("Teacher constructor is called....");
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	

}
