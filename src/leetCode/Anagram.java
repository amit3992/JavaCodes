/*Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets */

package leetCode;
import java.util.*;


public class Anagram {
	
	private static int prime = 23;
	
	public static long generateMyHash(String s) {
		long val = 0;
		for(int i = 0; i < s.length(); i++) {
			val = val +  (s.charAt(i) * prime); 
		}
		
		return val;
	}
	
	
	public static int getHashCode(String s) {
		return s.hashCode();
	}
	private static boolean isAnagram(String s, String t) {
		
		// length check
		if(s.length() != t.length()) 
			return false;
		
		char [] sArray = s.toCharArray();
		char [] tArray = t.toCharArray();
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		for(int i = 0; i < sArray.length; i++) {
			if(sArray[i] != tArray[i]) {
				return false;
			}
		}
		
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "doctorwho";
		String t = "torchwood";
		
		System.out.println(isAnagram(s, t));
		System.out.println("hashcode  for " + s + " -> " + getHashCode(s));
		System.out.println("hashcode  for " + t + " -> " + getHashCode(t));
		
		System.out.println("My hashcode  for " + s + " -> " + generateMyHash(s));
		System.out.println("My hashcode  for " + t + " -> " + generateMyHash(t));

	}

}
