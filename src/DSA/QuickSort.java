package DSA;
import java.util.*;

public class QuickSort {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arraySize = 10;
		int [] array = new int[arraySize];
		
		for(int i = 0; i < arraySize; i++) {
			array[i] = (int)((Math.random()*10)+10);
		}
		
		System.out.println("Original array: " + Arrays.toString(array) );
		int low = 0;
		int high = arraySize - 1;
		
		doQuickSort(array, low, high);
		System.out.println();
		System.out.println("Sorted array: " + Arrays.toString(array));

	}

	private static void doQuickSort(int[] theArray, int low, int high) {
		// TODO Auto-generated method stub
		if(theArray == null || theArray.length == 0)
			return;
		
		if(low >= high)
			return;
		
		// Pick the pivot
		int middle = low + (high - low)/2;
		int pivot = theArray[middle];
		
		// Make all left < pivot & right > pivot
		int i = low;
		int j = high;
		
		while(i <= j) {
			while(theArray[i] < pivot) {
				i++;
			}
			while (theArray[j] > pivot) {
				j--;
			}
			
			if(i <= j) {
				// Swap
				int temp = theArray[i];
				theArray[i] = theArray[j];
				theArray[j] = temp;
				i++;
				j--;
				
			}
		}
		
		// Recursively sort two sub parts
		if(low < j)
			doQuickSort(theArray, low, j);
		
		if(high > i)
			doQuickSort(theArray, i, high);
		
	}
	

}
