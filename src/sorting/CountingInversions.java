package sorting;
import java.util.*;

public class CountingInversions {
	
	int[] array;
	private long swaps = 0; /*Use long for swaps for integer overflow*/
	int [] helper;
	int len;
	
	CountingInversions(int[] array) {
		this.array = array;
		this.helper = new int[array.length];
		this.len = array.length;
	}
	
	public long getInversions() {
		mergeSort(array, helper, 0, len - 1);
		return swaps;
	}
	
	private void mergeSort(int[] array, int[] helper, int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			mergeSort(array, helper, start, mid);
			mergeSort(array, helper, mid+1, end);
			merge(array, helper, start, mid, end);
		}
	}
	
	private void merge(int[] array, int[] helper, int start, int mid, int end) {
		
		/*Step 1: Fill helper array with original array. i = start to i <= end*/ 
		for(int i = start; i <= end; i++) {
			helper[i] = array[i];
		}
		
		int curr = start;
		int left = start;
		int right = mid;
		
		/* Loop through helper[] left and right halves and continuously copy smaller element to array[] */
		while(left <= mid && right <= end) {
			
			if(helper[left] <= helper[right]) {
				array[curr] = helper[left];
				curr++;
				left++;
			} else {
				swaps += mid + 1 - left;
				array[curr] = helper[right];
				curr++;
				right++;
			}
		}
		
		/* Copy remaining elements of left half. Right half elements are already in proper place */
		while(left <= mid) {
			array[curr] = helper[left];
			curr++;
			left++;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases > 0) {
			int n = sc.nextInt();
			int[] array = new int[n];
			for(int i = 0; i < n; i++) {
				array[i] = sc.nextInt();
			}
			
			CountingInversions cs = new CountingInversions(array);
			System.out.println(cs.getInversions());
			testCases--;
		}
		
		sc.close();
		
	}

}
