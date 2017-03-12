package code;
import java.util.*;
import java.io.*;

public class UniqueString {
	
	private static boolean isStringUnique(String str) {
		
		str = str.toLowerCase();
		char[] charArray = str.toCharArray();
		
		boolean [] char_val = new boolean[128];
		
		for(char c: charArray) {
			int val = (int) c;
			if(char_val[val])
				return false;
			char_val[val] = true;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
		String s = line.readLine();
		
		System.out.println(isStringUnique(s));
		
		

	}

}
