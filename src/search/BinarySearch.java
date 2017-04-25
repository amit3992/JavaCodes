package search;
import java.util.*;

public class BinarySearch {
	
	public static void binarySearchBasic(int[] arr, int key, int l, int r) {
		
		/*
		 * Basic binary search. Returns the rightmost index of the key if duplicate keys are present.
		 * Running time - O(logN)
		 */
		int mid = 0;
		
		while(r - l > 1) {
			
			mid = l + (r - l)/2;
			if(arr[mid] <= key) {
				l = mid;
			}
			else {
				r = mid;
			}
		}
		
		if(arr[l] == key) {
			System.out.println("FOUND! Key: " + key + " found at position -> " + l);
		}
		else {
			System.out.println("KEY NOT FOUND!");
		}
		
		
	}
	
	private static int binarySearchFloor(int[] array, int key, int l, int r) {
		/*
		 * Returns the floor value of the key if key is not present in the array
		 */
		
		int mid;
		while(r - l > 1) {
			
			mid = l + (r - l)/2;
			
			if(array[mid] <= key) {
				l = mid;
			}
			else 
				r = mid;
		}
		
		return array[l];
	}
	
	public static void binarySearchFloor(int[] array, int key) {
		
		if(key < array[0]) {
			System.out.println("KEY NOT FOUND!");
		}
		else {
			int n = binarySearchFloor(array, key, 0, array.length);
			System.out.println("FOUND! -> " + n);
		}
	}
	
	public static void binarySearchDuplicate(int[] array, int key) {
		
		/* -> Method which returns number of duplicates in an array
		   -> Method which also returns range of duplicates
		 * 
		 */
		int l = 0;
		int r = array.length;
		
		int leftPosition = getLeftPosition(array, key, l, r);
		int rightPosition = getRightPosition(array, key, l, r);
		
		System.out.println("Key: " + key + " exists in range (" + leftPosition + ", " + rightPosition + ")");
		
		if(array[leftPosition] == key && array[rightPosition] == key) {
			int diff = rightPosition - leftPosition + 1;
			System.out.println("Number of occurences -> " + diff);
		}
		else {
			System.out.println("Number of occurences -> " + 0);
		}
		
		
	}
	
	private static int getLeftPosition(int[] array, int key, int l, int r) {
		int m;
		
		while(r - l > 1) {
			m = l + (r - l)/2;
			
			if(array[m] >= key) {
				r = m;
			}
			else {
				l = m;
			}
		}
		
		return r;
	}
	
	private static int getRightPosition(int[] array, int key, int l, int r) {
		int m;
		
		while(r - l > 1) {
			m = l + (r - l)/2;
			
			if(array[m] <= key) {
				l = m;
			}
			else {
				r = m;
			}
		}
		
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {2,3,4,5,5,5,5,6,7,8,11,14,16};
		int [] array2 = {5,7,7,8,8,10};
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		int low = 0;
		int high = array.length;
		//binarySearchBasic(array, key, low, high);
		//binarySearchFloor(array, key);
		binarySearchDuplicate(array2, key);
	}

	

	

}
