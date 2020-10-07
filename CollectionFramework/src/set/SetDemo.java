package set;

import java.util.HashSet;

public class SetDemo {
	
	public static void main(String[] args) {
		
		HashSet hs = new HashSet(5, 0.5f);
		System.out.println(hs.add("One"));
		System.out.println(hs.add("Two"));
		System.out.println(hs.add("Three"));
		System.out.println(hs.add("four"));
		System.out.println(hs.add("five"));
		
		//print random order......
		System.out.println(hs);
		
		Boolean b = hs.add("One");
		System.out.println("Duplicate Item allowed : " + b);
		
		System.out.println(hs);
		
	}

}
