package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	
	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		queue.add("element 1");
		queue.add("element 2");
		
		/*
		 * System.out.println(queue.remove()); System.out.println(queue.poll());
		 */
		
		System.out.println(queue.peek());
		System.out.println(queue.element());
		
		System.out.println(queue.contains("element 1"));
		System.out.println(queue.contains("ele"));
	}

}
