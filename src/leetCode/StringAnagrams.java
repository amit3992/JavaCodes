package leetCode;
import java.util.*;


public class StringAnagrams {
	
	public static final int prime = 23;
	static HashMap<Long, String> stringMap;
	static HashMap<String, Integer> posMap;
	
	public static void init(String str, String pat) {
		stringMap = new HashMap<Long, String>();
		posMap = new HashMap<String, Integer>();
		int pL = pat.length();
		for(int i = 0; i < str.length(); i++) {
			int j = i + pL;
			if(j > str.length()) break;
			
			String s = str.substring(i, j);
			long hash = generateHash(s);
			stringMap.put(hash, s);
			posMap.put(s,i);
		}
	}
	public static long generateHash(String s) {
		long val = 0;
		for(int i = 0; i < s.length(); i++) {
			val = val +  (s.charAt(i) * prime); 
		}
		
		return val;
	}
	
	
	public static void getAnagrams(String str, String pat) {
		init(str,pat);
		long patHash = generateHash(pat);
		ArrayList<Integer> op = new ArrayList<Integer>();
		ArrayList<Long> hash = new ArrayList<Long>(stringMap.keySet());
		for(long l : hash) {
			if(l == patHash) {
				String s = stringMap.get(l);
				op.add(posMap.get(s));
			}
		}
		
		System.out.println(op.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getAnagrams("cbaebabacd","abc");
		
		
	}

}
