package leetCode;

import java.util.Scanner;

public class PowerN {
	
	public static double powN(double x, int n) {
		
		double temp = x;
		if(n == 1)
			return 1;
		
		temp = powN(x,n/2);
		
		if(n % 2 == 0) {
			return temp * temp;
		} else {
			if(n > 0)
				return x * temp * temp;
			else
				return (temp * temp)/x;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = sc.nextDouble();
		int n = sc.nextInt();
		
		System.out.println("Ans -> " + powN(x,n));
	}

}
