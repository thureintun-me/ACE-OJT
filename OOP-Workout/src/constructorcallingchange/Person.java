package constructorcallingchange;

public class Person {

	private String name;
	private String address;
	
	
	public Person() {
		super();
		System.out.println("Person Constructor is called.....");
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
