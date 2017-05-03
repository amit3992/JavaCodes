package leetCode;
import java.util.*;

public class GroupAnagrams {
	
	private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	public static HashMap<Long, ArrayList<String>> map = new HashMap<Long, ArrayList<String>>();
	private static final int IND = 97;
	private static ArrayList<Long> hashList;
	
	public static long calcHashCode(String s) {
		
		int n = s.length();
		long result = 1;
		for(int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			result *= primes[(int)ch - IND];
		}
		
		return result;
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();
		hashList = new ArrayList<Long>();
		
		for(String s: strs) {
			List<String> t;
			long hashCode = calcHashCode(s);
			
			if(!hashList.contains(hashCode)) {
				hashList.add(hashCode);
			}
			
			if(map.containsKey(hashCode)) {
				t = map.get(hashCode);
				t.add(s);
				map.put(hashCode,(ArrayList<String>) t);
			} else {
				t = new ArrayList<String>();
				t.add(s);
				map.put(hashCode,(ArrayList<String>) t);
			}
			
		}
		
		for(Long l : hashList) {
			ArrayList<String> list = map.get(l);
			if(list != null && !list.isEmpty()) {
				result.add(list);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		String[] strs = {"cat", "tac", "dog", "act", "god", "pan", "rat", "nap", "tar","hat"};
		List<List<String>> result = null;
		
		result = groupAnagrams(strs);
		System.out.println(result.toString());
		

	}

}
