package dynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs {

	public int getWays(int N) {
		
		if(N <= 3) {
			return N;
		}
			
		int[] count = new int[N+1];
			
		count[0] = 0;
		count[1] = 1;
		count[2] = 2;
		count[3] = 3;
			
		for(int i = 4; i <= N; i++) {
			count[i] = count[i-1] + count[i-2];
		}
			
			return count[N];
		}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		ClimbingStairs ds = new ClimbingStairs();
		
		while(s-- > 0) {
			int n = sc.nextInt();
			System.out.println(ds.getWays(n));
		}

	}


}
