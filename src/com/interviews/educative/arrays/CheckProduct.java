package com.interviews.educative.arrays;

public class CheckProduct {
	
	public static int[] findProduct(int[] arr){
		
		/* Null check */
		if(arr == null || arr.length == 0) {
			return arr;
		}
		
		int [] left = new int[arr.length];
		int [] right = new int[arr.length];
		
		/* Build left product array */
		left[0] = 1;
		int val = left[0];
		
		for(int i = 1; i < arr.length; i++) {
			left[i] = val * arr[i-1];
			val = left[i];
		}
		
		/* Build right array */
		val = 1;
		right[arr.length - 1] = val;
		
		for(int i = arr.length - 2; i >= 0; i--) {
			right[i] = val * arr[i + 1];
			val = right[i];
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = left[i] * right[i];
		}
		
		System.out.println(left);
		System.out.println(right);
		return arr;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {1,2,3,4};
		int [] result = findProduct(array);

	}

}
