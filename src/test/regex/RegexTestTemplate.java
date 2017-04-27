package test.regex;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestTemplate {

	public static void main(String[] args) {
		
			String regex = "";
			String input = "";
			
			Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter regex");
			regex = sc.next();
			
			System.out.println("Enter string");
			input = sc.next();
			
			Pattern pattern = Pattern.compile(regex);
			
			Matcher matcher = pattern.matcher(input);
			
			boolean found = false;
			
			while(matcher.find()) {
				matcher.group();
				System.out.println("MATH FOUND FROM -> " + matcher.start() + ", " + matcher.end());
				found = true;
			}
			
			if(!found) {
				System.out.println("No pattern!");
			}
		}

}
