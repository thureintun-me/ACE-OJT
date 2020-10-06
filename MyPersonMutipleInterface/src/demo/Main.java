package demo;

public class Main {

	public static void main(String[] args) {
		
		Person person = new Person("ThuThuThaw", 25,new AddressImpl());
		person.getAddress().setCountry("Myanmar");
		person.getAddress().setStreetName("Avenue Street");
		person.getAddress().setStreetNumber(74);
		
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getAddress().getCountry());
		System.out.println(person.getAddress().getStreetName());
		System.out.println(person.getAddress().getStreetNumber());
	}
}
