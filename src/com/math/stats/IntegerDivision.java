package com.math.stats;
import java.util.*;

public class IntegerDivision {
	
	public int divide(int dividend, int divisor) {
		
		if(divisor == 0) {
			return -1;
		}
		
		if(dividend < divisor) {
			return 0;
		}
		
		if(dividend == divisor) {
			return 1;
		}
		
		if(dividend == 0) {
			return 0;
		}
		
		int quotient = 1;
		int temp = divisor;
		
		while(temp < dividend) {
			temp = temp << 1;
			quotient = quotient << 1;
		}
		
		if(temp > dividend) {
			temp = temp >> 1;
			quotient = quotient >> 1;
			
			return quotient + divide(dividend - temp, divisor);
		}
		
		return quotient;
	}
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int dividend = sc.nextInt();
		int divisor = sc.nextInt();
		
		IntegerDivision id = new IntegerDivision();
		
		System.out.println("Division -> " + id.divide(dividend, divisor));
	}

}
