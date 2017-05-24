package leetCode;
import java.util.*;

public class RemoveDuplicateCharacters {
	
	public static String removeDups(String s) {
		boolean [] chars = new boolean[26];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int val = (int)ch - 'a';
			
			if(!chars[val]) {
				chars[val] = true;
			} else {
				continue;
			}
		}
		
		for(int i = 0; i < chars.length; i++) {
			if(chars[i]) {
				int val = (int)'a' + i;
				char ch = (char)val;
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
		String s = "bcabc";
		String test = "abcdefghijklmnopqrstuvwxyz";
		String s1 = "cbacdcbc";
		
		System.out.println("Removing duplicates -> " + removeDups(s));
		System.out.println("Removing duplicates -> " + removeDups(s1));

	}

}
