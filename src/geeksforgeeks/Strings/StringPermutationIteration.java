package geeksforgeeks.Strings;
import java.util.*;

public class StringPermutationIteration {
	
	public static ArrayList<String> getPermutations(String str) {
		
		if(str == null)
			return null;
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		if(str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		
		char first = str.charAt(0);
		String s = str.substring(1);
		
		ArrayList<String> words = getPermutations(s);
		
		for(String word: words) {
			
			for(int i = 0; i < word.length(); i++) {
				String newString = insertCharAt(word, first, i);
				permutations.add(newString);
			}
		}
		
		return permutations;
		
	}

	private static String insertCharAt(String word, char first, int i) {
		// TODO Auto-generated method stub
		String start = word.substring(0,i);
		String end = word.substring(i);
		return start + first + end;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutations("abc").toString());

	}

}
