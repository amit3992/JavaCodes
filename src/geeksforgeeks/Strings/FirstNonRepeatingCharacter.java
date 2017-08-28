package geeksforgeeks.Strings;
import java.util.*;

class CharCount {
	char ch;
	int count;
	int index;
	
	CharCount(char ch, int count, int index) {
		this.ch = ch;
		this.count = count;
		this.index = index;
	}
}

public class FirstNonRepeatingCharacter {
	
	HashMap<Character, CharCount> charMap;
	
	public void buildMap(String s) {
		charMap = new HashMap<Character, CharCount>();
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			
			if(charMap.containsKey(ch)) {
				CharCount cc = charMap.get(ch);
				
				cc.count = (cc.count > 3) ? 3 : cc.count + 1;
				cc.index = i;
				
				charMap.put(ch,cc);
			} else {
				CharCount cc = new CharCount(ch, 1, i);
				charMap.put(ch, cc);
			}
		}
		
	}
	
	public int getFirstNRC(String s) {
		
		if(s == null || s.length() == 0) {
			return -1;
		}
		
		buildMap(s);
		
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			
			if(charMap.containsKey(ch)) {
				CharCount cc = charMap.get(ch);
				
				if(cc.count == 1) {
					return cc.index;
				}
			}
		}
		
		
		return -1;
	}

	public static void main(String[] args) {
		
		String s = "geeksforgeeks";
		String s1 = "loveleetcode";
		
		FirstNonRepeatingCharacter frc = new FirstNonRepeatingCharacter();
		int index = frc.getFirstNRC(s1);
		
		System.out.println("First non-repeating character in string : " + s + " is at index: " + index);

	}

}
