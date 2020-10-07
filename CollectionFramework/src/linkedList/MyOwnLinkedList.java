package linkedList;


import java.util.LinkedList;

import list.MyOwnArrayList;
import list.MyOwnClass;

public class MyOwnLinkedList {
	
	public static void main(String[] args) {
		
		
		LinkedList list = new LinkedList<>();
		
		list.add(new String("Hello "));
		list.add(new String("Java"));
		list.add(new MyOwnClass());
		list.add(new Integer(5));
		list.add(new Integer(4));
		list.add(new Integer(3));
		
		
		list.add(2,new MyOwnClass());
		System.out.println(list);
	}

}
