package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeAsStack {
	
	public static void main(String[] args) {
		
		Deque<String> dequeStack = new ArrayDeque<String>();
		dequeStack.push("One");
		dequeStack.push("Two");
		dequeStack.push("Three");
		
		System.out.println(dequeStack.pop());
		System.out.println(dequeStack.pop());
		System.out.println(dequeStack.pop());
		
		
		
	}

}
