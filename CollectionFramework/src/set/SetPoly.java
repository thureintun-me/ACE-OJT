package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPoly {
	
	public static void main(String[] args) {
		
		String[] numbers = {
				new String("4"),
				new String("3"),
				new String("5"),
				new String("1"),
				new String("2")
		};
		
		for(int i=0;i<numbers.length;i++) {
			System.out.println(numbers[i]);
		}
		
		Set s = new HashSet();
		MyOwnUtiltiyClass.checkDuplicate(s, numbers);
		System.out.println("Set Type : " + s.getClass().getName() + " " + s);
		
		s = new TreeSet<>();
		MyOwnUtiltiyClass.checkDuplicate(s, numbers);
		System.out.println("Set Type : " + s.getClass().getName() + " " + s);
		
		s = new LinkedHashSet<>();
		MyOwnUtiltiyClass.checkDuplicate(s, numbers);
		System.out.println("Set Type : " + s.getClass().getName() + " " + s);
	}

}
