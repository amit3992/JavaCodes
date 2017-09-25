package algorithms.backtracking;
import java.util.*;


public class WordBreakII {
	
	public boolean isValid(String str, Set<String> dict) {
		
		return wordBreakUtil(str, str.length(), "", dict);
	}
	
	private boolean wordBreakUtil(String str, int size, String result, Set<String> dict) {
		
		/* Process all prefixes one by one */
		for(int i = 0; i < size; i++) {
			
			String prefix = str.substring(0, i);
			
			/*
			 * if dictionary conatins this prefix, then
        	// we check for remaining string. Otherwise
        	// we ignore this prefix (there is no else for
        	// this if) and try next
			 * 
			 * */
			if(dict.contains(prefix)) {
				
				if(i == size) {
					
					result += prefix;
					System.out.println(result);
					return true;
				}
				
				wordBreakUtil(str.substring(i, size-i), size, result + prefix + "", dict);
			}
		}
		return false;
	}
	

	public static void main(String[] args) {
		
		WordBreakII wb = new WordBreakII();
		Set<String> set = new HashSet<String>();
		
		set.add("this");
		set.add("is");
		set.add("a");
		set.add("te");
		set.add("ates");
		set.add("test");
		set.add("cat");
		set.add("cats");
		set.add("sand");
		set.add("dog");
		
		String s = "thisisatest";
		
		wb.isValid(s, set);
		
		
		
	}

}
