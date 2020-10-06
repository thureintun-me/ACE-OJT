package shop;

public class Main {
	
	public static void main(String[] args) {
		
		Product[] pa = new Product[5];
		pa[0] = new TV(30, "Samsung", 2000);
		pa[1] = new TV(42, "Sony", 4500);
		pa[2] = new MP3Player("Red", "Apple", 250);
		pa[3] = new Book(37, "Sun Press", 1998);
		pa[4] = new Book(25,"Apress",2015);
		
		
		double totalRegularPrice =0 ;
		double totalsalePrice = 0;
		
		for(int i=0;i<pa.length;i++) {
			
			totalRegularPrice +=pa[i].getRegularPrice();
			totalsalePrice += pa[i].computeSalePrice();
			
			System.out.println("Item Number : " + i + "Type : " + pa[i].getClass().getName() +
					"Regulat Price : " + pa[i].getRegularPrice() +
					" Sale Price : " + pa[i].computeSalePrice());
		} 
				
			System.out.println("TotalRegularPrice : " + totalRegularPrice);	
			System.out.println("TotalSalePrice : " + totalsalePrice);
	}

}
