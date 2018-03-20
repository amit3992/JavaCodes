package leetCode.String;

public class ValidPalindrome1 {
	
	public boolean isPalindrome(String s) {
		
		StringBuilder sb = new StringBuilder(s);
		if(s.equals(sb.reverse().toString())) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isPalindrome2(String s) {
		
		if(s == null || s.length() == 0) {
			return true;
		}
		
		if(isPalindrome(s)) {
			return true;
		}
		
		for(int i = 0; i < s.length(); i++) {
			
			String first = s.substring(0, i);
			String second = s.substring(i + 1);
			System.out.println("first: " + s.substring(0, i));
			System.out.println("second: " + s.substring(i + 1));
			String temp = first + second;
			
			if(isPalindrome(temp)) {
				return true;
			}
			
			System.out.println("temp: " + temp);
			System.out.println("========================");
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ValidPalindrome1 vp1 = new ValidPalindrome1();
		System.out.println("Is palindrome? : " + vp1.isPalindrome("abc"));
		
		System.out.println("Valid palindrome - 2 -> " + vp1.isPalindrome2("aba"));
		System.out.println("Valid palindrome - 2 -> " + vp1.isPalindrome2("abca"));

	}

}
