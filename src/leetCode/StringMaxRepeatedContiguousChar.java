package leetCode;
/*
 * ip: ffgggggtvshjsdhjfffffffhvjbjcharu
 * op - f
 */

public class StringMaxRepeatedContiguousChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "ffgggggtvshjsdhjfffffffhvjbjcharu";
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		char prev = a.charAt(0);
		for(int i = 1; i < a.length(); i++) {
			
			if(a.charAt(i) == prev) {
				sum += 1;
			}
			else {
				max = Math.max(max, sum);
				sum = 0;
			}
			
			prev = a.charAt(i);
			
		}
		
		System.out.println("Max -> " + (max+1));

	}

}
