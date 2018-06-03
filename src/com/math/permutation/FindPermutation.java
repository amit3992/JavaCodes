package com.math.permutation;
import java.util.*;

public class FindPermutation {
	
	public static void printArray(int [] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	private int getFactorial(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		return n * getFactorial(n - 1);
	}
	
	public void findKPermutation(List<Integer> list, int k, StringBuilder result) {
		
		if(list.isEmpty()) {
			return;
		}
		
		int n = list.size();
		
		int count = getFactorial(n - 1);
		int selected = (k - 1) / count;
		
		result.append(list.get(selected));
		list.remove(selected);
		
		k = k - (count * selected);
		findKPermutation(list, k, result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		FindPermutation fp = new FindPermutation();
		StringBuilder sb = new StringBuilder();
		int k = 4;
		fp.findKPermutation(list, k, sb);
		
		System.out.println(k + "th permutation is : " + sb.toString());
		

	}

}
