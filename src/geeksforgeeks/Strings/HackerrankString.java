package geeksforgeeks.Strings;
import java.util.*;

public class HackerrankString {
	
	public static boolean checkString(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('h',1);
		map.put('a',1);
		map.put('c',1);
		map.put('k',1);
		map.put('e',1);
		map.put('r',1);
		map.put('r',1);
		map.put('a',1);
		map.put('n',1);
		map.put('k',1);
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(map.containsKey(ch)) {
				map.remove(ch);
			}
		}
		
		if(map.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		if(checkString(s)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
