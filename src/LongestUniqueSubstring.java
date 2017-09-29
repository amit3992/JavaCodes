import java.util.*;

/*ABCABCDAB => ABCD */
public class LongestUniqueSubstring {
	
	static final int NO_OF_CHARS = 256;
	
	public static int longestUniqueSubstring(String str) {
		
		if(str == null || str.length() == 0) {
			return -1;
		}
		
		int n = str.length();
		int current_len = 1;
		int max_len = 1;
		int prev_index;
		
		int [] checked = new int[NO_OF_CHARS];
		
		/* Initialize to -1 */
		for(int index = 0; index < checked.length; index++) {
			checked[index] = -1;
		}
		
		checked[str.charAt(0)] = 0; // Mark as checked 
		
		for(int i = 1; i < n; i++) {
			
			prev_index = checked[str.charAt(i)];
			
			/**/
			if(prev_index == -1 || i - current_len > prev_index) {
				current_len++;
			} else {
				
				if(current_len > max_len) {
					max_len = current_len;
				}
				
				current_len = (i - prev_index);
			}
			
			/* Update index of current character */
			checked[str.charAt(i)] = i;
			
		}
		
		if(current_len > max_len) {
			max_len = current_len;
		}
		
		return max_len;	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "ABCABCDAB";
		
		System.out.println("Max -> " + longestUniqueSubstring(s));

	}

}
