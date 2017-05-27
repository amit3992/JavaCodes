package dynamicProgramming;
import java.util.*;

public class NumberOfRuns {
	
	public static int numberOfWays(int runs) {
		
		if(runs < 0) {
			return -1;
		}
		
		int[] ways = new int[runs + 1];
		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;
		ways[3] = 3;
		ways[4] = 6;
		
		for(int i = 5; i <= runs; i++) {
			ways[i] = ways[i-1] + ways[i-2] + ways[i-4];
		}
		
		return ways[runs];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int runs = sc.nextInt();
		
		System.out.println("Number of ways to score " + runs + " -> " + numberOfWays(runs));

	}

}
