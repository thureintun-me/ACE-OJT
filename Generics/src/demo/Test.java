package demo;

public class Test {
	
	public static void main(String[] args) {
		
		SomethingGeneric<String> str = new SomethingGeneric<String>();
		//str.setThing(3);
		str.setThing("DD");
		
		SomethingGeneric<Integer> in = new SomethingGeneric<Integer>();
		in.setThing(3);
	}

}
