package algorithms.backtracking;
import java.util.*;

public class GenerateParenthesis {
	
	public ArrayList<String> generate(int n) {
		ArrayList<String> result = new ArrayList<String>();
		backtrack(result, "", 0, 0, n);
		
		return result;
	}
	
	public void backtrack(ArrayList<String> result, String str, int open, int close, int n) {
		if(str.length() == n*2) {
			result.add(str);
			return;
		}
		
		if(open < n) {
			backtrack(result, str + "{", open+1, close, n);
		}
		
		if(close < open) {
			backtrack(result, str + "}", open, close+1, n);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		GenerateParenthesis gp = new GenerateParenthesis();
		
		for(String s: gp.generate(n)) {
			System.out.println(s);
		}

	}

}
