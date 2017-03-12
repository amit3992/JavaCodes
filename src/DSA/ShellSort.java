
// SHell sort
package DSA;
import java.util.*;

public class ShellSort {
	
	// Variables
	private int [] theArray;
	private int arraySize;
	
	// Constructor
	public ShellSort(int arraySize) {
		this.arraySize = arraySize;
		
		theArray = new int[arraySize];
		generateRandomArray();
	}
	
	
	// Method
	private void doShellSort() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShellSort theSort = new ShellSort(10);
		
		System.out.println(Arrays.toString(theSort.theArray));
		
		theSort.doShellSort();
		
		System.out.println(Arrays.toString(theSort.theArray));

	}
	
	

	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int)((Math.random()*50)+10);
		}
	}
	
	

}
