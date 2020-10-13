package demo;

public class MainPair {
	
	public static void main(String[] args) {
		
		Number n1 = new Integer(1);
		String s1 = new String("Sun");
		
		Pair<Number, String> p1 = new Pair<Number, String>(n1, s1);
		System.out.println("first of p1 right after creation : " + p1.getFirst());
		System.out.println("second of p1 right after creation : " + p1.getSecond());
		
		p1.setFirst(new Long(6));
		p1.setSecond(new String("rises"));
		System.out.println("first of p1 after setting value : " + p1.getFirst());
		System.out.println("second of p1 after setting value: " + p1.getSecond());
		
	}

}
