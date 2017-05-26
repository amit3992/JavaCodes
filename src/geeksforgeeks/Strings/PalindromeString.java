package geeksforgeeks.Strings;
import java.util.*;


public class PalindromeString {
	
	public static boolean isPalindrome(String str) {
		// base case #1 : length of string == 0 or 1, return true;
		if(str.length() == 0 || str.length() == 1) {
			return true;
		}
		
		// base case #2
		int len = str.length();
		if(str.charAt(0) != str.charAt(len-1)) {
			return false;
		}
		
		// recursive case
		String sub = str.substring(1, len-1);
		return isPalindrome(sub);
	}

	public static void main(String[] args) {
		
		System.out.println("ROTOR -> " + isPalindrome("ROTOR"));
		System.out.println("MOTOR -> " + isPalindrome("MOTOR"));
		System.out.println("ANNA -> " + isPalindrome("ANNA"));
		System.out.println("RATER -> " + isPalindrome("RATER"));
		System.out.println("XYZYZYX -> " + isPalindrome("XYZYZYX"));

	}

}
