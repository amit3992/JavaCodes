package leetCode.binarySearch;
import java.util.*;

/*leetcode: https://leetcode.com/problems/search-for-a-range/#/description*/

public class searchRange {
	
	public static int[] searchRange(int[] array, int k) {
		int[] range = new int[2];
		
		range[0] = getLeftIndex(array, k);
		range[1] = getRightIndex(array, k);
		
		return range;
	}
	
	private static int getLeftIndex(int[] array, int k) {
		int low = 0;
		int high = array.length;
		int mid = 0;
		
		while(low < high) {
			mid = (low + high)/2;
			
			if(array[mid] >= k) {
				high = mid;
			} else {
				low = mid;
			}
		}
		
		return high;
	}
	
	private static int getRightIndex(int[] array, int k) {
		int low = 0;
		int high = array.length;
		int mid = 0;
		
		while(low < high) {
			mid = (low + high)/2;
			
			if(array[mid] <= k) {
				low = mid;
			} else {
				high = mid;
			}
		}
		
		return low;
	}

	public static void main(String[] args) {
		int[] array = {5, 7, 7, 8, 8, 10};
		
		int[] range = searchRange(array, 8);
		
		System.out.println("[" + range[0] + "," + range[1] + "]");
		

	}

}
