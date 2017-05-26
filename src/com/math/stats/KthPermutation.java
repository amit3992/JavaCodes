package com.math.stats;
import java.util.*;

public class KthPermutation {
	
	public static int factorial(int n) {
		
		if(n == 0) {
			return 1;
		}
		
		int[] val = new int[n+1];
		val[0] = 1;
		
		for(int i = 1; i <= n; i++) {
			val[i] = i * val[i-1];
		}
		
		return val[n];
	}
	
	public static void findKthPermutation(List<Character> v, int k, StringBuilder result) {
		
		if(v.isEmpty()) {
			return;
		}
		
		int n = v.size();
		
		int count = factorial(n-1);
		int selected = (k - 1)/count;
		
		result.append(v.get(selected));
		v.remove(selected);
		
		k = k - (count * selected);
		
		findKthPermutation(v, k, result);
	}

	public static void main(String[] args) {
		
		
		List<Character> list = new ArrayList<Character>();
		
		list.add('1');
		list.add('2');
		list.add('3');
		list.add('4');
		
		StringBuilder sb = new StringBuilder();
		findKthPermutation(list, 8, sb);

		System.out.println("Result -> " + sb.toString());

	}

}
