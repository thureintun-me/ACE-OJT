package set;

import java.util.HashSet;

public class MyHashSet {
	
	public static void main(String[] args) {
		
		 HashSet hs = new HashSet(5,0.5f);
		 
		 System.out.println(hs.add(new String()));
		 System.out.println(hs.add(new String()));
		 System.out.println(hs.add(new MyOwnClass()));
		 System.out.println(hs.add(new MyOwnClass()));
		 System.out.println(hs.add(new Integer(4)));
		 System.out.println(hs.add(new Integer(2)));
		 System.out.println(hs.add(new Integer(5)));
		 
		 
		 System.out.println(hs);
		 
		 
	}

}
