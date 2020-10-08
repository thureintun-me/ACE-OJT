package stack;

import java.util.Iterator;
import java.util.Stack;

public class MyStack {
	
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		
		//String topElement = stack.pop();
		//String topElement = stack.peek();
		//System.out.println(topElement);
		
		
		/*
		 * int index = stack.search("1"); System.out.println(index);
		 */

		/*
		 * System.out.println(stack.pop());; for(String s: stack) {
		 * System.out.println("FOreach : " + s); }
		 */
		
		
		Iterator<String> stackIterator = stack.iterator();
		while(stackIterator.hasNext()) {
			String value = stackIterator.next();
			System.out.println(value);
		}
		
		stack.stream().forEach(a->System.out.println(a));
		
		
		
		
	}

}
