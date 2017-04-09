package leetCode;
import java.util.*;

public class ReverseStringWords {
	
	public static void reverseString(String line) {
		StringTokenizer st = new StringTokenizer(line, " ");
		StringBuilder sb = new StringBuilder();
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			s = s + " ";
			sb = sb.insert(0,s);
			
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		reverseString(s);
	}

}
