package abstractclass;

public class Monkey extends LivingThing {
	
	public Monkey(String name) {
		super(name);
	}
	
	
	@Override
	public void walk() {
		System.out.println("Monkey " + getName() + " also walks..");
	}


	@Override
	public void dance() {

		System.out.println("Monkey " + getName() + " dancing Cha Cha Cha...");
	}
	
	
	

}
