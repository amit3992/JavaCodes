package leetCode;
import java.util.*;

public class FindKthLargest {
	
	private static int getKthLargest(int[] array, int k) {
		if(array == null || array.length == 0)
			return Integer.MAX_VALUE;
		else
			return helper(array, 0, array.length - 1, array.length - k);
	}

	private static int helper(int[] array, int start, int end, int k) {
		if(start > end)
			return Integer.MAX_VALUE;
		
		int pivot = array[end];
		int left = start;
		
		for(int i = start; i < end; i++) {
			if(array[i] < pivot) {
				swap(array, left, i);
				left++;
			}
		}
		
		swap(array, left, end);
		
		if(left == k) {
			return array[left];
		} else if(left < k) {
			return helper(array, left + 1, end, k);
		} else {
			return helper(array, start, left - 1, k);
		}
	}
	
	private static void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}

	public static void main(String[] args) {
		int[] array = {3,2,1,5,6,4};
		int k = 2;
		
		System.out.println("Kth largest element -> " + getKthLargest(array, k));

	}

	

}
