// Insertion sort
package DSA;
import java.util.*;

public class InsertionSort {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] theArray = new int[50];
		int arraySize = 10;  
		
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int) ((Math.random()*10)+10);
		}
		
		System.out.println("Unsorted array");
		for(int x = 0; x < arraySize; x++) {
			System.out.println("----------");
			System.out.println("| "+ x + " | "+ theArray[x] + " |");
		}
		
		System.out.println("After insertion sort");
		doInsertionSort(theArray);
		
	}

	private static void doInsertionSort(int[] theArray) {
		// TODO Auto-generated method stub
		
		int arraySize = theArray.length;
		for(int i = 1; i < arraySize; i++) {
			int j = i;

			int toInsert = theArray[i];

			while((j > 0) && (theArray[j-1] > toInsert)) {

				theArray[j] = theArray[j-1];
				j--;
			}
			theArray[j] = toInsert;

			System.out.println("theArray["+i+"] = " + theArray[i] + " theArray["+j+"] = " + theArray[j]+" toInser = "+toInsert);
		}
		
		for(int k = 0; k < theArray.length; k++) {
			System.out.println("----------");
			System.out.println("| "+ k + " | "+ theArray[k] + " |");
		}
		
		
	}

}

