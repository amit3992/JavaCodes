/*
 * String compression
 * aabcccccaaa -> a2b1c5a3
 * Check if compressed string is smaller than original, otherwise return original.
 */
package code;
import java.util.*;


public class CompressedString {
	
	private static String getCompressedString(String str) {
		
		char[] strArray = str.toCharArray();
		int count = 1;
		
		StringBuffer newString = new StringBuffer("");
		
		for(int i = 0; i < str.length(); i++) {
			System.out.println("===================");
			int j = i + 1;
			
			if(j >= str.length())
				break;
			
			System.out.println("ith element -> " + i + " = "+ strArray[i]);
			System.out.println("jth element -> " + j + " = "+ strArray[j]);
			if(strArray[i] == strArray[j]) {
				System.out.println("ith and jth element are same! Incrementing count");
				count += 1;
				
			}
			else {
				System.out.println("ith and jth elements are not same!");
				StringBuffer s = new StringBuffer("");
				s.append(strArray[i]);
				s.append(count);
				System.out.println("Compressed substring: " + s.toString());
				newString = newString.append(s);
				count = 1;
			}
		}
		
		return newString.toString();
	}
	
	private static String getCompressedString2(String str) {
		
		char[] strArray = str.toCharArray();
		int count = 1;
		
		StringBuffer newString = new StringBuffer("");
		
		int x = 1;
		while(x < str.length()) {
			int y = x - 1;
			if(strArray[x] == strArray[y]) {
				System.out.println("xth and yth element are same! Incrementing count");
				count += 1;
			}
			else {
				System.out.println("xth and yth elements are not same!");
				StringBuffer s = new StringBuffer("");
				s.append(strArray[y]);
				s.append(count);
				System.out.println("Compressed substring: " + s.toString());
				newString = newString.append(s);
				count = 1;
			}
			x = x + 1;
		}
		
		return newString.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getCompressedString2("aabcccccaaa"));

	}

}
