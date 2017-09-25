package dynamicProgramming;
import java.util.*;

public class MaxProductSubarray {

	public static int min(int x, int y) {
		return Math.min(x, y);
	}
	
	public static int max(int x, int y) {
		return Math.max(x, y);
	}
	
	public static int maxProductSubarray(int[] arr) {

		
		int n = arr.length;
        // max positive product ending at the current position
        int max_ending_here = 1;
 
        // min negative product ending at the current position
        int min_ending_here = 1;
 
        // Initialize overall max product
        int max_so_far = 1;
 
        /* Traverse through the array. Following
           values are maintained after the ith iteration:
           max_ending_here is always 1 or some positive product
                           ending with arr[i]
           min_ending_here is always 1 or some negative product
                           ending with arr[i] */
        for (int i = 0; i < n; i++)
        {
            /* If this element is positive, update max_ending_here.
                Update min_ending_here only if min_ending_here is
                negative */
            if (arr[i] > 0)
            {
                max_ending_here = max_ending_here*arr[i];
                min_ending_here = min (min_ending_here * arr[i], 1);
            }
 
            /* If this element is 0, then the maximum product cannot
               end here, make both max_ending_here and min_ending
              _here 0
               Assumption: Output is alway greater than or equal to 1. */
            else if (arr[i] == 0)
            {
                max_ending_here = 1;
                min_ending_here = 1;
            }
 
            /* If element is negative. This is tricky
               max_ending_here can either be 1 or positive.
               min_ending_here can either be 1 or negative.
               next min_ending_here will always be prev.
               max_ending_here * arr[i]
               next max_ending_here will be 1 if prev
               min_ending_here is 1, otherwise
               next max_ending_here will be 
                           prev min_ending_here * arr[i] */
            else
            {
                int temp = max_ending_here;
                max_ending_here = max (min_ending_here * arr[i], 1);
                min_ending_here = temp * arr[i];
            }
 
            // update max_so_far, if needed
            if (max_so_far <  max_ending_here)
                max_so_far  =  max_ending_here;
        }
 
        return max_so_far;
	}
	public static void main(String[] args) {
		
		int[] array1 = {1, -2, -3, 0, 7, -8, -2};
		int [] array2 = {-1, -3, -10, 0, 60};
		int [] array3 = {-2, -3, 0, -2, -40};
		
		System.out.println("Max product subarray -> " + maxProductSubarray(array1));

	}

}
