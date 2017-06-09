package hackerrank.algo.implementation;
import java.util.*;

/* Link: https://www.hackerrank.com/challenges/divisible-sum-pairs*/

/*
 * ip: 6 3
	1 3 2 6 1 2
	
	op: 5
 * */

/* O(n^2) logic */
public class DivisibleSumPairs {
	
	static boolean checkDiv(int a, int b) {
		
		if(a % b == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	static int divisibleSumPairs(int n, int k, int[] ar) {
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			
			for(int j = i + 1; j <= n - 1; j++) {
				
				int val = ar[i] + ar[j];
				
				if(checkDiv(val, k)) {
					System.out.println("Pair -> (" + ar[i] + "," + ar[j] + ")");
					count++;
				}
			}
		}
		
		return count;
       
    }

	    public static void main(String[] args) {
	    	
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] ar = new int[n];
	        for(int ar_i = 0; ar_i < n; ar_i++){
	            ar[ar_i] = in.nextInt();
	        }
	        int result = divisibleSumPairs(n, k, ar);
	        System.out.println(result);
	    
	    }


}
