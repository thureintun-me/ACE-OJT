package demo;

public class Main {

	public static void main(String[] args) {
		
		Person person1 = new Person("THu", "THu", 4500, 2000);
		PersonInterface personInterface1 = person1;
		
		System.out.println("Person1.getName() : " + person1.getName() +
				"person1.computeTotalWealth() " + person1.computeTotalWealth());
		
		System.out.println("personalInterface.getName() : " + personInterface1.getName()+
				"personInterface.computeTotalWealth() : " +personInterface1.computeTotalWealth());
		
		boolean b1 = (person1==personInterface1);
		System.out.println("Do person1 and personInterface point to the same object : " + b1); 
		
		PersonInterface personInterface2 = new Person("Kyaw", "Kyaw", 2500, 400);
		
		System.out.println("personalInterface.getName() : " + personInterface2.getName()+
				"personInterface.computeTotalWealth() : " +personInterface2.computeTotalWealth());
		
		 
		
	}
}
