package bloomberg.stockMarket;
import java.util.*;

public class StockMarket {
	
	private ArrayList<String> stockList;
	private HashMap<String, Stock> stockMap;
	
	StockMarket() {
		stockList = new ArrayList<String>();
		stockMap = new HashMap<String, Stock>();
	}
	
	
	/* Methods */
	public boolean isStockDataAvailable(String stockName) {
		return stockMap.containsKey(stockName);
	}
	
	public Stock getMaxStock() {
		return extractMax();
	}
	
	public void printTop(int n) {
		
		if(n > stockMap.size()) {
			System.out.println("Invalid input!");
			return;
		}
		
		System.out.println("Top " + n + " stock information: \n");
		
		while(n-- > 0) {
			Stock st = getMaxStock();
			System.out.println(st.name + " -> " + st.value);
		}
		
		System.out.println("====================================");
		
	}
	
	public void addStock(String name, int value) {
		
		Stock stock = null;
		
		if(!stockMap.containsKey(name)) {
			stock = new Stock(name, value);
			stockMap.put(name, stock);
		}
		else {
			stock = stockMap.get(name);
			stock.value += value;
			
			stockMap.put(name, stock);
		}
		
		if(!stockList.contains(name)) {
			stockList.add(name);
		}
		
		int size = stockList.size();
		int current = stockList.indexOf(name);
		int parentIndex = (current - 1)/2;
		
		while(parentIndex >= 0) {
			
			String parentStr = stockList.get(parentIndex);
			String currentStr = stockList.get(current);
			
			Stock parentStock = stockMap.get(parentStr);
			Stock currentStock = stockMap.get(currentStr);
			
			if(parentStock.value < currentStock.value) {
				swap(parentIndex, current);
				
				current = parentIndex;
				parentIndex = (current -1)/2;
			}
			else {
				break;
			}
		}
	}
	
	private void swap(int a, int b) {
		Collections.swap(stockList, a, b);
	}
	
	private Stock extractMax() {
		
		int size = stockList.size() - 1;
		String maxStock = stockList.get(0);
		
		Collections.swap(stockList, 0, size);
		stockList.remove(size); // Remove from list but not from map
		
		int current = 0;
		size--;
		
		while(true) {
			
			int left = 2*current + 1;
			int right = 2*current + 2;
			
			if(left > size) {
				break;
			}
			
			if(right > size) {
				right = left;
			}
			
			Stock leftStock = stockMap.get(stockList.get(left));
			Stock rightStock = stockMap.get(stockList.get(right));
			
			int largeIndex = leftStock.value >= rightStock.value ? left : right;
			
			Stock currentStock = stockMap.get(stockList.get(current));
			Stock largeStock = stockMap.get(stockList.get(largeIndex));
			
			if(currentStock.value < largeStock.value) {
				swap(current, largeIndex);
				current = largeIndex;
			}
			else {
				break;
			}
		}
		
		return stockMap.get(maxStock);
	}
	
	public void printStockData() {
		
		System.out.println("Current Stock data: \n");
		
		for(String st: stockList) {
			Stock stock = stockMap.get(st);
			
			System.out.println(stock.name + " --> " + stock.value);
		}
		
		System.out.println("====================================");
	}
}
