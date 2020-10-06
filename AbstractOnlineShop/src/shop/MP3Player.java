package shop;

public class MP3Player extends Electronics {
	
	private String color;
	
	public MP3Player(String color,String manufacturer,double regularPrice) {
		super(manufacturer,regularPrice);
		this.color=color;
	}

	@Override
	public double computeSalePrice() {
		return super.getRegularPrice()*0.9;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	

}
