package DSA;
import java.util.*;
import DSA.TestArray;

public class BubbleSort extends TestArray {
	
	public static void doBubbleSort() {
		
		for(int i = arraySize-1; i > 0; i--) {
			
			for(int j = 0; j < i; j++) {
				
				if(theArray[j] > theArray[j+1]) {
					swapArrayValues(j+1,j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestArray array = new TestArray();
		generateArray();
		showArray();
		doBubbleSort();
		System.out.println(" ------------------ AFTER BUBBLE SORT ----------------");
		showArray();

	}

}
