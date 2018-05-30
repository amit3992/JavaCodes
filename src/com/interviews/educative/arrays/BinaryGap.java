package com.interviews.educative.arrays;

public class BinaryGap {
	
	public static int getBinaryGap(int num) {
		
		/* Edge case */
		if (num <= 0) {
			return 0;
		}
		
		int gap = 0;
		
		/* Remove the trailing zeros */
		while(num % 2 == 0) {
			num /= 2;
		}
		
		int count = 0;
		
		/* Iterate */
		while(num > 0) {
			
			if (num % 2 == 0) {
				count += 1;
			} else {
				gap = Math.max(count, gap);
				count = 0;
			}
		}
		
		return gap;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Binary Gap -> " + getBinaryGap(50));

	}

}
