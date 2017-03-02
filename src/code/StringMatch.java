package code;
import java.util.*;

public class StringMatch {

	
		private static int stringMatch(String s1, String pattern) {
		
		int len = pattern.length();
		int n = s1.length();
		
		for(int i = 0; i <= (len-n); i++) {
			String sub = pattern.substring(i, (n + i));
			
			if(sub.equals(s1)) {
				return i;
			}
		}
		
		System.out.println("String not found!");
		return 0;
		
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aababba";
		String s2 = "abba";
		
		System.out.println(stringMatch(s2,s1));	

	}

}
