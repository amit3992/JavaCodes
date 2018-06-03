package com.math.permutation;
import java.util.*;

/* Heap's algorithm 'https://en.wikipedia.org/wiki/Heap%27s_algorithm#cite_note-3' */

public class PermuteArray {
	
	public static void printArray(int [] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void heapPermutation(int[] array, int size, int n) {
		if(size == 1) {
			printArray(array);
		}
		
		for(int i = 0; i < size; i++) {
			
			heapPermutation(array, size - 1, n);
			
			/* If size is odd, swap first and last element */
			if (size % 2 == 1) {
				int temp = array[0];
				array[0] = array[size - 1];
				array[size - 1] = temp;
			}
			
			/* If size is even, swap first and i'th element */
			if (size % 2 == 0) {
				int temp = array[i];
				array[i] = array[size - 1];
				array[size - 1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {1, 1, 2};
		heapPermutation(array, array.length, array.length);

	}

}
