package demo;

public class Main {
	
	public static void main(String[] args) {
		
		Line line1 = new Line(1.0, 2.0, 1.0, 2.0);
		Line line2 = new Line(2.0, 3.0, 2.0, 3.0);
		
		boolean b1 = line1.isGreater(line1, line2);
		System.out.println("Line1 is grater than line2 : " + b1);
		
		boolean b2 = line1.isEqual(line1, line2);
		System.out.println("line1 is equal to line 2 : " + b2);
		
		RelationInterface line3 = new Line(1.0, 5.0, 1.0, 5.0);
		boolean b3 = line3.isEqual(line1, line3);
		System.out.println("line1 is eqaul line3 " + b3);
		
		System.out.println("Length of line 1 : " + line1.getLength());
		System.out.println("Length of line 2 : " + line2.getLength());
		
		
	//	System.out.println("Line3 length : " + line3.getLength());
	}

}
