package code;
import java.util.*;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(getGCD(12,24));

	}

	private static int getGCD(int i, int j) {
		// TODO Auto-generated method stub
		
		int n = gcd(i,j);
		int result = 0;
		for(int ind = 0; ind <= Math.sqrt(n); ind++) {
			
			if(n % i == 0) {
				
				if(n/i == i)
					result = result + 1;
				else
					result = result + 2;
			}
		}
		return result;
	}

	private static int gcd(int a, int b) {
		// TODO Auto-generated method stub
		if(a == 0)
			return b;
		return gcd(b%a, a);
	}

}
