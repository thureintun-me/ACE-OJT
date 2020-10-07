package list;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListDemo {
	
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList<>(2);
		System.out.println(al + " , size = " + al.size());
		
		al.add("R");
		al.add("U");
		al.add("O");
		al.add(new String("X"));
		al.add(2,new Integer(10));
		System.out.println(al + " , size = " + al.size());
		
		al.remove("U");
		System.out.println(al + " , size =  " + al.size());
		
		boolean b = al.contains("x");
		System.out.println("The list contains x : " + b);
		
		b = al.contains("p");
		System.out.println("This list contains p : " + b);
		
		b = al.contains(10);
		System.out.println("This list contains 10 : " + b);
		
		ListIterator il = al.listIterator();
		
		while(il.hasNext()) {
			System.out.println(il.next());
		}
		
		Object[] a = al.toArray();
		for(int i=0;i<a.length;i++) {
			System.out.println("From a arayy : " + a[i]);
			
		}
		
	}

}
