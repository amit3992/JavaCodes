package code;

import java.util.*;
import java.io.*;

public class RegexTest {
	
	public static String regexMethod1(String s) {
		return s.replaceAll("[^a-zA-Z0-9_. ]", "");
	}
	
	public static String regexMethod2(String s) {
		return s.replaceAll("[^a-zA-Z0-9_. -+]", "");
	}
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
		
		String str = line.readLine();
		
		System.out.println("Regex output of method 1: "+regexMethod1(str));
		System.out.println("Regex output of method 2: "+regexMethod2(str));
		
	}
}
