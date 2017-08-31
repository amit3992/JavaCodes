package search;
import java.util.*;

public class UbiquitousBinarySearch {
	
	int [] theArray;
	
	
	UbiquitousBinarySearch(int[] theArray) {
		this.theArray = theArray;
	}
	
	/* Returns index of value or -1 if not found */
	public int basicBinarySearch(int val, int high, int low) {
		
		int mid;
		
		while(high - low > 1) {
			
			mid = low + (high - low)/2;
			
			if(this.theArray[mid] <= val) {
				low = mid;
			} else {
				high = mid;
			}
		}
		
		if(this.theArray[low] == val) {
			return low;
		} else {
			return -1;
		}
		
	}
	
	
	/* Find floor in an array using binary search */
	public int floorBinarySearch(int key, int size) {
		
		if(key < this.theArray[0]) {
			return -1;
		}
	
		return floor(key, size, 0);
	}
	
	private int floor(int key, int high, int low) {
		
		int mid;
		
		while(high - low > 1) {
			
			mid = low + (high - low)/2;
			
			if(this.theArray[mid] <= key) {
				low = mid;
			} else {
				high = mid;
			}
		}
		
		return this.theArray[low];
	}
	
	/* Find number of occurrences or range of elements in a sorted array using BS */
	
	public int countOccurrences(int key, int size) {
		
		if(key < this.theArray[0]) {
			return -1;
		}
		
		int left = getLeftPosition(key, size, 0);
		int right = getRightPosition(key, size, 0);
		
		if(this.theArray[left] == key && this.theArray[right] == key) {
			return (right - left + 1);
		}
		
		return -1;
	}
	
	private int getLeftPosition(int key, int high, int low) {
		
		int mid;
		
		while(high - low > 1) {
			mid = low + (high - low)/2;
			
			if(this.theArray[mid] >= key) {
				high = mid;
			} else {
				low = mid;
			}
		
		}
		
		return high;
	}
	
	private int getRightPosition(int key, int high, int low) {
		
		int mid;
		
		while(high - low > 1) {
			mid = low + (high - low)/2;
			
			if(this.theArray[mid] <= key) {
				low = mid;
			} else {
				high = mid;
			}
			
		}
		
		return low;
	}
	
	public int minElementInRotatedArray(int size) {
		return minElementBS(size - 1, 0);
	}
	
	private int minElementBS(int high, int low) {
		
		int mid;
		
		/* Precondition A[l] < A[r]*/
		if(this.theArray[low] <= this.theArray[high]) {
			return this.theArray[low];
		}
		
		while(low <= high) {
			
			if(low == high) {
				return this.theArray[low];
			}
			
			mid = low + (high - low)/2;
			
			/* Min cannot be in this range. Exclude [m .... high]*/
			if(this.theArray[mid] < this.theArray[high]) {
				high = mid;
			} else {
				low = mid + 1; /* Include [m+1 .... high]*/
			}
		}
		
		return -1;
	}
	
	
	/* Search in rotated sorted array */
	private int searchRotatedSorted(int key, int low, int high) {
		
		if(low > high) {
			return -1;
		}
		
		if(low == high) {
			return low;
		}
		
		int mid;
		mid = low + (high - low)/2;
		
		if(this.theArray[mid] == key) {
			return mid;
		}
		
		/* First section [low....mid] is sorted */
		if(this.theArray[low] <= this.theArray[mid]) {
			
			if(key >= this.theArray[low] && key <= this.theArray[mid]){
				return searchRotatedSorted(key, low, mid - 1);
			}
			
			return searchRotatedSorted(key, mid+1, high);
		}
		
		/* First section [low....mid] is NOT sorted */
		if(key >= this.theArray[mid] && key <= this.theArray[high]) {
			return searchRotatedSorted(key, mid+1, high);
		}
		
		return searchRotatedSorted(key, low, mid - 1);
	}
	
	public int searchRotatedSorted(int target, int size) {
		return searchRotatedSorted(target, 0, size-1);
	}
}
