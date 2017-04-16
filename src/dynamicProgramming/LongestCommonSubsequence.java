package dynamicProgramming;
import java.util.*;


public class LongestCommonSubsequence {
	
	private static int getLCS(String a, String b, int aL, int bL) {
		// TODO Auto-generated method stub
		
		int[][] T = new int[aL+1][bL+1];
		
		
		for(int i = 0; i <= aL; i++) {
			for(int j = 0; j <= bL; j++) {
				
				if(i == 0 || j == 0) {
					T[i][j] = 0;
				}
				else if(a.charAt(i-1) == b.charAt(j-1)) {
					T[i][j] = T[i-1][j-1] + 1;
				}
				else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
			
		}
		
		return T[aL][bL];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "AGGTAB";
		String b = "GXTXAYB";
		
		System.out.println("Lenght of longest common subsequence is -> " + getLCS(a, b, a.length(), b.length()));

	}

	

}
