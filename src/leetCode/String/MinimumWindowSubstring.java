package leetCode.String;
import java.util.*;

/*
 * 	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC"
	
	S = "GEEKSFORGEEKS"
	T = "ORK"
	Minimum window is "KSFOR"
 * 
 * */
public class MinimumWindowSubstring {
	
	final int NO_OF_CHARS = 256;
	
	public String getMinWindowString(String text, String pat) {
		
		int len1 = text.length();
		int len2 = pat.length();
		
		if(len1 < len2) {
			return "Invalid";
		}
		
		int [] hash_pat = new int[NO_OF_CHARS];
		int [] hash_text = new int[NO_OF_CHARS];
		
		/* Store occurences of pattern */
		for(int i = 0; i < len2; i++) {
			hash_pat[pat.charAt(i)]++;
		}
		
		int start = 0;
		int start_index = -1;
		int min_len = Integer.MAX_VALUE;
		
		/* Start traversing the text string */
		int count = 0;
		for(int j = 0; j < len1; j++) {
			
			/* Count occurences of characters in text */
			hash_text[text.charAt(j)]++;
			
			 // If string's char matches with pattern's char
            // then increment count
            if (hash_pat[text.charAt(j)] != 0 && hash_text[text.charAt(j)] <= hash_pat[text.charAt(j)] ) {
            	count++;
            }
            
            if(count == len2) {
            	// Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while ( hash_text[text.charAt(start)] > hash_pat[text.charAt(start)]
                       || hash_pat[text.charAt(start)] == 0)
                {
      
                    if (hash_text[text.charAt(start)] > hash_pat[text.charAt(start)])
                        hash_text[text.charAt(start)]--;
                    start++;
                }
      
                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window)
                {
                    min_len = len_window;
                    start_index = start;
                }
            }
		}
		
		 // If no window found
        if (start_index == -1)
        {
           System.out.println("No such window exists");
           return "";
        }
      
        // Return substring starting from start_index
        // and length min_len
        return text.substring(start_index, start_index + min_len);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		String text = "ADOBECODEBANC";
		String pattern = "ABC";
		
		System.out.println("Minimum window substring is: " + mws.getMinWindowString(text, pattern));

	}

}
