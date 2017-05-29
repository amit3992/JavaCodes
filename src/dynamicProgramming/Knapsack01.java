package dynamicProgramming;
import java.util.*;

public class Knapsack01 {
	
	public static int getMaxWt(int[] wt, int[] val, int target) {
		
		int n = wt.length;
		int[][] T = new int[n+1][target+1];
		
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= target; j++) {
				
				if(i == 0 || target == 0) {
					T[i][target] = 0;
				} else if(wt[i - 1] <= j) {
					T[i][j] = Math.max(val[i-1] + T[i-1][j - wt[i-1]], T[i-1][j]);
				} else {
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T[n][target];
	}

	public static void main(String[] args) {
		
		int target = 7;
		int[] wt = {1, 3, 4, 5};
		int[] val = {1, 4, 5, 7};
		
		System.out.println("Max wt -> " + getMaxWt(wt, val, target));

	}

}
