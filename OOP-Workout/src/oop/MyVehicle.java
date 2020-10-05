package oop;

public class MyVehicle {

	public static void main(String[] args) {

		Vehicle obj = new Cars();
		
		obj.getType();
		obj.getColor();
		obj.getBrandName();
		
		
		obj = new Bikes();
		obj.getType();
		obj.getColor();
		obj.getBrandName();
		
		obj = new MotorBikes();
		obj.getType();
		obj.getColor();
		obj.getBrandName();
	}

}
