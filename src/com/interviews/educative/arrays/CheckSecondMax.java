package com.interviews.educative.arrays;
import java.util.*;

class CheckSecondMax {
    public static int findSecondMaximum(int[] arr){

        /* Null checks */
        if(arr == null || arr.length == 0) {
            return -1;
        }          

        /* Find max */
        int max = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        /* Find Max 2 */
        int max2 = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max2 && max2 < max) {
                max2 = arr[i];
            }
        }

        return max2;

    }
}