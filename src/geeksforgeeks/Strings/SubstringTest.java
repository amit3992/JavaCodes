package geeksforgeeks.Strings;

public class SubstringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "thisisatest";
		System.out.println("Here I will test java string substring methds");
		System.out.println("==================================");
		System.out.println("Input: " + input);
		int len = input.length();
		System.out.println("Input substring start -> 0,  end -> 4: " + input.substring(0, 4));
		System.out.println("Input substring start -> 4: " + input.substring(4));
		
		System.out.println("==================================");
		System.out.println("Getting all substrings");
		
		for(int i = 0; i < input.length(); i++) {
			System.out.println("First: input.substring(0, i) -> " + input.substring(0, i));
			System.out.println("Second : input.substring(i+1) -> " + input.substring(i + 1));
		}
		
		
		System.out.println("==================================");
		System.out.println("Getting a single character from reverse");
		
		for(int i = input.length() - 1; i >= 0; i--) {
			System.out.println("First: input.substring(i, i + 1) -> " + input.substring(i, i+1));
		}

	}

}
