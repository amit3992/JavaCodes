package leetCode.binarySearch;
import java.util.*;

/*Geeksforgeeks: https://leetcode.com/problems/search-insert-position/#/description*/

public class SearchInsert {
	
	public static int searchInsert(int[] array, int k) {
		
		int len = array.length;
		if(k < array[0]) {
			return 0;
		} else if (k > array[len - 1]) {
			return len;
		}
		
		int start = 0;
		int end = len;
		int mid = 0;
		
		while(start < end) {
			mid = (start + end)/2;
			
			if(array[mid] == k) {
				return mid;
			} else if(k > array[mid]) {
				start = mid+1;
			} else {
				end = mid;
			}
		}
		
		return start;
	}

	public static void main(String[] args) {
		int[] array = {1,3,5,6,7};
		
		System.out.println(searchInsert(array, 5));
		System.out.println(searchInsert(array, 2));
		System.out.println(searchInsert(array, 8));
		System.out.println(searchInsert(array, 0));

	}

}
