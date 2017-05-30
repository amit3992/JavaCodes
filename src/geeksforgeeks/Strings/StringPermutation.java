package geeksforgeeks.Strings;
import java.util.*;

public class StringPermutation {
	
	public List<String> permuteString(char[] input) {
		
		Map<Character, Integer> countMap = new TreeMap<>();
		for(char ch: input) {
			countMap.compute(ch, (key, value) -> {
				if(value == null) {
					return 1;
				}
				else {
					return value + 1;
				}
			});
		}
		
		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		
		int index = 0;
		
		for(Map.Entry<Character, Integer> entry: countMap.entrySet()) {
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		
		List<String> resultList = new ArrayList<String>();
		char [] result = new char[input.length];
		permuteUtil(str, count, result, 0, resultList);
		
		return resultList;
	}
	
	public void permuteUtil(char[] str, int[] count, char[] result, int level, List<String> resultList) {
		
		if(level == result.length) {
			resultList.add(new String(result));
			return;
		}
		
		for(int i = 0; i < str.length; i++) {
			if(count[i] == 0)
				continue;
			
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level + 1, resultList);
			count[i]++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "ABC";
		StringPermutation sp = new StringPermutation();
		
		for(String str: sp.permuteString(s.toCharArray())) {
			System.out.println(str);
		}

	}

}
