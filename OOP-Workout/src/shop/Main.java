package shop;

public class Main {
	
	public static void main(String[] args) {
		
		Sedan sedan = new Sedan(60, 2500, "Silver", 25);
		
		Ford ford1 = new Ford(90, 5000, "Red", 2019, 500);
		Ford ford2 = new Ford(120,6500, "Blue",2020,550);
		
		Car car = new Car(50, 4000, "black");
		
		
		System.out.println("Sedan : " + sedan.getSalePrice());
		System.out.println("Ford1 :  " + ford1.getSalePrice());
		System.out.println("ford2 : " + ford2.getSalePrice());
	}

}
