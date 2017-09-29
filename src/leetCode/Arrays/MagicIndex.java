package leetCode.Arrays;
import java.util.*;

public class MagicIndex {
	
	public static int magicIndex(int[] array) {
		
		if(array == null) {
			return -1;
		}
		
		if(array.length == 0) {
			return -1;
		}
		
		int low = 0;
		int high = array.length - 1;
		
		return magicIndexHelper(array, low, high);
		
		
	}
	
	private static int magicIndexHelper(int[] array, int low, int high) {
		
		if(low > high) {
			return -1;
		}
		
		int mid = low + (high - low)/2;
		
		if(array[mid] == mid) {
			return mid;
		}
		
		int midIndex = mid;
		int midValue = array[mid];
		
		/* Search left */
		int lowIndex = Math.min(midIndex - 1, midValue);
		int lIndex = magicIndexHelper(array, low, lowIndex);
		
		if(lIndex >= 0) {
			return lIndex;
		}
		
		/* Search right */
		int highIndex = Math.max(midIndex + 1, midValue);
		int hIndex = magicIndexHelper(array, highIndex, high);
		if(hIndex >= 0) {
			return hIndex;
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {-10, -5, 2,2, 2, 3, 4, 7, 9, 12, 13};
		int[] array2 = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		int index = magicIndex(array2);
		
		System.out.println("Magic index is: " + index);
	}

}
