package leetCode;
import java.util.*;

public class PowerSet {
	
	ArrayList<ArrayList<Integer>> powerSet;
	
	ArrayList<ArrayList<Integer>> computePowerSet(ArrayList<Integer> set, int index) {
		if(set.size() == index) {
			powerSet = new ArrayList<ArrayList<Integer>>();
			powerSet.add(new ArrayList<Integer>());
		} else {
			powerSet = computePowerSet(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moreSets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> subSet : powerSet) {
				ArrayList<Integer> newSubSet = new ArrayList<Integer>();
				newSubSet.addAll(subSet);
				newSubSet.add(item);
				moreSets.add(newSubSet);
			}
			
			powerSet.addAll(moreSets);
		}
		
		return powerSet;
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int n = sc.nextInt();
		
		PowerSet ps = new PowerSet();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		for(ArrayList<Integer> set: ps.computePowerSet(list, 0)) {
			System.out.println(set.toString());
		}
		
		
	}

}
