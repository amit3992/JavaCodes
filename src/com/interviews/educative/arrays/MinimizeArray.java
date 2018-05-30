package com.interviews.educative.arrays;

public class MinimizeArray {
	
	public static int minimizedValue(int [] A) {
		
		/* Edge case */
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int n = A.length;
        int [] left = new int[A.length];
        int [] right = new int[A.length];
        int min = Integer.MAX_VALUE;
        
        /* Populate left array */
        left[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] + A[i];
        }
        
        /* Populate right array */
        right[n - 1] = A[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + A[i];
        }
        
        /* Minimize */
        for(int i = 0; i < n - 1; i++) {
        	min = Math.min(min, Math.abs(left[i] - right[i + 1]));
        }
        
        return min;
        
     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {3, 1, 2, 4, 3};
		System.out.println("Minimized value -> " + minimizedValue(array));

	}

}
