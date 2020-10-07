package treeset;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
	
	public static void main(String[] args) {
		
		Set ts = new TreeSet<>();
		ts.add("One");
		ts.add("Two");
		ts.add("Three");
		ts.add("four");
		ts.add("Three");
		
		System.out.println("alphanetical Oreder : " + ts);
		
		Set ts2 = new TreeSet<>();
		ts2.add(1);
		ts2.add(2);
		ts2.add(3);
		ts2.add(4);
		ts2.add(3);
		System.out.println("numeirc Order : " + ts2);
	}

}
