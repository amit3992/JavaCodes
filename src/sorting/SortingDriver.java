package sorting;
import java.util.*;

public class SortingDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] theArray = new int[10];
		theArray = Util.generateRandomArray();
		System.out.println("Unsorted Array");
		Util.showArray(theArray);
		InsertionSort iSort = new InsertionSort(theArray, true);

	}

}
