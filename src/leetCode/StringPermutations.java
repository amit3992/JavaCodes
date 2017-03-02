package leetCode;
import java.util.*;

public class StringPermutations {
	
	String str;
	ArrayList<String> perms;
	
	StringPermutations(String str) {
		this.str = str;
		perms = getPermutations(this.str);
	}
	
	public static ArrayList<String> getPermutations(String s) {
		
		if(s == null) {
			return null;
		}
		
		ArrayList<String> permutations = new ArrayList<String>();
		// Base case
		if(s.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first = s.charAt(0);
		String str = s.substring(1);
		
		ArrayList<String> words = getPermutations(str);
		
		for(String word: words) {
			for(int j = 0; j < word.length(); j++) {
				String s_ = insertCharAt(word, first, j);
				permutations.add(s_);
			}
		}
		
		//System.out.println(permutations.toString());
		return permutations;
		
		
	}
	
	public static String insertCharAt(String word, char ch, int index) {
		String start = word.substring(0,index);
		String end = word.substring(index);
		
		return start + ch + end;
	}
	
	public static void main(String[] args) {
		
		StringPermutations sp = new StringPermutations("abcde");
		ArrayList<String> list = sp.getPermutations("abcde");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}
	
}


	
	

