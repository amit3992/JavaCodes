package com.practice.conversion;
import java.util.*;

public class DecimalToBinary {
	
	public static void getDigits(int num) {
		
		
		if(num <= 0) {
			return;
		}
		
		System.out.println("Digits for -> " + num);
		while(num > 0) {
			int rem = num % 10;
			System.out.println(rem);
			num /= 10;
		}
	}
	
	
	public static void convertToBinary(int num) {
		
		StringBuilder sb = new StringBuilder();
		
		if(num <= 0) {
			return;
		}
		
		System.out.println("Binary format -> ");
		while(num > 0) {
			
			int rem = num % 2;
			sb.append(rem);
			
			num /= 2;
		}
		
		System.out.println(sb.reverse().toString());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getDigits(125);
		convertToBinary(1);

	}

}
