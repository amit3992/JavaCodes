package leetCode;
import java.util.*;


public class MaxSubarraySum {
	
	public static int getMaxSum(int[] array) {
		
		int max_end_here = array[0];
		int max_sum = array[0];
		
		for(int i = 0; i < array.length; i++) {
			max_end_here = Math.max(i, max_end_here + i);
			max_sum = Math.max(max_sum, max_end_here);
		}
		
		return max_sum;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {7, 1, 5, 3, 6, 4};
		int[] arr2 = {-2, 1, -3, 4, -1, 2, 1 ,-5, 4};
		
		System.out.println("Max sub array sum -> " + getMaxSum(arr1));
		System.out.println("Max sub array sum -> " + getMaxSum(arr2));
	}

}
