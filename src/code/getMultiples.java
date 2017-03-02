package code;

import java.util.*;


public class getMultiples {
	
	public static int getAllMultiples(int n, int a) {
		int sum = 0;
		int temp = a;
		
		while(n >= a) {
			sum = sum + n/a;
			a = a*temp;
		}
		return sum;
	}
	 
	public static boolean isMultipleOfTwo(int n) {
		if(n%2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isMultipleOfThree(int n) {
		if(n%3 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isMultipleOfFive(int n) {
		if(n%5 == 0) {
			return true;
		}
		else {
			return false;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int count2 = 0;
		int count5 = 0;
		int count3 = 0;
		
		for(int i = 1; i <= 100; i++) {
			if(isMultipleOfTwo(i)){
				count2++;
			}
			if(isMultipleOfFive(i)){
				count5++;
			}
			if(isMultipleOfThree(i)){
				count3++;
			}
		}
		
		System.out.println("Multiples of 2 from 1 to "+n+": "+count2);
		System.out.println("Multiples of 3 from 1 to "+n+": "+count3);
		System.out.println("Multiples of 5 from 1 to "+n+": "+count5);
		
		
		System.out.println("//// ===================================================================");
		
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
				
		System.out.println("No. of trailing 0s in "+num+"! : "+getAllMultiples(num, 5));

	}

}
