package sorting;

public class MergeSort {
	
	static int[] array;
	static int [] helper;
	static int[] sortedArray;
	
	MergeSort(int [] array) {
		this.array = array;
	}
	
	public static void doMergeSort() {
		
		int size = array.length - 1;
		helper = new int [array.length];
		mergeSort(0,size);
	}
	
	private static void mergeSort(int leftStart, int rightEnd) {
		
		if(leftStart < rightEnd) {
			int middle = leftStart + (rightEnd - leftStart)/2;
			mergeSort(leftStart, middle);
			mergeSort(middle + 1, rightEnd);
			
			merge(leftStart, middle, rightEnd);
		}
	}

	private static void merge(int leftStart, int middle, int rightEnd) {
		
		for(int i = leftStart; i <=  rightEnd; i++) {
			helper[i] = array[i];
		}
		
		int left = leftStart;
		int right = middle + 1;
		int index = leftStart;
		
		// Copy the smallest values from either the left or the right side back
        // to the original array
        while (left <= middle && right <= rightEnd) {
                if (helper[left] <= helper[right]) {
                        array[index] = helper[left];
                        left++;
                } else {
                        array[index] = helper[right];
                        right++;
                }
                index++;
        }
        
     // Copy the rest of the left side of the array into the target array
        while (left <= middle) {
                array[index] = helper[left];
                index++;
                left++;
        }
		
	}
	
	public int[] returnSortedArray() {
		sortedArray = array;
		return sortedArray;
	}

	public static void main(String[] args) {
		
		int [] arr = {1,4,5,6,8,10,3,2,9,7};
		array = arr;
		
		long startTime = System.currentTimeMillis();
		System.out.println("UNSORTED ARRAY");
		Util.showArray(array);
		doMergeSort();
		System.out.println("SORTED ARRAY");
		long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Mergesort -> " + elapsedTime);
		Util.showArray(array);

	}

}
