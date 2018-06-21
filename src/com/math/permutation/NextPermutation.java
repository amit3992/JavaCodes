package com.math.permutation;

/*Link : https://www.quora.com/How-would-you-explain-an-algorithm-that-generates-permutations-using-lexicographic-ordering */

public class NextPermutation {
	
	public static void printArray(int [] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public int[] nextPermutation(int[] array) {
        
        if(array == null || array.length == 0) {
			return array;
		}
		
        int n = array.length;
        
        /* If array has just 1 element */
        if(n == 1) {
            return array;
        }
        
		/* Step 1 */
		int largestI = -1;
		for(int i = 0; i < n - 1; i++) {
			if(array[i] < array[i + 1]) {
				largestI = i;
			}
		}
        
        /* If largestI == -1, that means the input array is the last permutation. */
        if(largestI == -1) {
            reverse(array, largestI + 1, n - 1);
            return array;
        }
		
		/* Step 2 */
		int largestJ = -1;
		for(int j = 0; j < n; j++) {
			if(array[largestI] < array[j]) {
				largestJ = j;
			}
		}
		
		/* Step 3*/
        if(largestI != -1 && largestJ != -1) {
            swap(array, largestI, largestJ);
        }
		
		
		/* Step 4 */
        if(largestI != -1 && largestJ != -1) {
           reverse(array, largestI + 1, n - 1); 
        }
		
        return array;
		
    }
    
    /* Util methods */
	public void swap(int [] array, int a, int b) {
		
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public void reverse(int [] array, int start, int end) {
		
		while(start < end) {
			
			int temp = array[end];
			array[end] = array[start];
			array[start] = temp;
			
			++start;
			--end;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] input = {3, 1, 2};
		
		NextPermutation np = new NextPermutation();
		int [] result = np.nextPermutation(input);
		
		System.out.println("Next Permutation: ");
		printArray(result);
	}

}
