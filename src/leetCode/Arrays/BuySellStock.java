package leetCode.Arrays;

/* Kadane's algorithm */

class Stock {
	
	private int buyPrice;
	private int sellPrice;
	
	public int getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(int buyPrice) {
		this.buyPrice = buyPrice;
	}
	public int getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	
	
}

public class BuySellStock {
	
	public static int buySellStock(int [] stocks, Stock st) {
		
		if(stocks.length == 0) {
			return 0;
		}
		
		int current_buy_price = stocks[0];
		int global_sell = stocks[1];
		int global_max_profit = Integer.MIN_VALUE;
		int current_profit = global_sell - current_buy_price;
		
		for(int i = 1; i < stocks.length; i++) {
			
			current_profit = stocks[i] - current_buy_price;
			
			if(current_profit > global_max_profit) {
				global_max_profit = current_profit;
				global_sell = stocks[i];
			}
			
			if(current_buy_price > stocks[i]) {
				current_buy_price = stocks[i];
			}
		}
		
		st.setBuyPrice(global_sell - global_max_profit);
		st.setSellPrice(global_sell);
		return global_max_profit;
		
	}

	public static void main(String[] args) {
		
		int[] stocks = {8, 5, 12, 9, 19, 1};
		//int[] stocks = {21, 12, 11, 9, 6, 3};
		
		Stock st = new Stock();
		
		System.out.println("Max profit -> " + buySellStock(stocks, st));
		System.out.println("Buy price -> " + st.getBuyPrice());
		System.out.println("Sell price -> " + st.getSellPrice());
	}

}
