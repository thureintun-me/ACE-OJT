package abstractclass;

public abstract class LivingThing {
	
	private String name;

	public LivingThing(String name) {
		super();
		this.name = name;
	}
	
	public void breath() {
		System.out.println("Living Thing breathing....");
	}
	
	public void eat() {
		System.out.println("Living thing eating...");
	}
	
	public abstract void walk();
	
	public abstract void dance();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
