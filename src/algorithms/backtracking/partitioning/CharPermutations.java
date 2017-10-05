package algorithms.backtracking.partitioning;
import java.util.*;


public class CharPermutations {
	
	public List<List<Character>> permute(char[] nums) {
		   List<List<Character>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private void backtrack(List<List<Character>> list, List<Character> tempList, char [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [] nums = {'a', 'b', 'c'};
		
		CharPermutations np = new CharPermutations();
		
		for(List<Character> list: np.permute(nums)) {
			System.out.println(list.toString());
		}

	}

}

