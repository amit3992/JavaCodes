package leetCode;

public class UniqueCharacters {
	
	public static boolean isUnique(String str) {
		
		int res = 1;
		for(int i = 0; i < str.length(); i++) {
			System.out.println("res = " + res + ", char -> " + str.charAt(i));
			res = res ^ (int)str.charAt(i);
			System.out.println("res -> " + (char)res);
			if(res == 0) {
				return false;
			}
		}
		
		return true; 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcedf";
		String s2 = "abbcdef";
		
		//System.out.println("String " + s + " -> " + isUnique(s));
		System.out.println("String " + s + " -> " + isUnique(s2));

	}

}
