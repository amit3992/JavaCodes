package bloomberg.stockMarket;

public class TestStockMarket {

	public static void main(String[] args) {
		
		StockMarket stm = new StockMarket();
		stm.addStock("Google", 100);
		stm.addStock("Microsoft", 70);
		stm.addStock("Apple", 150);
		stm.addStock("Google", 100);
		stm.addStock("Microsoft", 70);
		
		stm.printStockData();
		stm.printTop(2);
		
		stm.addStock("Google", 100);
		stm.addStock("Facebook", 75);
		stm.addStock("Apple", 50);
		stm.addStock("Google", 150);
		stm.addStock("Bank of America", 27);
		
		stm.printStockData();
		stm.printTop(5);

	}

}
