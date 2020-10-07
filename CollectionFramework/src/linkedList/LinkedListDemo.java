package linkedList;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList<>();
		list.add(new Integer(1));
		list.add(new Integer(2));
		list.add(new Integer(3));
		list.add(new Integer(1));
		
		System.out.println(list + " , size : " + list.size());
		
		list.addFirst(new Integer(0));
		list.addLast(new Integer(4));
		System.out.println(list);
		System.out.println(list.getFirst() + " " + list.getLast());
		System.out.println(list.get(2) + " " + list.get(3));
		
		System.out.println(list.removeFirst());
		System.out.println(list.removeLast());
		System.out.println(list);
		
		list.remove(new Integer(1));
		System.out.println(list);
		
		String s  = new String("Boston");
		list.add(s);
		list.add(2,new Long(45l));
		System.out.println(list);
		
		System.out.println("Index of Boston : " + list.indexOf("Boston"));
		
		list.remove(2);
		System.out.println(list);
		
		LinkedList cloneLinkedList = (LinkedList)list.clone();
		cloneLinkedList.add(0,new String("CLonee LinkedList"));
		list.add(0,new String("Original LinkedList"));
		System.out.println(list);
		System.out.println(cloneLinkedList);
		
	}
}
