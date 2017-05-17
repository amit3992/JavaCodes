package leetCode.String;
import java.util.*;

/*https://leetcode.com/problems/reverse-vowels-of-a-string/#/description*/

public class ReverseVowels {
	
	HashSet<Character> vowel;
	char[] s_array;
	
	ReverseVowels() {
		vowel = new HashSet<Character>();
		vowel.add('a');
		vowel.add('e');
		vowel.add('i');
		vowel.add('o');
		vowel.add('u');
	}
	
	public boolean isVowel(char a) {
		if(vowel.contains(a))
			return true;
		else
			return false;
	}
	
	public void swapChar(int a, int b) {
		char temp = s_array[b];
		s_array[b] = s_array[a];
		s_array[a] = temp;
	}
	
	public String reverseVowels(String s) {
		
		if(s == null  && s.isEmpty()) {
			return s;
		}
		
		int len = s.length();
		int a = 0;
		int b = len-1;
		
		s_array = s.toCharArray();
		
		while(a < b) {
			char l = s.charAt(a);
			char r = s.charAt(b);
			
			if(isVowel(l) && isVowel(r)) {
				swapChar(a,b);
				a++;
				b--;
			} else if(isVowel(l) && !isVowel(r)) {
				b--;
			} else if (!isVowel(l) && isVowel(r)) {
				a++;
			} else {
				a++;
				b--;
			}
			
		}
		
		return String.valueOf(s_array);
	}

	public static void main(String[] args) {
		String s1 = "hello"; // -> "holle"
		String s2 = "leetcode"; // -> "leotcede"
		String s3 = "geeksforgeeks";
		
		ReverseVowels rv = new ReverseVowels();
		
		System.out.println("Modified string -> " + rv.reverseVowels(s1));
		System.out.println("Modified string -> " + rv.reverseVowels(s2));
		System.out.println("Modified string -> " + rv.reverseVowels(s3));

	}

}
