package leetCode;
import java.util.*;

public class Inversions {
	
	public static int countInversions(int[] array) {
		int n = array.length;
		return mergeSort(array, n);
	}
	
	private static int mergeSort(int [] array, int n) {
		int[] temp = new int[n];
		return mergeSortUtil(array, temp, 0, n-1);
	}
	
	private static int mergeSortUtil(int[] array, int[] temp, int left, int right) {
		int mid = 0;
		int invCount = 0;
		
		if(right > left) {
			mid = (right + left)/2;
			
			invCount = mergeSortUtil(array, temp, left, mid);
			invCount += mergeSortUtil(array, temp, mid + 1, right);
			
			// Merge two parts
			invCount += merge(array, temp, left, mid+1, right);
		}
		
		return invCount;
	}
	
	private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
		
		int invCount = 0;
		
		int i = left;
		int j = mid;
		int k = right;
		
		while((i <= mid - 1) && (j <= right)) {
			if(arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				
				invCount = invCount + (mid-i);
			}
		}
		
		while(i <= mid - 1) {
			temp[k++] = arr[i++];
 		}
		
		while(j <= right) {
			temp[k++] = arr[j++];
		}
		
		for(i = left; i <=  right; i++) {
			arr[i] = temp[i];
		}
		
		return invCount;
	}
 	
	

	public static void main(String[] args) {
		//int [] array1 = {1,20,6,4,5};
		int [] array2 = {2,4,1,3,5};
		
		System.out.println("# of inversions -> " + countInversions(array2));
		
		
	}

}
