package leetCode;
import java.util.*;
/*
 * Leetcode 209
 */
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.

public class WordPattern {
	
	public static boolean isWordPattern(String pattern, String str) {
		
		
		String[] words = str.split(" ");
		
		if(pattern.length() < words.length) {
			return false;
		}
		
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		
		for(int i = 0; i < words.length; i++) {
			
			if(!charMap.containsKey(pattern.charAt(i))) {
				charMap.put(pattern.charAt(i), i);
			}
			
			
			if(!wordMap.containsKey(words[i])) {
				wordMap.put(words[i], i);
			}
			
			if(charMap.get(pattern.charAt(i)) != wordMap.get(words[i])) {
				return false;
			}
		}
		
		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "abba";
		String str = "dog cat cat fish";
		System.out.println("Pattern -> " + pattern + " | str -> " + str + " : " + isWordPattern(pattern, str));

	}

}
