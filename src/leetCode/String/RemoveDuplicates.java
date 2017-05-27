package leetCode.String;

public class RemoveDuplicates {
	
	public static String removeDuplicates(String s) {
		
		int[] ref = new int[26];
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			int pos = (int)(ch - 'a');
			
			if(ref[pos] != 1) {
				ref[pos] = 1;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 26; i++) {
			if(ref[i] == 1) {
				char ch = (char) (i + 'a');
				sb.append(ch);
			}
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		String ip = "abbabcddbabcdeedebc";
		
		System.out.println("Output after removing duplicates -> " + removeDuplicates(ip));

	}

}
