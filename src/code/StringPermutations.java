/*
 * Design an algorithm to get all the permutations of a smaller string in the bigger string/
 * s = abbc
 * b = cbabadcbbabbcbabaabccbabc
 */
package code;

import java.util.HashSet;

public class StringPermutations {
	
	static HashSet<String> stringSet = new HashSet<String>();
		
	public static void computePermutations(String prefix, String s) {
		int n = s.length();
		if(n == 0) {
			//stringSet.add(prefix);
			System.out.println(prefix);
		}
		else {
			for(int i = 0; i < n; i++) {
				System.out.println("i: " + i);
				System.out.println("prefix: " + prefix + s.charAt(i));
				System.out.println("New String: " + s.substring(0,i) + s.substring(i+1,n));
				computePermutations(prefix + s.charAt(i), s.substring(0,i) + s.substring(i+1,n));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		computePermutations("","abc");
		
		/*String s = "abbc";
		String sb = "cbabadcbbabbcbabaabccbabc";
		int ptr = 0;
		
		while(ptr <= sb.length()) {
			if(ptr + s.length() > sb.length()) break;
			String str = sb.substring(ptr,(ptr + s.length()));
			if(stringSet.contains(str)) {
				System.out.println(str + " is a permutation of " + s + " at location: "+ ptr);
			}
			ptr += s.length();
		}*/
		

	}

}


/*if(stringSet.contains(str)) {
	System.out.println(str + "is a permutation of " + s + " at location: "+ ptr);
}*/
