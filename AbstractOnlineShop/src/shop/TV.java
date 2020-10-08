package shop;

public class TV extends Electronics {
	


	private int size;
	
	public TV(int size,String manufacturer,double regularPrice) {
		super(manufacturer,regularPrice);
		this.size=size;
		
	}
	
	
	public double computeSalePrice() {
		return super.getRegularPrice()*0.8;
		
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
	

}
