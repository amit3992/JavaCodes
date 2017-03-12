package sorting;
import java.util.*;


public class Util {
	
	private static int[] theArray = new int[50];

	public static int arraySize = 10;

	public static int[] generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int) ((Math.random()*10)+10);
		}
		
		return theArray;
	}

	public static void showArray(int[] arr) {
		System.out.println("----------");
		for(int i = 0; i < arr.length; i++) {
			System.out.println("| "+ i +" | " + arr[i] + " |");
			System.out.println("----------");
		}
	}

}
