package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	
	public ArrayList<ArrayList<Integer>> getCombinations(int[] grid, int target) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	    Arrays.sort(grid);
	    backtrack(list, new ArrayList<>(), grid, target, 0);
	    return list;
	}
	
	public void backtrack(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> tempList, int[] grid, int target, int index) {
		
		if(target < 0) return;
	    else if(target == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = index; i < grid.length; i++){
	            tempList.add(grid[i]);
	            backtrack(list, tempList, grid, target - grid[i], i); // not i + 1 because we can reuse same elements
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}

	public static void main(String[] args) {
		
		int[] grid = {2, 3, 6, 7};
		int target = 9;
		
		CombinationSum cs = new CombinationSum();
		
		for(ArrayList<Integer> list: cs.getCombinations(grid, target)) {
			System.out.println(list.toString());
		}

	}

}
