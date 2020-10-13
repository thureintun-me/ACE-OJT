package demo;

import java.util.ArrayList;
import java.util.Collection;

public class WildCard {

	static void printCollection(Collection<?> c) {
		for(Object o :c)
			System.out.println(o);
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ai = new ArrayList<Integer>(10);
		ai.add(10);
		printCollection(ai);
		ArrayList<String> as = new ArrayList<String>(10);
		printCollection(as);
		ArrayList<Long> al = new ArrayList<Long>();
		printCollection(al);
	}
}
