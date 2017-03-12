// Test out a method which returns an array
package School;
import java.io.*;

import java.io.InputStreamReader;

public class ReturnArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(line.readLine());
		
		int [] theArray = new int[n];
		int i = 0;
		while(i < n) {
			theArray[i] = Integer.parseInt(line.readLine());
			i++;
		}
		
		theArray = getSortedArray(theArray);
		
		for(int j = 0; j < theArray.length; j++) {
			System.out.println("| "+ j + " | "+ theArray[j] + " | ");
		}
		

	}

	private static int[] getSortedArray(int[] theArray) {
		// TODO Auto-generated method stub
		int arraySize = theArray.length;
		
		for(int i = arraySize - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(theArray[j] > theArray[j+1]) {
					swapArrayValues(j+1,j, theArray);
				}
			}
		}
		return theArray;
	}

	private static void swapArrayValues(int i, int j, int[] arr) {
		// TODO Auto-generated method stub
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
		
	}

}
