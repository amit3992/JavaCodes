package leetCode.binarySearch;
import java.util.*;


public class SquareRoot {
	
	public static int sqrt(int x) {
		if(x == 0) {
			return 0;
		} else if(x == 1) {
			return 1;
		}
		
		int left = 0;
		int right = x;
		int mid = 0;
		int ans = 0;
		
		while(left <= right) {
			mid = left + (right-left)/2;
			
			if(mid <= x/mid) {
				left = mid + 1;
				ans = mid;
			} else {
				right = mid - 1;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		System.out.println("Square root -> " + sqrt(123));
	}

}
