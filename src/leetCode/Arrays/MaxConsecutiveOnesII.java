package leetCode.Arrays;
import java.util.*;

/* Link: https://leetcode.com/problems/max-consecutive-ones-ii/#/description */

public class MaxConsecutiveOnesII {
	
	static ArrayList<Integer> queue;
	static int max = Integer.MIN_VALUE;
	
	public static void locateZeros(int[] nums) {
		queue = new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				queue.add(i);
			}
		}
				
	}
	
	public static int findMaxConsecutiveOnes(int[] nums, int pos) {
        
        int count = 0;
        int mx = Integer.MIN_VALUE;
        
        nums[pos] = 1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
                
                if(count > mx) {
                    mx = count;
                }
                
            } else {
                if(count > mx) {
                    mx = count;
                }
                count = 0;
            }
        }
        
        nums[pos] = 0;
        return mx;
        
    }
	
	public static int maxOnes(int [] nums) {
		
		// Locate zeros
		locateZeros(nums);
		
		for(int i = 0; i < queue.size(); i++) {
			int count = findMaxConsecutiveOnes(nums, queue.get(i));
			if(count > max) {
				max = count;
			}
		}
		
		if(max == Integer.MIN_VALUE) {
			return 0;
		} else {
			return max;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {0, 1, 1, 0, 1, 1};
		int [] nums2 = {0, 0};
		
		System.out.println("Max ones -> " + maxOnes(nums2));
	}

}
