package sorting;

public class CSTest {
	
	private static final int MAX = 100000;
	
	public static void sort(int[] array) {
		
		int[] aux = new int[array.length];
		 
	    // find the smallest and the largest value
	    int min = array[0];
	    int max = array[0];
	    for (int i = 1; i < array.length; i++) {
	      if (array[i] < min) {
	        min = array[i];
	      } else if (array[i] > max) {
	        max = array[i];
	      }
	    }
	 
	    // init array of frequencies
	    int[] counts = new int[max - min + 1];
	 
	    // init the frequencies
	    for (int i = 0;  i < array.length; i++) {
	      counts[array[i] - min]++;
	    }
	 
	    // recalculate the array - create the array of occurences
	    counts[0]--;
	    for (int i = 1; i < counts.length; i++) {
	      counts[i] = counts[i] + counts[i-1];
	    }
	 
	    /*
	      Sort the array right to the left
	      1) Look up in the array of occurences the last occurence of the given value
	      2) Place it into the sorted array
	      3) Decrement the index of the last occurence of the given value
	      4) Continue with the previous value of the input array (goto set1), 
	         terminate if all values were already sorted
	    */ 
	    for (int i = array.length - 1; i >= 0; i--) {
	        aux[counts[array[i] - min]--] = array[i];
	    }
		
		System.out.println("SORTED ARRAY");
		for(int i = 0; i < aux.length; i++) {
			System.out.print(aux[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = {5, 6, 7,3 ,2,0,1,10,8,9,4};
		int[] array2 = {1, 6, 7,3 ,2,1,1,10,8,9,4};
		
		sort(array1);
		sort(array2);

	}

}
