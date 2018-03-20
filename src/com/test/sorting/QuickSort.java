package com.test.sorting;

public class QuickSort {
	
	int [] array;
	
	public void quickSort(int [] arr) {
		
		int start = 0;
		int end = arr.length - 1;
		
		doQuickSort(arr, start, end);
		
	}
	
	private void doQuickSort(int [] array, int start, int end) {
		if(start < end) {
			
			int pivot = partition(array, start, end);
			doQuickSort(array, start, pivot - 1);
			doQuickSort(array, pivot + 1, end);
			
			this.array = array;
		}
	}
	
	private void swap(int [] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	private int partition(int [] array, int start, int end) {
		
		int pivot = array[end];
		int pIndex = start;
		
		for(int i = start; i < end; i++) {
			if(array[i] <= pivot) {
				/* Swap i and pIndex */
				int temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				
				
				pIndex++;
			}
		}
		
		/* Swap pIndex and end */
		int temp = array[pIndex];
		array[pIndex] = array[end];
		array[end] = temp;
		
		
		return pIndex;
	}
	
	public int [] getArray() {
		return this.array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,4,5,6,8,10,3,2,9,7};
		
		QuickSort qs = new QuickSort();
		qs.quickSort(arr);
		arr = qs.getArray();
		for(Integer i : arr) {
			System.out.print(i + " ");
		}

	}

}
