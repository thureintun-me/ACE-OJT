package shop;

public class MyOwnAutoShop {
	
	public static void main(String[] args) {
		
		Sedan sedan = new Sedan(60, 1500, "Red", 30);
		Ford ford1 = new Ford(90, 3000, "Blue", 2015, 60);
		Ford ford2 = new Ford(120, 6000, "Blue", 2015, 600);
		
		
		Car car = new Car(60, 5000, "white");
		
		
		System.out.println("Sedan : " + sedan.getSalePrice());
		System.out.println("Ford1 :  " + ford1.getSalePrice());
		System.out.println("Ford2 : " + ford2.getSalePrice());
		System.out.println("Car : " + car.getSalePrice());
		
		
	}

}
