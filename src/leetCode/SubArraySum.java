package leetCode;
import java.util.*;

public class SubArraySum {
	
	public static void subArraySum(int[] arr, int n, int sum) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int cur_sum = 0;
		
		for(int i = 0; i < n; i++) {
			
			cur_sum = cur_sum + arr[i];
			
			if(cur_sum == sum) {
				System.out.println("SUM -> " + sum + " found between 0 and " + i);
				return;
			}
			
			if(map.containsKey(cur_sum - sum)) {
				int x = map.get(cur_sum - sum);
				System.out.println("SUM -> " + sum + " found between " + (x+1) + " and " + i);
				return;
			}
		
			map.put(cur_sum, i);
			
		}
		
		System.out.println("NO SUBARRAY EXISTS FOR SUM -> " + sum);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 4, 20, 3, 10, 5};
		int[] arr2 = {10, 2, -2, -20, 10};
		int[] arr3 = {-10, 0, 2, -2, -20, 10};
		
		
		subArraySum(arr1, arr1.length , 33);
		subArraySum(arr2, arr2.length, -10);
		subArraySum(arr3, arr3.length, -22);
	
	}

	
}
