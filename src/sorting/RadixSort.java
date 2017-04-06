package sorting;

import java.util.Arrays;

public class RadixSort {
	
	private static int getMax(int[] array) {
		int max = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		
		return max;
	}
	
	private static void countSort(int[] array, int n, int exp) {
		int[] output = new int[n];
		int i;
		int [] count = new int[10]; // Buckets
		
		Arrays.fill(count, 0);
		
		 // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(array[i]/exp)%10]++;
        
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        
     // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[(array[i]/exp)%10] - 1] = array[i];
            count[(array[i]/exp)%10]--;
        }
        
        for (i = 0; i < n; i++)
            array[i] = output[i];
	}
	
	
	
	public static void radixsort(int[] array, int n) {
		int m = getMax(array);
		
		for(int exp = 1; m/exp > 0; exp *= 10) {
			countSort(array, n, exp);
		}
	}
	
	public static void print(int[] array, int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);

	}

}
