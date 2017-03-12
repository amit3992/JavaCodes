package DSA;
import java.util.*;

public class TestArray {
	
	public static int[] theArray = new int [50];
	public static int arraySize = 10;
	
	public static void generateArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int)((Math.random()*10)+10);
		}
	}
	
	public static void swapArrayValues(int j, int i) {
		// TODO Auto-generated method stub
		int temp = theArray[j];
		theArray[j] = theArray[i];
		theArray[i] = temp;
	}

	public static void showArray() {
		System.out.println("---------");
		for(int i = 0; i < arraySize; i++) {
			System.out.println("| "+ i +" | "+ theArray[i]+" |");
			System.out.println("----------");
		}
	}
}