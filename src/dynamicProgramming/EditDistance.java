package dynamicProgramming;
import java.util.*;

public class EditDistance {
	
	public static int getMin(int a, int b, int c) {
		return Math.min(Math.min(a, b), b);
	}
	
	public static int getEditDistance(String s1, String s2) {
		
		if(s1 == null || s2 == null) {
			return -1;
			
		} else if(s1.equals(s2)) {
			return -1;
		} else if(s1 == null || s1.isEmpty()) {
			return s2.length();
		} else if(s2 == null || s2.isEmpty()) {
			return s1.length();
		}
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] d = new int[m+1][n+1];
		
		for(int i = 0; i <= m; i++) {
			d[i][0] = i;
		}
		
		for(int j = 0; j <= n; j++) {
			d[0][j] = j;
		}
		
		int cost = 0;
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					cost = 1;
				} else {
					cost = 0;
				}
				
				d[i][j] = getMin(d[i-1][j] + 1, d[i][j-1] + 1, d[i-1][j-1] + cost);	
			}
		}
		
		return d[m][n];
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println("Levenshtein distance -> " + getEditDistance(s1, s2));

	}

}
