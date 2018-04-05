package com.leetcode.calculator;
import java.util.*;

/*
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * "1 + 1" = 2
 * "2 - 1 + 2" = 3
 * \
 * Convert infix to postfix
 * evaluate postfix
 * */


public class BasicCalculator {
	
	private int getOperationRank(char op) {
		switch(op) {
		case '+': return 1;
		case '-': return 1;
		case '*' : return 2;
		case '/' : return 2;
		default : return 0;
		
		}
	}
	
	private List<Object> infixToPostFix(String expression) {
		
		Stack<Character> operator = new Stack<Character>();
		List<Object> postfix = new LinkedList<Object>();
		int numberBuffer = 0;
		boolean bufferOperand = false;
		
		for(char c : expression.toCharArray()) {
			
			if(c >= '0' && c <= '9') {
				numberBuffer = numberBuffer * 10 + c - '0';
				bufferOperand = true;
			} else {
				
				if(bufferOperand) {
					postfix.add(numberBuffer);
				}
				numberBuffer = 0;
				bufferOperand = false;
				
				/* White space and tabs */
				if(c == ' ' || c == '\t') {
					continue;
				}
				
				if(c == '(') {
					operator.push(c);
				} else if(c == ')') {
					while(operator.peek() != '(') {
						postfix.add(operator.pop());
					}
					operator.pop();
				} else {
					while(!operator.isEmpty() && getOperationRank(c) <= getOperationRank(operator.peek())) {
						postfix.add(operator.pop());
					}
					operator.push(c);
				}
			}
		}
		
		if(bufferOperand) {
			postfix.add(numberBuffer);
		}
		
		while(!operator.isEmpty()) {
			postfix.add(operator.pop());
		}
		
		return postfix;
		
		
	}
	
	private int evaluatePostFix(List<Object> postfix) {
		
		Stack<Integer> operands = new Stack<Integer>();
		
		int a = 0;
		int b = 0;
		
		for(Object s : postfix) {
			if(s instanceof Character) {
				
				char c = (Character) s;
				
				b = operands.pop();
				a = operands.pop();
				
				switch (c) {
				case '+': operands.push(a + b); break;
				case '-': operands.push(a - b); break;
				case '*': operands.push(a * b); break;
				default : operands.push(a / b); 
				}
			} else {
				operands.push((Integer)s);
			}
		}
		
		return operands.pop();
	}
	
	public int calculate(String s) {
		List<Object> postfix = infixToPostFix(s);
		return evaluatePostFix(postfix);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String expression = "(1+(4+5+2)-3)+(6+8)";
		String exp = "2-1+2";
		String exp2 = "3+5 / 2";
		BasicCalculator bc = new BasicCalculator();
		
		List<Object> post = bc.infixToPostFix(expression);
		System.out.println(post);
		
		System.out.println("Answer: " + bc.calculate(expression));

	}

}
