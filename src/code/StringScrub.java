package code;

import java.util.*;

public class StringScrub {
	
    public static String removeSpecificCharacters(String sentence, String charsToRemove)
    {
        StringBuilder sb = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (!charsToRemove.contains(String.valueOf(c))) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String scrub = sc.nextLine();
		
		System.out.println("New String: "+removeSpecificCharacters(str, scrub));

	}

}
