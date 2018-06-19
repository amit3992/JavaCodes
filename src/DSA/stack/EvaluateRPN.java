/*
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * */

package DSA.stack;
import java.util.*;


public class EvaluateRPN {

	public static int evaluateRPN(String [] input) {
		
		if(input == null || input.length == 0) {
			return 0;
		}
		
		int result = 0;
		Stack<Integer> numStack = new Stack<Integer>();
		
		for(int i = 0; i < input.length; i++) {
			
			String s = input[i];
			
			if(Character.isDigit(s.charAt(0))) {
				int val = Integer.valueOf(s);
				numStack.push(val);
			} else {
				
				int b = numStack.pop();
				int a = numStack.pop();
				
				int val = 0;
				
				if(s == "+") {
					val = a + b;
				} else if(s == "-"){
					val = a - b;
				} else if (s == "*") {
					val = a*b;
				} else if(s == "/") {
					val = a/b;
				}
				
				numStack.push(val);
			}
		}
		
		if(!numStack.isEmpty()) {
			result = numStack.pop();
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] input = {"2", "1", "+", "3", "*"};
		String [] input2 = {"4", "13", "5", "/", "+"};
		String [] input3 = {"2", "2", "/"};
		
		System.out.println("Answer -> " + evaluateRPN(input3));
		

	}

}
