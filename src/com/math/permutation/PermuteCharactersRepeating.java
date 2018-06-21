package com.math.permutation;

public class PermuteCharactersRepeating {
	
	public void permute(String input, int start, int end) {
		
		if(start >= end) {
			System.out.println(input);
			return;
		} else {
			
			for(int i = start; i <= end; i++) {
				
				boolean check = shouldSwap(input, start, i);
				if(check) {
					input = swap(input, start, i);
					permute(input, start + 1, end);
					input = swap(input, start, i);
				}
				
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

	
	private boolean shouldSwap(String s, int index, int current) {
		
		char [] ch = s.toCharArray();
		
		for(int i = index; i <= current; i++) {
			if(ch[i] == ch[current]) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "ABA";
		PermuteCharactersRepeating pcr = new PermuteCharactersRepeating();
		pcr.permute(input, 0, input.length() - 1);

	}

}
