package leetCode;

import java.util.Arrays;

// Leetcode - #442 Find all duplicates in array

// Best case -> O(n)?

public class ArrayDuplicates {
	
	public static void getDuplicates(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			int location = Math.abs(array[i])-1;
			if(array[location] < 0) {
				System.out.print(Math.abs(array[i]) + " ");
			}
			else {
				array[location] = -array[location];
			}
		}
		
	}
	
	public static void getDuplicatesNaive(int[] array) {
		int count[] = new int[array.length];
		Arrays.fill(count,0);
		
		for(int i = 0; i < array.length; i++) {
			if(count[array[i]-1] > 0) {
				System.out.print(array[i] + " ");
			}
			count[array[i]-1]++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4,3,2,7,8,2,3,1};
		getDuplicates(array);
		//getDuplicatesNaive(array);

	}

}
