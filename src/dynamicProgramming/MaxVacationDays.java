package dynamicProgramming;
import java.util.*;

public class MaxVacationDays {
	
	public int maxVacationDays(int[][] flights, int[][] days) {
        int cities = flights.length;
        int weeks = days[0].length;
        int[] dp = new int[cities];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        for (int week = 0; week < weeks; week++) {
            
        	int[] temp = new int[cities];
            Arrays.fill(temp, Integer.MIN_VALUE);
            
            for (int sCity = 0; sCity < cities; sCity++) {
                
            	for(int dCity = 0; dCity < cities; dCity++) {
                    
            		if (sCity == dCity || flights[sCity][dCity] == 1) {
                        temp[sCity] = Math.max(temp[sCity], dp[dCity] + days[sCity][week]);
                    }
                }
            }
            dp = temp;
        }
        
        int max = 0;
        for (int v : dp) {
            max = Math.max(max, v);
        }
        
        return max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] flights = {{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
		int [][] days = {{1, 3, 1}, {6, 0, 3}, {3, 3, 3}};
		
		MaxVacationDays mvd = new MaxVacationDays();
		System.out.println("Max. vacation days -> " + mvd.maxVacationDays(flights, days));

	}

}
