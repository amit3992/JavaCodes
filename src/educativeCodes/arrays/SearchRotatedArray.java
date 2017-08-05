package educativeCodes.arrays;
import java.util.*;

public class SearchRotatedArray {
	
	public static int binary_search(int[] arr, int key, int st, int end) {
		  
			  if (st > end) {
			    return -1;
			  }

			  int mid = st + (end-st)/2;

			  if (arr[mid] == key) {
			    return mid;
			  }

			  if (arr[st] < arr[mid] && key < arr[mid] && key >= arr[st]) {
			    return binary_search(arr, st, mid-1, key);
			  }
			  else if (arr[mid] < arr[end] && key > arr[mid] && key <= arr[end]) {
			    return binary_search(arr, mid+1, end, key);
			  }
			  else if (arr[st] > arr[mid]) {
			    return binary_search(
			                arr, st, mid-1, key);
			  }
			  else if (arr[end] < arr[mid]) {
			    return binary_search(
			                arr, mid+1, end, key);
			  }

			  return -1;


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162};
		int len = array.length;
		int ans = binary_search(array, 200, 0, len-1);
		
		System.out.println("Answer: " + ans);

	}

}
