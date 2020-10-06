package abstractclass;

public class Human extends LivingThing {
	
	
	public Human(String name) {
		super(name);
	}

	@Override
	public void walk() {
		System.out.println("Human " + getName() + "walks...");
	}

	@Override
	public void dance() {

		System.out.println("Human " + getName() + " dancing Tango");
	}
	
	

}
