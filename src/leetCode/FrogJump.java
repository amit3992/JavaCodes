package leetCode;
import java.util.*;

public class FrogJump {
	
	public static int countWays(int N) {
		
		if(N < 0) {
			System.out.println("Invalid input");
			return 0;
		}
		
		if(N == 0) {
			return 0;
		} else if(N == 1) {
			return 1;
		} else if(N == 2) {
			return 1;
		} else if( N == 3) {
			return 2;
		} else {
			int[] ways = new int[N + 1];
			
			ways[0] = 0;
			ways[1] = 1;
			ways[2] = 2;
			ways[3] = 2;
			
			for(int i = 4; i <= N; i++) {
				ways[i] = ways[i-1] + ways[i-3];
			}		
			return ways[N];
		}
			
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		
		System.out.println("Number of ways -> " + countWays(len));
		
	}

}
