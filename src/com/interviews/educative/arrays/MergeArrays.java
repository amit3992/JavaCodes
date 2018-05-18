package com.interviews.educative.arrays;

public class MergeArrays {
	
		public static int[] mergeArrays(int[] arr1, int[] arr2) {
			
			/* NULL CHECKS */
			int [] result = new int[arr1.length + arr2.length];
			int i = arr1.length - 1;
			int j = arr2.length - 1;
			int k = arr1.length + arr2.length - 1;
			
			while(i >= 0 && j >= 0) {
				
				if(arr1[i] > arr2[j]) {
					result[k--] = arr1[i--];
				} else if(arr1[i] < arr2[j]) {
					result[k--] = arr2[j--];
				} else {
					result[k--] = arr1[i--];
					j--;
				}
			}
			
			while(i >= 0) {
				result[k--] = arr1[i--];
			}
			
			while(j >= 0) {
				result[k--] = arr2[j--];
			}
			
			return result;
		}
		
		public static void main(String[] args) {
			
			int [] arr1 = {1, 3, 4, 5};
			int [] arr2 = {2, 6, 7, 8};
			int [] result = mergeArrays(arr1, arr2);		
		}

}
