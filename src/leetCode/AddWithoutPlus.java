package leetCode;

import java.util.Scanner;

public class AddWithoutPlus {
	
	static int add(int x, int y) {
		
		// Iterate till there is no carry
		while(y != 0) {
			
			// Carry contains set bits of x & y
			int carry = x & y;
			
			// Sum of bits of x and y where at least one of the bits is not set
			x = x ^ y;
			
			// Carry is shifted by one so that adding it to x gives the required sum
			y = carry << 1;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println("Result -> " + add(a,b));
		
	}

}
