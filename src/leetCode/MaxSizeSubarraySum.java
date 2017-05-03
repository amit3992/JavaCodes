package leetCode;
import java.util.*;

/*Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
*/

public class MaxSizeSubarraySum {
	
	public static int maxSum(int[] nums, int k) {
		int sum = 0;
		int max = 0;
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			if(sum == k) {
				max = i + 1;
			} else if(map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1, -1, 5, -2, 3};
		int k = 3;
		System.out.println("Max subarray with sum " + k + " -> " + maxSum(array, 3));
		

	}

}
