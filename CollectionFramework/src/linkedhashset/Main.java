package linkedhashset;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) {
		
		Set ts = new LinkedHashSet<>();
		ts.add("One");
		ts.add("Two");
		ts.add("Three");
		ts.add("Four");
		ts.add("Two");
		
		
		System.out.println("Members of linked hash set  insertion order : " + ts);
		
		Set ts2 = new TreeSet<>();
		ts2.add(1);
		ts2.add(2);
		ts2.add(3);
		ts2.add(4);
		ts2.add(2);
		
		System.out.println("Member of linkHashSet in insertion order : " + ts2);
	}

}
