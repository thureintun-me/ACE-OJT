package abstractclass;

public class Main {

	public static void main(String[] args) {
		
		LivingThing ross = new Human("Ross");
		LivingThing mercel = new Monkey("Mercel");
		
		ross.walk();
		mercel.walk();
		ross.dance();
		mercel.dance();
		
	}
}
