package dynamicProgramming;
import java.util.*;

public class BuySellStock {
	
	private int maxProfitSlow(int [] prices, int k) {
		
		if(k == 0 || prices == null || prices.length == 0) {
			return 0;
		}
		
		int days = prices.length;
		int[][] T = new int[k+1][days];
		
		for(int i = 1; i < T.length; i++) {
			for(int j = 1; j < T[0].length; j++) {
				
				int maxVal = 0;
				for(int m = 0; m < j; m++) {
					maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
				}
				
				T[i][j] = Math.max(T[i][j-1], maxVal);
			}
		}
		
		return T[k][days - 1];
		
	}

	private int maxProfitFast(int [] prices, int k) {
		if(k == 0 || prices == null || prices.length == 0) {
			return 0;
		}
		
		int days = prices.length;
		int[][] T = new int[k+1][days];
		
		for(int i = 1; i < T.length; i++) {
			int maxDiff = -prices[0];
			for(int j = 1; j < T[0].length; j++) {
				T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
				maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
			}
		}
		
		return T[k][days - 1];
		
		
	}
	
	private void printActualSolution(int[][] T, int[] prices) {
		int i = T.length - 1;
		int j = T[0].length - 1;
		
		Deque<Integer> stack = new LinkedList<>();
        while(true) {
            if(i == 0 || j == 0) {
                break;
            }
            
            if (T[i][j] == T[i][j-1]) {
                j = j - 1;
            } else {
                stack.addFirst(j);
                
                int maxDiff = T[i][j] - prices[j];
                for (int k = j-1; k >= 0; k--) {
                    if (T[i-1][k] - prices[k] == maxDiff) {
                        i = i - 1;
                        j = k;
                        stack.addFirst(j);
                        break;
                    }
                }
                
            }
        }

        while(!stack.isEmpty()) {
            System.out.println("Buy at price " + prices[stack.pollFirst()]);
            System.out.println("Sell at price " + prices[stack.pollFirst()]);
        }
        
	}
	public static void main(String[] args) {
		
		BuySellStock bss = new BuySellStock();
		int [] prices = {2, 5, 7, 1, 4, 3, 1, 3};
		
		System.out.println("Max profit slow solution for 3 transactions -> " + bss.maxProfitSlow(prices, 3));
		System.out.println("Max profit fast solution for 3 transactions -> " + bss.maxProfitSlow(prices, 3));
	}

}
