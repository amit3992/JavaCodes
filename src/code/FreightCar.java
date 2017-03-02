package code;
import java.util.*;
import java.io.*;

public class FreightCar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = in.readLine();
		
		int n = Integer.parseInt(line);
		String [] str = new String[n];
		
		for(int i = 0; i < n; i++) {
			str[i] = in.readLine();
		}
		
		System.out.println(isReverse(str[0], str[1]));
		
	}

	private static String getReverse(String s) {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		
		for(int pos = s.length() - 1; pos >= 0; pos--){
			str.append(s.charAt(pos));
		}
		
		return str.toString();

	}
	
	private static boolean isReverse(String s1, String s2) {
		// TODO Auto-generated method stub
		String str = getReverse(s1);
		if(str.equals(s2))
			return true;
		else
			return false;
	}

}
