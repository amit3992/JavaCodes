package leetCode;

public class DivideTwoIntegers {
	
	public static int divide(int dividend, int divisor) {
		
		if(divisor == 0) {
			return Integer.MAX_VALUE;
		} else if(dividend == 0) {
			return 0;
		}
		
		boolean sign = false;
		
		if((dividend < 0 && divisor > 0 )|| (dividend > 0 && divisor < 0 )) {
			sign =  true;
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
			
		} else if (dividend < 0 && divisor < 0) {
			
			if(dividend <= Integer.MIN_VALUE) {
				dividend = Integer.MAX_VALUE;
			}
			
			dividend = Math.abs(dividend);
			divisor = Math.abs(divisor);
		}
		
		int count = 0;
		while(dividend >= divisor) {
			count++;
			dividend = dividend - divisor;
		}
		
		if(sign) {
			return -count;
		} else
			return count;
		
	}

	public static void main(String[] args) {
		
		int dividend = -2147483648;
		int divisor = -1;
		
		System.out.println("Result -> " + divide(dividend, divisor));

	}

}
