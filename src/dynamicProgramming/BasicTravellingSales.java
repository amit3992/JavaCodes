package dynamicProgramming;
import java.util.*;

public class BasicTravellingSales {

	public long getMaxProfit(int [] revA, int [] revB, int travelCost) {
		
		if(revA == null || revB == null || revB.length != revA.length) {
			return 0;
		}
		
		int nDays = revA.length;
		int [][] T = new int[2][nDays];
		long maxProfit = Long.MIN_VALUE;
		T[0][0] = revA[0];
		T[1][0] = revB[0];
		
		for(int day = 1; day < nDays; day++) {
			
			/* city A*/
			int A = T[0][day - 1] + revA[day];
			int B = T[1][day - 1] + revA[day] - travelCost;

			T[0][day] = Math.max(A, B);
			
			/* city B*/
			int C = T[1][day - 1] + revB[day];
			int D = T[0][day - 1] + revB[day] - travelCost;

			T[1][day] = Math.max(C, D);
			
			maxProfit = Math.max(T[0][day], T[1][day]);
		}
		
		return maxProfit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] revA = {1, 2, 3};
		int [] revB = {2, 0, 4};
		int travelCost = 3;
		
		BasicTravellingSales bts = new BasicTravellingSales();
		long maxProfit = bts.getMaxProfit(revA, revB, travelCost);
		
		System.out.println("Max profit -> " + maxProfit);
	}

}
