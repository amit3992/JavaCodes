package com.interviews.educative.arrays;
import java.util.*;
class CheckFirstUnique{
  public static int findFirstUnique(int[] arr){
        /* NULL CHECK */
        if(arr == null || arr.length == 0) {
            return -1;
        }    

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int index = map.get(arr[i]);
                map.put(arr[i], index + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        /* Traverse the array again and check for unique elements */
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                if(map.get(arr[i]) == 1) {
                    return arr[i];
                }
            }
        }

        return -1;
    }                
}