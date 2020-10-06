package demo;

public class Person implements MyOwnInterface {
	
	private String name;
	private Integer age;
	private AddressImpl addressImpl;
	

	public Person(String name, Integer age,AddressImpl addressImpl) {
		super();
		this.name = name;
		this.age = age;
		this.addressImpl=addressImpl;
	}



	@Override
	public AddressInterface getAddress() {
		// TODO Auto-generated method stub
		return addressImpl;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
