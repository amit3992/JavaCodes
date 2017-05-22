package leetCode;
import java.util.*;

/* 10 - 1;
 * 2 - 2
 * -3456 - 18
 * 1325132435356 - 43
 **/

public class DigitSum {
	
	public static int getDigitSum(long number) {
		if(number == 0) {
			return 0;
		}
		
		if(number < 0) {
			number = Math.abs(number);
		}
		
		int sum = 0;
		while(number > 0) {
			int digit = (int)number % 10;
			sum += digit;
			number = number/10;
		}
		
		return sum;
	}
	public static void main(String[] args) {
		
		System.out.println("10 -> " + getDigitSum(10));
		System.out.println("2 -> " + getDigitSum(2));
		System.out.println("-3456 -> " + getDigitSum(-3456));
		System.out.println("1325132435 -> " + getDigitSum(1325132435));

	}

}
