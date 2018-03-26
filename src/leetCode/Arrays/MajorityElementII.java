package leetCode.Arrays;
import java.util.*;
// Using Boyer-Moore majority algorithm -> http://goo.gl/64Nams

public class MajorityElementII {

	public static List<Integer> getMajority(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> result = new ArrayList<Integer>();
		
		int candidate1 = nums[0];
		int candidate2 = nums[0];
		int count1 = 0;
		int count2 = 0;
		int len = nums.length;
		
		// 1st Pass
		for(int i = 0; i < len; i++) {
			if(nums[i] == candidate1) {
				count1++;
			} else if(nums[i] == candidate2) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = nums[i];
				count1 = 1;
			} else if(count2 == 0) {
				candidate2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		
		count1 = 0;
		count2 = 0;
		
		// 2nd Pass
		for(int i = 0; i < len; i++) {
			if(nums[i] == candidate1) {
				count1++;
			}
			if(nums[i] == candidate2) {
				count2++;
			}
		}
		
		// Check
		if(count1 > len/3) {
			result.add(candidate1);
		}
		if(count2 > len/3) {
			result.add(candidate2);
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] array = {3,3,3,2,4,4,4,4,4,3};
		int [] array2 = {1,2,5,9,5,9,5,5,5};
		System.out.println(getMajority(array).toString());

	}

}
