package algorithms.backtracking;
import java.util.*;

/*
 * Remove K digits from a number to form the smallest number
 * 
 * */

public class RemoveKDigits {
		
	public String buildLowestNumber(String input, int n) {
		
		int len = input.length();
		
		if(n >= len) {
			return "0";
		}
		
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		
		while(i < input.length()) {
			
			char ch = input.charAt(i);
			
			char stackPeek = !stack.isEmpty() ? stack.peek() : '*';
			
			while(n > 0 && !stack.isEmpty() && stackPeek > ch) {
				stack.pop();
				n--;
			}
			
			stack.push(ch);
			i++;
		}
		
		/* Edge case for "1111" */
		while (n > 0) {
			stack.pop();
			n--;
		}
		
		/* Constuct the number from the stack */
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		sb.reverse();
		
		/* Remove all 0 at the head */
		while(sb.length() > 1 && sb.charAt(0) == '0') {
			sb.append(stack.pop());
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String num = "4325043";
		int n = 3; // Result -> 2043
		
		RemoveKDigits rk = new RemoveKDigits();
		System.out.println("Minimum -> " + rk.buildLowestNumber(num, n));
		
		

	}

}
