package dynamicProgramming;
import java.util.*;

public class DavisStairs {
	
	public int getWays(int N) {
		
		if(N == 1) {
			return 1;
		} else if( N == 2) {
			return 2;
		} else if(N == 3) {
			return 4;
		} else {
			
			int[] count = new int[N+1];
			
			count[0] = 0;
			count[1] = 1;
			count[2] = 2;
			count[3] = 4;
			
			for(int i = 4; i <= N; i++) {
				count[i] = count[i-1] + count[i-2] + count[i-3];
			}
			
			return count[N];
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		DavisStairs ds = new DavisStairs();
		
		while(s-- > 0) {
			int n = sc.nextInt();
			System.out.println(ds.getWays(n));
		}

	}

}
