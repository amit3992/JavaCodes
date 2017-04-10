package leetCode;
import java.util.*;
import java.util.Map.Entry;

public class LongestPalindromicSubstring {
	
	public static String getSubstring(String s) {
		
		int n = s.length();
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        int max = 0;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                int k = i + j - 1;
                
                if(k >= n) {
                    continue;
                }
                
                String str = s.substring(j, i+j);
                StringBuilder sb = new StringBuilder(str);
                if(sb.toString().equals(sb.reverse().toString())) {
                    int len = sb.toString().length();
                    map.put(len, sb.toString());
                    if(len > max) {
                        max = len;
                    }
                }
                
                
            }
        }
        
        return map.get(max);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "babad";
		System.out.println("Longest palindromic substring -> " + getSubstring(s));

	}

}
