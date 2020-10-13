package demo;

import java.util.ArrayList;
import java.util.Collection;

public class BoundedWildCard {
	
	static void printCollection(Collection<? extends Number> n) {
		for(Object o : n) {
			System.out.println(o);
		}
	}
	
	public static void main(String[] args) {
		 
		ArrayList<Integer> ai = new ArrayList<Integer>(10);
		ai.add(10);
		printCollection(ai);
		ArrayList<Double> as = new ArrayList<Double>(10);
		printCollection(as);
		ArrayList<Long> al = new ArrayList<Long>();
		printCollection(al);
	}

}
