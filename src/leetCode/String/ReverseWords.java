package leetCode.String;
import java.util.*;

public class ReverseWords {
	
	public static String reverseWordsNoXSpace(String s) {
		
		/* No extra space */
		
		StringTokenizer stk = new StringTokenizer(s, " ");
		StringBuilder sb = new StringBuilder();
		
		while(stk.hasMoreTokens()) {
			String strng = stk.nextToken();
			
			sb.insert(0, strng);
			sb.insert(0, " ");
		}
		
		return sb.toString().trim();
	}
	
	public static String reverseWords(String s) {
		
		/* Using extra space */
		Stack<String> st = new Stack<String>();
		StringTokenizer stk = new StringTokenizer(s, " ");
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		while(stk.hasMoreTokens()) {
			String strng = stk.nextToken();
			st.push(strng);
			count++;
		}
		
		while(!st.isEmpty()) {
			sb.append(st.pop());
			if(count-- > 1) {
				sb.append(" ");
			}
		}
		
		
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "The quick brown fox jumped over the lazy dog.";
		
		System.out.println(reverseWords(s));
		System.out.println();
		System.out.println("Revesion without extra space -> " + reverseWordsNoXSpace("a b"));

	}

}
