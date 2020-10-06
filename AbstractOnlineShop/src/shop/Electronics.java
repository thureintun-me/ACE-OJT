package shop;

public abstract class Electronics extends Product {
	
	private String manufacturer;
	
	public Electronics(String manufacturer,double regularPrice) {
		super(regularPrice);
		this.manufacturer= manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
