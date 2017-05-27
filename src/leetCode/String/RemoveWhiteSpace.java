package leetCode.String;

public class RemoveWhiteSpace {
	
	public static boolean isWhiteChar(char c) {
		if(c == ' ' || c == '\t') {
			return true;
		} else {
			return false;
		}
	}
	
	public static String removeWS(String s) {
		
		if(s.length() == 0 || s == null) {
			return new String();
		}
		
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		
		for(int i = 0; i < len; i++) {
			char ch = s.charAt(i);
			if(!isWhiteChar(ch)) {
				sb.append(ch);
			}
		}
		
		sb.append('\0');
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
		String ip = "	All greek 	to me.";
		
		System.out.println("Output -> " + removeWS(ip));

	}

}
