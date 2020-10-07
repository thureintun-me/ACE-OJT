package ex1;

public class Product {
	
	private String pdCode;
	private String pdName;
	private double pdPrice;
	
	
	public Product(String pdCode, String pdName, double pdPrice) {
		super();
		this.pdCode = pdCode;
		this.pdName = pdName;
		this.pdPrice = pdPrice;
	}
	
	
	public String getPdCode() {
		return pdCode;
	}
	public void setPdCode(String pdCode) {
		this.pdCode = pdCode;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public double getPdPrice() {
		return pdPrice;
	}
	public void setPdPrice(double pdPrice) {
		this.pdPrice = pdPrice;
	}


	@Override
	public String toString() {
		return "Product [pdCode=" + pdCode + ", pdName=" + pdName + ", pdPrice=" + pdPrice + "]";
	}
	
	
	

}
