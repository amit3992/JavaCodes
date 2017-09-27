package leetCode.String;
import java.util.*;

public class WordBreak {
	
	private static boolean wordBreakUtil(String s, HashSet<String> dict, HashSet<String> result) {
		
		for(int i = 1; i <= s.length(); i++) {
			
			String first = s.substring(0, i);
			
			if(dict.contains(first)) {
				
				String second = s.substring(i);
				
				if(second == null || second.length() == 0 || dict.contains(second)) {
					return true;
				}
				
				if(!result.contains(second)) {
					
					if(wordBreakUtil(second, dict, result)) {
						return true;
					}
					
					result.add(second);
				}
			}
		}
		
		return false;
	}
	
	public static boolean wordBreak(String s, HashSet<String> dict) {
		HashSet<String> result = new HashSet<String>();
		
		return wordBreakUtil(s, dict, result);
	}

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		set.add("this");
		set.add("is");
		set.add("a");
		set.add("tes");
		set.add("test");
		
		String s = "thisistes";
		
		if(wordBreak(s, set)) {
			System.out.print("Word found!");
		} else {
			System.out.println("Word not found. ");
		}
		

	}

}
