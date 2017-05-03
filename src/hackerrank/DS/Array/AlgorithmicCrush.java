package hackerrank.DS.Array;
/*5 3
1 2 100
2 5 100
3 4 100

op: 200*/

import java.util.Arrays;
import java.util.Scanner;

public class AlgorithmicCrush {
	
	static long[] array;
	static long max = Integer.MIN_VALUE;
	static int N;
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		N = n;
		
		array = new long[n+1];
		Arrays.fill(array, 0);
		
		while(q > 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int val = sc.nextInt();
			
			array[start-1] += val;
			array[end-1] += val;
			q--;
		}
		
		for(int i = 0; i < n; i++) {
			max = Math.max(max, array[i]);
		}
		
		System.out.println(max);
		
		
	}

}
