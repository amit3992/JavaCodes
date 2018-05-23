package com.interviews.educative.arrays;
import java.util.*;

public class CheckSum {
	
	public static int[] findSum(int[] arr, int value){
		
		if(arr == null || arr.length == 0) {
			return arr;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int [] result = new int[2];
		
		for(int i = 0; i < arr.length; i++) {
			result[0] = arr[i];
			if(map.containsKey(value - arr[i])) {
				int j = map.get(value - arr[i]);
				result[0] = i < j ? i : j;
				result[1] = i < j ? j : i;
			} else {
				map.put(arr[i], i);
			}
		}
		
	    return result;
	} 

}
