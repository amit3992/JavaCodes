package leetCode.String;

public class RegularExpression {
	
	static boolean regx_match_rec(String text, String pattern) {
		  
		if (text.isEmpty() && pattern.isEmpty()) {
		    return true;
		  }

		  if (!text.isEmpty() && pattern.isEmpty()) {
		    return false;
		  }

		  /* Condition if first 2 chars are 'a*' */
		  if (pattern.length() > 1 && pattern.charAt(1) == '*') {
		    
		    String remaining_pattern = pattern.substring(2);
		    String remaining_text = text;

		    for (int i = 0; i < text.length() + 1; ++i) {
		      
		      if (regx_match_rec(remaining_text, remaining_pattern)) {
		        return true;
		      }

		      if (remaining_text.isEmpty()) {
		        return false;
		      }

		      if (pattern.charAt(0) != '.' && 
		          remaining_text.charAt(0) != pattern.charAt(0)) {
		        return false;
		      }

		      remaining_text = remaining_text.substring(1);
		    }
		  } 
		  
		  if(text.isEmpty() || pattern.isEmpty()) {
		    return false;
		  }
		  
		  /* Condition if first char == '.' or it matches with pattern */
		  if(pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
		    
			String remaining_text = "";
		    if (text.length() >= 2) {
		      remaining_text = text.substring(1);
		    }

		    String remaining_pattern = "";
		    if (pattern.length() >= 2) {
		      remaining_pattern = pattern.substring(1);
		    } 

		    return regx_match_rec(remaining_text, remaining_pattern);
		  } 

		  return false;
		}

		static boolean regx_match(String text, String pattern) {
		  return regx_match_rec(text, pattern);
		}

	public static void main(String[] args) {
		
		String text = "fabbbc";
		String pattern = ".ab*c";
		
		System.out.println("Is a match? -> " + regx_match(text, pattern));

	}

}
