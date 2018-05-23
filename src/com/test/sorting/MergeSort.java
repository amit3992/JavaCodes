package com.test.sorting;

public class MergeSort {
	
	int [] array;
	
	public void mergeSort(int [] arr) {
		int n = arr.length;
		
		if(n < 2) {
			return;
		}
		
		int mid = n/2;
		int [] left = new int[mid];
		int [] right = new int[n - mid];
		
		for(int i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		
		for(int j = mid; j < n; j++) {
			right[j - mid] = arr[j];
		}
		
		mergeSort(left);
		mergeSort(right);
		
		merge(left, right, arr);
		
		this.array = arr;
		
	}
	
	private void merge(int [] left, int [] right, int [] array) {
		
		int nL = left.length;
		int nR = right.length;
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < nL && j < nR) {
			
			if(left[i] <= right[j]) {
				array[k] = left[i];
				i++;
				k++;
			} else {
				array[k] = right[j];
				j++;
				k++;
			}
		}
		
		while(i < nL) {
			array[k] = left[i];
			i++;
			k++;
		}
		
		while(j < nR) {
			array[k] = right[j];
			j++;
			k++;
		}
	}
	
	public int [] getArray() {
		return this.array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,4,5,6,8,10,3,2,9,7};
		
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr);
		
		arr = ms.getArray();
		for(Integer i : arr) {
			System.out.print(i + " ");
		}
		
		

	}

}
