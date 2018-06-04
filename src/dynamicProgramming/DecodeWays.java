package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
	
	public int numDecodings(String s) {
        
		if (s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for(int i = 2; i <= n; i++) {
        	
        	System.out.println("First: " + s.substring(i-1, i));
        	System.out.println("Second: " + s.substring(i-2, i));
            
        	int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));

            if(first >= 1 && first <= 9) {
               dp[i] += dp[i-1];  
            }

            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        
        return dp[n];

    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DecodeWays dw = new DecodeWays();
		System.out.println("Number of ways: " + dw.numDecodings("123"));

	}

}
