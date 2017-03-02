package code;
import java.util.*;


public class leftCircularShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5};
		
		Scanner sc = new Scanner(System.in);
		int shift = sc.nextInt();
		
		int [] shiftedArray = new int[array.length];
		
		shiftedArray = leftCircularShiftArray(array,shift);
		
		for(int i = 0; i < shiftedArray.length; i++) {
			System.out.print(shiftedArray[i] + " ");
		}

	}

	private static int[] leftCircularShiftArray(int[] theArray, int shift) {
		// TODO Auto-generated method stub
		
		int [] shiftArray = new int[shift]; 
		for(int i = 0; i < shift; i++) {
			shiftArray[i] = theArray[i];
		}
		
		// Copy original array by shift positions
		System.arraycopy(theArray, shift, theArray, 0, theArray.length - shift);
		
		// Copy contents from shiftArray to original array
		for(int x = 0; x < shift; x++) {
			theArray[(theArray.length - shift) + x] = shiftArray[x];
		}
		
		return theArray;
	}

}
