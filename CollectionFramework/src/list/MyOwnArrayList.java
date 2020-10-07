package list;

import java.util.ArrayList;
import java.util.ListIterator;

public class MyOwnArrayList {
	
	public static void main(String[] args) {
		
		ArrayList al = new ArrayList(5);
		
		al.add(new String("Hello "));
		al.add(new String("Java"));
		al.add(new MyOwnClass());
		al.add(new Integer(5));
		al.add(new Integer(4));
		al.add(new Integer(3));
		
		ListIterator il = al.listIterator();
		while(il.hasNext()) {
			System.out.println(il.next());
		}
		
		Object[] oa = al.toArray();
		for(int i=0;i<oa.length;i++) {
			System.out.println(oa[i]);
		}
	}

}
