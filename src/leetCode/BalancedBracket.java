package leetCode;



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBracket {
    
    private static boolean Match(char a, char b) {
        
        if (a == '[' && b == ']')
            return true;
        if (a == '{' && b == '}')
            return true;
        if (a == '(' && b == ')')
            return true;
            
        return false;
    }
    
    public static boolean isBalanced(String expression) {
        
        Stack<Character> bracketStack = new Stack<Character>();
        boolean flag = true;
        
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {	
            	// Push opening char to stack
                bracketStack.push(c);
            }
            
            if(c == ')' || c == ']' || c == '}') {
                flag = false;
                
                if(bracketStack.isEmpty()) {
                    return false;
                }
                
                char top = bracketStack.pop();
                
                if(!Match(top,c)) {
                    return false;
                }
            }
        }
        
        if(flag || !bracketStack.isEmpty()) {
            return false;
        }
        else {
            return true;
        }
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}