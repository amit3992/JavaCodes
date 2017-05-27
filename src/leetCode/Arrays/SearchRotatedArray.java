package leetCode.Arrays;

public class SearchRotatedArray {
	
	public static int searchKey(int[] array, int start, int end, int key) {
		
		int mid = 0;
		
		while(start <= end) {
			mid = start + (end - start)/2;
			
			if(array[mid] == key) {
				return mid;
			} else if(array[start] < array[mid] && key < array[mid] && key >= array[start]) {
				end = mid - 1;
			} else if(array[mid] < array[end] && key > array[mid] && key <= array[end]) {
				start = mid + 1;
			} else if(array[start] > array[mid]) {
				end = mid - 1;
			} else if(array[mid] > array[end]) {
				start = mid + 1;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		
		int[] array = {176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162};
		int n = array.length - 1;
		int key = 200;
		
		System.out.println("Key in array -> " + searchKey(array, 0, n, key));
	}

}
