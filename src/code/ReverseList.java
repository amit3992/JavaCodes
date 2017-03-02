/*
 * Input -> ABE,XEE,DCA,FGH
 * Output -> EBA,EEX,ACD,HGF
 * 
 */

package code;
import java.util.*;
import java.io.*;

public class ReverseList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		
		System.out.println(getReverseWordList(line));

	}

	private static String getReverseWordList(String str) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(str, ",");
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			s = reverseString(s);
			sb.insert(sb.length(),s);
			if(st.hasMoreElements()) {
				sb.insert(sb.length(),",");
			}
		}
		return sb.toString();
	}

	private static String reverseString(String s) {
		// TODO Auto-generated method stub
		char [] ch = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i = ch.length-1; i >= 0; i--) {
			sb = sb.append(ch[i]);
		}
		return sb.toString();
	}

}
