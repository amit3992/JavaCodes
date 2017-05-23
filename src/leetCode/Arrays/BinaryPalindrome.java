package leetCode.Arrays;
import java.util.*;

public class BinaryPalindrome {
	
	public static boolean checkPalindrome(int j){
	    String s = Integer.toBinaryString(j);
	    for(int i=0;i<s.length()/2;i++){
	      if(s.charAt(i)!=s.charAt(s.length()-i-1))
	          return false;
	    }
	    return true;
	  }
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("Palindrome check for " + n + " -> " + checkPalindrome(n));

	}

}
