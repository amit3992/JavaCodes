package leetCode.Arrays;

import java.util.HashMap;

public class MaxSubarraySumK {
	
	public int getSubarrayLen(int[] nums, int k) {
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
	        
			sum = sum + nums[i];
	        
	        if (sum == k) {
	        	max = i + 1;
	        }
	        
	        else if (map.containsKey(sum - k)) {
	        	max = Math.max(max, i - map.get(sum - k));
	        }
	        
	        if (!map.containsKey(sum)){
	        	map.put(sum, i);
	        }
	    }
	    return max;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1, -1, 5, -2, 3}; //k = 3, ans = 4
		
		MaxSubarraySumK msk = new MaxSubarraySumK();
		System.out.println("Max length: " + msk.getSubarrayLen(arr, 3));


	}

}
