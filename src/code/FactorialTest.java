package code;
import java.math.BigInteger;
import java.util.*;

public class FactorialTest extends getMultiples {
	
	public static BigInteger calFactorial(int n) {
		BigInteger val = BigInteger.ONE;
		for(int i = n; i > 0; i--) {
			val = val.multiply(BigInteger.valueOf(i));
		}
		return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter a number: ");
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println("Factorial of "+n+": "+calFactorial(n));
		
		System.out.println("No. of trailing 0's: "+getAllMultiples(n, 5));
		
	}

}
