package leetCode.Arrays;
import java.util.*;

public class KthLargest {
	
	private static int findKthLargest(int [] nums, int start, int end, int k) {
		
		if(start > end) {
			return Integer.MAX_VALUE;
		}
		
		int pivot = nums[end];
		int loIndex = start;
		
		for(int i = start; i < end; i++) {
			/* Swap all elements less than pivot to left */
			if(nums[i] <= pivot) {
				swap(nums, i, loIndex);
				loIndex++;
			}
		}
		
		/* Swap last element */
		swap(nums, loIndex, end);
		
		if(loIndex == k) {
			return nums[k];
		} else if(loIndex < k) {
			return findKthLargest(nums, loIndex + 1, end, k);
		} else {
			return findKthLargest(nums, start, loIndex - 1, k);
		}
	}
	
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static int findKthLargest(int[] nums, int k) {
		if(nums == null || nums.length == 0){
			return Integer.MAX_VALUE;
		}
		
		int n = nums.length;
		return findKthLargest(nums, 0, n-1, n-k);
	}

	public static void main(String[] args) {
		
		int[] input = {1, 2, 3, 4, 5, 6};
		int ans = findKthLargest(input, 3);
		
		System.out.println("Kth largest -> " + ans);
		

	}

}
