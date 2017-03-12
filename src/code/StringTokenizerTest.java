/*
 * Uses StringTokennizer to split a string by “space” and “comma” delimiter, and iterate the StringTokenizer elements and print it out one by one.
 * 
 */

package code;
import java.util.*;
import java.io.*;

public class StringTokenizerTest {
	
	private static String reverseStringWithTokenizer(String str) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(str," ");
		
		while(st.hasMoreTokens()) {
			sb.insert(0,st.nextToken());
			if(st.hasMoreElements()) 
				sb.insert(0," ");
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		System.out.println(reverseStringWithTokenizer(line));
		
		String s1 = "Hello!";
		String s2 = new String("Hello!"); // Created in heap
		
		System.out.println();
	}

}
