package algorithms.backtracking.partitioning;
import java.util.*;

public class Subsets {
	
	public static List<List<Integer>> subsets(int[] nums) {
	    List<List<Integer>> list = new ArrayList<>();
	    backtrack(list, new ArrayList<>(), nums, 0);
	    return list;
	}

	private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
	    list.add(new ArrayList<>(tempList));
	    for(int i = start; i < nums.length; i++){
	        tempList.add(nums[i]);
	        backtrack(list, tempList, nums, i + 1);
	        tempList.remove(tempList.size() - 1);
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] nums = {1,2,3};
		
		for(List<Integer> list : subsets(nums)) {
			System.out.println(list.toString());
		}

	}

}
