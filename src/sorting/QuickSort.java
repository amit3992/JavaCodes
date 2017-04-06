package sorting;
import java.util.*;
import java.io.*;

public class QuickSort {
	
	public void sort(int [] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	private void quickSort(int[] array, int left, int right) {
		if(left >= right) {
			return;
		}
		
		
		int index = partition(array, left, right);
		quickSort(array, left, index - 1);
		quickSort(array, index, right);
	}
	
	private int partition(int[] array, int left, int right) {
	
		int pivot = array[(left + right)/ 2];
		while(left <= right) {
			
			while(array[left] < pivot) {
				left++;
			}
			
			while(array[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	public void printArray(int [] array) {
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {2,5,6,1,3,4,10,8,9,7};
		QuickSort qs = new QuickSort();
		
		qs.sort(array);
		
		System.out.println("Sorted Array: ");
		qs.printArray(array);

	}

}
