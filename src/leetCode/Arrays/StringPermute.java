package leetCode.Arrays;

public class StringPermute {
	
	public static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void permute(char[] input, int start, int end) {
		
		if(start == end) {
			System.out.println(input);
			System.out.println();
		}
		
		for(int i = start; i <= end; i++) {
			swap(input, start, i);
			permute(input, start + 1, end);
			swap(input, start, i);	
		}
	}
	
	public static void permuteString(String s) {
		permute(s.toCharArray(), 0, s.length() - 1);
	}

	public static void main(String[] args) {
		
		permuteString("ABD");

	}

}
