package demo;

import java.util.ArrayList;
import java.util.LinkedList;


public class Main {
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setId("1");
		s1.setName("Thu Thu");
		s1.setAge(17);
		
		Student s2 = new Student();
		s2.setId("2");
		s2.setName("Thu Thu Thaw");
		s2.setAge(21);
		
		
		Student s3 = new Student();
		s3.setId("3");
		s3.setName("Thura");
		s3.setAge(19);
		
		Student s4 = new Student();
		s4.setId("4");
		s4.setName("Zaw Zaw");
		s4.setAge(17);
		
		Student s5 = new Student();
		s5.setId("5");
		s5.setName("Thurein");
		s5.setAge(22);
		
		
		
		
		ArrayList<Student> sArrayList = new ArrayList<Student>();
		sArrayList.add(s1);
		sArrayList.add(s2);
		sArrayList.add(s3);
		sArrayList.add(s4);
		sArrayList.add(s5);
		
		
		System.out.println("Student whose age is under 20............");
		
		for( Student s : sArrayList) {
			if(s.getAge()<20) {
				System.out.println("Using Array List : "+ s);
			}
		}
		
	
		
		
		
		LinkedList<Student> sLinkedList = new LinkedList<Student>();
		sLinkedList.add(s1);
		sLinkedList.add(s2);
		sLinkedList.add(s3);
		sLinkedList.add(s4);
		sLinkedList.add(s5);
		
		System.out.println("Student whose age is over 20............");
		for( Student s : sLinkedList) {
			if(s.getAge()>20) {
				System.out.println("Using linked List : " + s);
			}
		}
		
	}

}
