package shop;

public abstract class Product {
	
	private double regularPrice;
	
	public Product(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	
	public abstract double computeSalePrice();

	public double getRegularPrice() {
		return regularPrice;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}
	
	
	

}
