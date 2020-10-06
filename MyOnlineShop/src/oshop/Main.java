package oshop;

public class Main {

	public static void main(String[] args) {

		Product[] pa = new Product[5];
		
		pa[0] = new TV(1000, "Samsung", 30);
		pa[1] = new TV(2000, "Sony", 50);
		pa[2] = new MP3Player(250, "Apple", "Blue");
		pa[3] = new Book(34, "Sun Press", 1998);
		pa[4] = new Book(50, "Korean Press", 1990);
		
		double totalReguarPrice = 0;
		double totalSalePrice = 0;
		
		for(int i=0;i<pa.length;i++) {
			totalReguarPrice += pa[i].getRegularPrice();
			totalSalePrice += pa[i].computeSalePrice();
			
			System.out.println("Item number " + i + " Type : " + pa[i].getClass().getName()+
					" Regular Price : " + pa[i].getRegularPrice() + 
					" Sale Price : " + pa[i].computeSalePrice());
			
		}
		
		System.out.println("Total Regular Price : " + totalReguarPrice);
		System.out.println("Total Sale Price : " + totalSalePrice);
	}

}
