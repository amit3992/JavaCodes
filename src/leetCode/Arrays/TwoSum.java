package leetCode.Arrays;
import java.util.*;

/* Link: https://leetcode.com/problems/two-sum/description/ */

public class TwoSum {

	public static int [] getTwoSum(int [] nums, int sum) {
		int [] result = new int[2];
		
		if(nums == null || nums.length == 0) {
			return result;
		}
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(sum - nums[i])) {
				int index = map.get(sum - nums[i]);
				result[1] = i;
				result[0] = index;
				
				return result;
			}
			map.put(nums[i],i);
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums = {2, 7, 11, 15};
		int [] result = getTwoSum(nums, 9);
		
		System.out.println("Sum is available at -> " + result[0] + ", " + result[1]);
	}

}
