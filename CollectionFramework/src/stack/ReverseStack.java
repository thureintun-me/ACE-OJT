package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		System.out.println(list);
		
		Stack<String> stack = new Stack<String>();
		while(list.size()>0) {
			stack.push(list.remove(0));
		}
		
		System.out.println(stack);
		
		while(stack.size()>0) {
			list.add(stack.pop());
		}
		
		System.out.println(list);
		
	}
}
