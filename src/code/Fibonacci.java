/*Write a program called Fibonacci to display the first 20 Fibonacci numbers F(n), where F(n)=F(n–1)+F(n–2) and F(1)=F(2)=1. Also compute their average. The output shall look like:
The first 20 Fibonacci numbers are:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765
The average is 885.5
 * 
 * 
 */

package code;
import java.util.*;
import java.io.*;

public class Fibonacci {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(getFibonacci(n));
	}

	private static String getFibonacci(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> fiboList = new ArrayList<Integer>();
		int fn1 = 0;
		int fn2 = 1;
		int i = 0, sum = 0;
		fiboList.add(fn1);
		fiboList.add(fn2);
		
		while(i <= n) {
			sum = fn1+fn2;
			fn1 = fn2;
			fn2 = sum;
			fiboList.add(sum);
			i++;
		}
		
		return fiboList.toString();
	}

}
