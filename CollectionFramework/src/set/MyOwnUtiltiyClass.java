package set;

import java.util.Set;

public class MyOwnUtiltiyClass {

	public static void checkDuplicate(Set s,String[] numbers) {
		for(int i=0;i<numbers.length;i++) {
			s.add(numbers[i]);
		}
	}
}
