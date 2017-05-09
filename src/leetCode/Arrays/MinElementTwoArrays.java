package leetCode.Arrays;
import java.util.*;

public class MinElementTwoArrays {
	
	public static int minElement(int[] a, int[] b) {
		
		int val = Integer.MAX_VALUE;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < a.length; i++) {
			set.add(a[i]);
		}
		
		for(int i = 0; i < b.length; i++) {
			if(set.contains(b[i])) {
				if(val > b[i]) {
					val = b[i];
				}
			}
		}
		
		return val;
	}

	public static void main(String[] args) {
		int [] a = {0, -90, 45, 10, 4};
		int [] b = {4, 8, 90, 45};
		
		System.out.println("Min. common element -> " + minElement(a, b));

	}

}
