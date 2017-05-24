package leetCode.binarySearch;

import java.util.Scanner;

public class PowerN {
	
	public static double powN(double x, int y) {
		
		double temp = 0;
		
		if(y == 0)
			return 1;
		
		temp = powN(x, y/2);
		
		if(y % 2 == 0) {
			return temp * temp;
		} else {
			if(y > 0)
				return x * temp * temp;
			else
				return (temp * temp)/x;
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double x = 4;
		int y = -3;
		
		System.out.println("Ans -> " + powN(x,y));
	}

}
