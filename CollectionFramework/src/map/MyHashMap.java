package map;

import java.util.HashMap;
import java.util.Map;

import list.MyOwnClass;

public class MyHashMap {
	
	public static void main(String[] args) {
		
		Map hs = new HashMap();
		
		
		
		hs.put(1, "Hello");
		hs.put(2,"GoodBye");
		hs.put(3,new MyOwnClass());
		hs.put(4,new MyOwnClass());
		hs.put(5,56);
		
		System.out.println(hs);
	}

}
