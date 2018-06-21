package com.math.permutation;

public class PermuteCharactersUnique {
	
	public void permute(String input, int start, int end) {
		
		if(start == end) {
			System.out.println(input);
			return;
		} else {
			
			for(int i = start; i <= end; i++) {
				input = swap(input, start, i);
				permute(input, start + 1, end);
				input = swap(input, start, i);
			}
		}
	}
	
	private String swap(String s, int a, int b) {
		
		char [] ch = s.toCharArray();
		char temp = ch[a];
		ch[a] = ch[b];
		ch[b] = temp;
		
		return String.valueOf(ch);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "ABC";
		PermuteCharactersUnique pcu = new PermuteCharactersUnique();
		pcu.permute(input, 0, input.length() - 1);
		
	}

}
