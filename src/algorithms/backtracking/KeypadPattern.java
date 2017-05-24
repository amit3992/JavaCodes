package algorithms.backtracking;
import java.util.*;

public class KeypadPattern {
	
	String[] dialPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public ArrayList<String> getPatterns(String num) {
		
		ArrayList<String> result = new ArrayList<String>();
		
		backtrack(result, "", 0, num);
		
		return result;
	}
	
	public void backtrack(ArrayList<String> result, String str, int index, String num) {
		if(index >= num.length()) {
			result.add(str);
			return;
		}
		
		String letters = dialPad[(num.charAt(index) - '0')];
		for(int i = 0; i < letters.length(); i++) {
			backtrack(result, str + letters.charAt(i), index+1, num);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		
		KeypadPattern kp = new KeypadPattern();
		
		for(String s: kp.getPatterns(num)) {
			System.out.println(s);
		}
		

	}

}
