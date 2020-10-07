package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MySetPoly {
	
	public static void main(String[] args) {
		
		String[] names = {
				new String("APM"),
				new String("Chipha"),
				new String("Thuta"),
				new String("Banana"),
				new String("APM")
		};
		
		Set s = new HashSet<>();
		MyOwnUtiltiyClass.checkDuplicate(s, names);
		System.out.println("Set Type : " + s.getClass().getName() + " " + s);
		
		s = new TreeSet<>();
		MyOwnUtiltiyClass.checkDuplicate(s, names);
		System.out.println("Set Type : " + s.getClass().getName() + " " + s);
		
		s = new LinkedHashSet<>();
		MyOwnUtiltiyClass.checkDuplicate(s, names);
		System.out.println("Set Type : " + s.getClass().getName() + " " + s);
		
	}

}
