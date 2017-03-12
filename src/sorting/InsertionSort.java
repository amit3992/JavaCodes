package sorting;
import java.util.*;

public class InsertionSort {
	
	public boolean isAscending = true;
	public int[] theArray;
	
	InsertionSort(int[] theArray, boolean isAscending) {
		this.theArray = theArray;
		this.isAscending = isAscending;
		doInsertionSort(this.theArray, isAscending);
		Util.showArray(this.theArray);
	}
	
	private void doInsertionSort(int[] arr, boolean isAsc) {
		if(isAsc) {
			
			int arraySize = arr.length;
			for(int i = 1; i < arraySize; i++) {
				int j = i;

				int toInsert = arr[i];

				while((j > 0) && (arr[j-1] > toInsert)) {

					arr[j] = arr[j-1];
					j--;
				}
				arr[j] = toInsert;

			}
			
		}
		else if (!isAsc) {
			
			int arraySize = arr.length;
			for(int i = 1; i < arraySize; i++) {
				int j = i;

				int toInsert = arr[i];

				while((j > 0) && (arr[j-1] < toInsert)) {

					arr[j] = arr[j-1];
					j--;
				}
				arr[j] = toInsert;

			}
		}
	}
	
	

}
