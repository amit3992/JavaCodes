package leetCode;
import java.util.*;
import java.util.Map.Entry;

public class NextGreaterElement {
	
	int[] array;
	
	NextGreaterElement(int[] array) {
		this.array = array;
	}
	
	public int getLargestElement(int[] array, int index, int num) {
		int largest = -1;
		for(int i = index+1; i < array.length; i++) {
			if(array[i] > num) {
				largest = array[i];
				return largest;
			}
		}
		
		return largest;
	}
	
	public void getNGE() {
		for(int i = 0; i < this.array.length; i++) {
			
			int nge = getLargestElement(this.array, i, this.array[i]);
			print(this.array[i], nge);
		}
		
	}
	
	public void print(int a, int b) {
		System.out.println(a + " -- " + b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] theArray = {4,5,2,25};
		NextGreaterElement nge = new NextGreaterElement(theArray);
		nge.getNGE();
		

	}

}
