package leetCode;
import java.util.*;

public class SumInArray {
	
	private static void findSumNaive(int[] thisArray, int sum) {
		
		int len = thisArray.length;
		int low = 0;
		int high = len - 1;
		boolean found = false;
		
		while(low < high) {
			int s = thisArray[low] + thisArray[high];
			
			if(s == sum) {
				found = true;
				displayMessage(thisArray[low], thisArray[high], sum, low, high);			
			}
			
			if (s < sum) {
				low = low + 1;
			}
			
			if (s > sum) {
				high = high - 1;
			}
			
			if(found) {
				low = low + 1;
				high = high - 1;
			}
		}
		
		if(!found) {
			System.out.println("Sum not found!");
		}
		
	}
	
	public static void findSumSmart(int [] thisArray, int sum) {
		
		int len = thisArray.length;
		HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < len; i++) {
			
			int diff = sum - thisArray[i];
			if(comp.containsKey(diff)) {
				displayMessage(thisArray[comp.get(diff)], thisArray[i], sum, comp.get(thisArray[diff]), i);
			}
			else {
				comp.put(thisArray[i], i);
			}
		}
		
	}
	
	public static void displayMessage (int a, int b, int sum, int i, int j) {
		System.out.println("Sum of " + a + " and " + b + " = "+ sum + " at index -> " + "(" + i + "," + j + ")" );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array1 = {1, 2, 3, 4, 4, 5, 6, 9};
		int [] array2 = {10, 100, 130, 1, 4, 67, 77, 52, 11, 60};
		int sum = 8;
		
		//findSumNaive(array1, sum);
		findSumSmart(array2, 71);

	}

}
