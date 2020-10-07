package ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;





public class Main {
	
	public static void main(String[] args) {
		
		Product p1 = new Product("001", "Phone", 2500);
		Product p2 = new Product("002", "Book", 2000);
		Product p3 = new Product("003", "Car", 3000);
		Product p4 = new Product("004", "Laptop", 1500);
		Product p5 = new Product("005", "Monitor", 2100);
		
		
		Map<String, Product> pMap = new HashMap<String, Product>();
		
		pMap.put(p1.getPdCode(), p1);
		pMap.put(p2.getPdCode(), p2);
		pMap.put(p3.getPdCode(), p3);
		pMap.put(p4.getPdCode(), p4);
		pMap.put(p5.getPdCode(), p5);
		
		
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter pdCode.........");
		String inPdCode=in.nextLine();
		
		
		for(Map.Entry<String, Product> p : pMap.entrySet()) {
			if(p.getValue().getPdCode().equals(inPdCode)) {
				System.out.println(p);
			}
			
		}
		
	}

}
