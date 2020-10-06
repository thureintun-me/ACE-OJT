package constructorcallingchange;

public class InternationalStudent extends Student {
	
	private String country;

	public InternationalStudent() {
		super();
		System.out.println("International Student Constructor is called..........");
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
