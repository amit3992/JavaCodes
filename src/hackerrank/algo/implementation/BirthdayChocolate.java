package hackerrank.algo.implementation;
import java.util.*;

/*
 * ip: 5
 * 1 2 1 3 2
 * d = 3, m = 2
 * 
 * op: 2
 * */

public class BirthdayChocolate {
	
	static int solve(int n, int[] s, int d, int m){
		
		int count = 0;
		int sum = 0;
		
		for(int i = 0; i <= (n - m); i++) {
			
			for(int j = i; j < (i + m); j++) {
				
				if( j >= n) {
					break;
				}
				sum += s[j];
			}
			
			if(sum == d) {
				count++;
				sum = 0;
			}
			
		}
		
		return count;
        
    }

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);

	}

}
