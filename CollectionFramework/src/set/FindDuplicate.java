package set;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
	
	public static void main(String[] args) {
		
		String[] name = {
				new String("Sang"),
				new String("Shin"),
				new String("Boston"),
				new String("Shin")
				
		};
		
		Set unique = new HashSet<>();
		Set dups = new HashSet<>();
		
		for(int i=0;i<name.length;i++) {
			if(!unique.add(name[i])) {
				dups.add(name[i]);
				
			}
		}
		
		unique.removeAll(dups);
		
		
		System.out.println("Unique Words : " + unique);
		System.out.println("Duplicate Word : " + dups);
	}

}
