package leetCode.String;
import java.util.*;

public class KMP {
	
	public boolean KMP(char[] str, char[] pat) {
		if(str == null || pat == null) {
			return false;
		}
		
		int[] lps = computeTemporaryArray(pat);
				
	}
	
	private int[] computeTemporaryArray(char[] pattern) {
		
		int index = 0;
		int [] lps = new int[pattern.length];
	}

	public static void main(String[] args) {
		
		String str = "abcxabcdabcdabcy";
		String pat = "abcdabcy";
		
		KMP kmp = new KMP();
		
		boolean result = kmp.KMP(str.toCharArray(), pat.toCharArray());
        System.out.print(result);
		

	}

}
