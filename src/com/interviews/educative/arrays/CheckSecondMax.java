package com.interviews.educative.arrays;
import java.util.*;

class CheckSecondMax {
    public static int findSecondMaximum(int[] arr){

        /* Null checks */
        if(arr == null || arr.length == 0) {
            return -1;
        }
        
        /* Find max */
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] > max1) {
                max2 = max1;
                max1 = arr[i];
            } else if(arr[i] > max2) {
                max2 = arr[i];
            }
        }

        return max2;

    }
}