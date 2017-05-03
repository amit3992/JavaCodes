package leetCode;
import java.util.*;


public class QuickSelect {
	
	public static int quickSelect(int[] array, int key) {
		return quickSelectUtil(array, 0, array.length-1, key);
	}
	
	private static int quickSelectUtil(int[] array, int left, int right, int key) {
		if(left == right) {
			return array[left];
		}
		
		int pivotIndex = randomPivot(left, right);
		pivotIndex = partition(array, left, right, pivotIndex);
		
		if(key == pivotIndex) {
			return array[key];
		}
		else if(key < pivotIndex) {
			return quickSelectUtil(array, left, pivotIndex - 1, key);
		}
		else {
			return quickSelectUtil(array, pivotIndex + 1, right, key);
		}
	}
	
	private static int partition(int[] array, int left, int right, int pivotIndex) {
		
		int pivotValue = array[pivotIndex];
		swap(array,pivotIndex, right); // Move pivot to the end
		int storeIndex = left;
		
		for(int i = left; i < right; i++) {
			if(array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		
		swap(array, right, pivotIndex);
		return storeIndex;
		
	}
	
	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	private static int randomPivot(int left, int right) {
		return left + (int) Math.floor(Math.random() * (right - left + 1));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
		
		System.out.println(quickSelect(array, 1));
		

	}

}
