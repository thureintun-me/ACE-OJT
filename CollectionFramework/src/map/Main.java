package map;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	private static final Integer ONE = new Integer(1);
	
	public static void main(String[] args) {
		
		String[] names = new String[] {
				new String("Sang"),
				new String("Shin"),
				new String("Boston"),
				new String("Passion"),
				new String("Shin")
				
		};
		
		Map m = new HashMap();
		
		for(int i=0;i<names.length;i++) {
			
			Integer freq = (Integer)m.get(names[i]);
			System.out.println(freq);
			
			m.put(names[i],(freq==null ? ONE : new Integer(freq.intValue()+1)));
		}
		System.out.println(m.size()+ " distinct words detected");
		System.out.println(m);
		
	}

}
