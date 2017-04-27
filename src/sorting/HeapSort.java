package sorting;

public class HeapSort {
	
	private void sort(int[] array) {
		int n = array.length;
		
		// BuildHeap;
		for(int i = n/2; i >= 0; i--) {
			heapify(array, n, i);
		}
		
		// One by one extract element from the heap
		for(int i = n-1; i >=0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			heapify(array, i, 0);
		}
	}
	
	private void heapify(int[]array, int n, int i) {
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l < n && array[l] > array[largest]) {
			largest = l;
		}
		if(r < n && array[r] > array[largest]) {
			largest = r;
		}
		
		if(largest != i) {
			int swap = array[largest];
			array[largest] = array[i];
			array[i] = swap;
			
			heapify(array, n, largest);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {5, 7, 10, 3, 6, 4, 1, 2, 9, 8};
		
		HeapSort hs = new HeapSort();
		hs.sort(array);
		
		System.out.println("SORTED ARRAY");
		printArray(array);

	}

	private static void printArray(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	

}
