package leetCode;
import java.util.*;


public class EvaluateString {
	
	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();
		
		// Stack for values
		Stack<Integer> value = new Stack<Integer>();
		
		// Stack for operators
		Stack<Character> ops = new Stack<Character>();
		
		for(int i = 0; i < tokens.length; i++) {
			
			// Ignore white space
			if(tokens[i] == ' ')
				continue;
			
			// If token is a number, push it on the stack of numbers
			if(tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sb = new StringBuffer();
				// Number could have more than 1 digit
				while(i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sb.append(tokens[i++]);
				
				value.push(Integer.parseInt(sb.toString()));
			}
			
			// Current token is an opening brace bracket
			else if(tokens[i] == '(')
				ops.push(tokens[i]);
			
			// When you encounter ")" solve the bracket
			else if (tokens[i] == ')')
			{
				while(ops.peek() != '(') {
					value.push(applyOp(ops.pop(), value.pop(), value.pop()));
				}
				ops.pop();
			}
			
			// Current token is an operator
			if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				
				while(!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					value.push(applyOp(ops.pop(), value.pop(), value.pop()));
				
				ops.push(tokens[i]);
				
			}
			
			while(!ops.empty()) {
				value.push(applyOp(ops.pop(), value.pop(), value.pop()));
			}
			
			
			
		}
		
		return value.pop();
		
		
	}
	
	private static int applyOp(char op, int a, int b) {
		// TODO Auto-generated method stub
		switch(op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if(b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		
		return 0;
	}

	public static boolean hasPrecedence(char op1, char op2) {
		if(op2 == '(' || op2 == ')')
			return false;
		if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else 
			return true;
	}
	
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		System.out.println(EvaluateString.evaluate("10 + 2 * 6"));

	}

}
