// Fibonacci huge. Pisano period

package coursera.week2;

import java.util.ArrayList;

public class fibonacci_huge {
	
	private static void getFibonacci(int n) {
		// TODO Auto-generated method stub
		ArrayList<Long> fiboList = new ArrayList<Long>();
		long fn1 = 0;
		long fn2 = 1;
		long i = 0, sum = 0;
		fiboList.add(fn1);
		fiboList.add(fn2);
		
		while(i <= n) {
			sum = fn1+fn2;
			fn1 = fn2;
			fn2 = sum;
			//sum = sum % 239;
			fiboList.add(sum);
			i++;
		}
		
		System.out.println(fiboList.toString());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getFibonacci(239);
	}

}
