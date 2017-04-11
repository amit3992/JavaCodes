package leetCode;
import java.util.*;

/*
 * Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 */

public class BuySellStock {
	
	public static int stockCost(int[] prices) {
		int n = prices.length;
		int minPrice = Integer.MAX_VALUE;
		int maxPrice = 0;
		
			int maxCur = 0, maxSoFar = 0;
	        for(int i = 1; i < prices.length; i++) {
	        	
	        	// Kadane's algorithm
	            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
	            maxSoFar = Math.max(maxCur, maxSoFar);
	            
	            minPrice = Math.min(minPrice, prices[i]);
	            maxPrice = Math.max(maxPrice, prices[i] - minPrice);
	        }
	        
	        System.out.println("Min Price: " + minPrice);
	        System.out.println("Max Price: " + maxPrice);
	        return maxSoFar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stock = {7, 1, 5, 3, 6, 4};
		
		System.out.println(stockCost(stock));

	}

}
