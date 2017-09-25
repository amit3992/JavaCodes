package algorithms.backtracking;
import java.util.*;

public class KSumSubsets {
	
	private static boolean checkBit(int num, int k) {
		
		return (num & 1 << k) != 0;
	}
	
	public static void kSumSubSets(int[] grid, int sum, HashSet<ArrayList<Integer>> sets) {
		
		if(grid == null || grid.length == 0) {
			return;
		}
		
		int size = grid.length;
		int power_size = (int) Math.pow(2, new Double(size));
		
		
		
		for(int count = 0; count < power_size; count++) {
			int target = 0;
			ArrayList<Integer> set = new ArrayList<Integer>();
			for(int j = 0; j < size; j++) {
				
				if(checkBit(count, j)) {
					target += grid[j];
					
					if(target > sum) {
						break;
					}
					
					set.add(grid[j]);
				}
				
				if(target == sum) {
					sets.add(set);
				}
				
			}
		}
	}

	public static void main(String[] args) {
		
		int[] grid = {1, 3, 5, 21, 19, 7, 2, 5};
		int target = 10;
		
		HashSet<ArrayList<Integer>> sets = new HashSet<ArrayList<Integer>>();
		kSumSubSets(grid, 10, sets);
		
		for(ArrayList<Integer> s: sets) {
			System.out.println(s.toString());
		}
		
	}

}
