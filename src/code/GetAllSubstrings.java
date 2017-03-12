package code;
import java.io.*;
import java.util.*;

public class GetAllSubstrings {
	

	private static void getAllSubstrings(String s) {
		int len = s.length();
		
		for(int i = 1; i <= len; i++) {
			for(int j = 0; j <= len; j++) {
				int k = i + j - 1;
				
				if(k >= len)
					continue;
				
				String str = s.substring(j, i+j);
				System.out.println("Substring: " + str);
				
				
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
		String str = line.readLine();
		getAllSubstrings(str);
		

	}

}
