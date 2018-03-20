package algorithms.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveInvalidParenthesis_II {
	
	private boolean isParenthesis(char ch) {
		if(ch == '(' || ch == ')') {
			return true;
		}
		
		return false;
	}
	
	private boolean isValidString(String str) {
		char [] st = str.toCharArray();
		int count = 0;
		
		for(int i = 0; i < st.length; i++) {
			if(st[i] == '(')
				count++;
			else if(st[i] == ')')
				count--;
			
			if(count < 0)
				return false;
		}
		
		return (count == 0);
	}
	
	public List<String> removeInvalidParentheses(String s) {
		 ArrayList<String>  result = new ArrayList<String>();
		 
		 if(s.isEmpty()) {
			 return null;
		 }
		 
		 HashSet<String> visit = new HashSet<String>();
		 Queue<String> queue = new LinkedList();
		 String temp = "";
		 boolean level = false;
		 
		 queue.add(s);
		 visit.add(s);
		 
		 while(!queue.isEmpty()) {
			 
			 s = queue.peek();
			 queue.remove();
			 
			 if(isValidString(s)) {
				 result.add(s);
				 level = true;
			 }
			 
			 if(level)
				 continue;
			 
			 for(int i = 0; i < s.length(); i++) {
				 
				 if(!isParenthesis(s.charAt(i))) {
					 continue;
				 }
				 
				// System.out.println("First substring: " + s.substring(0, i) + " for i -> " + i);
				// System.out.println("Second substring: " + s.substring(i + 1) + " for i -> " + i);
				 temp = s.substring(0, i) + s.substring(i + 1);
				 
				 if(!visit.contains(temp)) {
					 queue.add(temp);
					 visit.add(temp);
				 }
			 }
			 
		 }
		 
		 return result;
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "()()(";
        RemoveInvalidParenthesis_II rmp2 = new RemoveInvalidParenthesis_II();
        List<String> result = rmp2.removeInvalidParentheses(s);
        result.forEach(s1 -> System.out.println(s1));

	}

}
