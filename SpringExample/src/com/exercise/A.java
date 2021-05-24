package com.exercise;

public class A {

	B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
	
	public void print() {
		System.out.println("Hello a");
		
	}
	
	public void display() {
		print();
		b.print();
	}
}
