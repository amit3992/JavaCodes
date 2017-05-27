package leetCode.Arrays;
import java.util.*;

public class LowHighIndex {
	
	public static int getLowIndex(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = low + (high - low)/2;
			
			int mid_elem = array[mid];
			
			if(mid_elem < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		if(low != -1 && array[low] == key) {
			return low;
		} else {
			return -1;
		}
	}
	
	public static int getHighIndex(int[] array, int key) {
		int low = 0;
		int high = array.length - 1;
		int mid = 0;
		
		while(low <= high) {
			mid = low + (high - low)/2;
			
			int mid_elem = array[mid];
			
			if(mid_elem <= key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		if(high != -1 && array[high] == key) {
			return high;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		int[] array = {1, 2, 5, 5, 5, 5, 5, 5, 5, 10, 10, 11};
		int key = 5;
		System.out.println("low index -> " + getLowIndex(array, key));
		System.out.println("high index -> " + getHighIndex(array, key));

	}

}
