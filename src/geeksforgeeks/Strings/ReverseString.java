package geeksforgeeks.Strings;

public class ReverseString {
	
	public String reverseString(String s) {
        
        if(s == null || s.length() <= 1) {
            return s;
        }
        
        /* Using string buider 
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
        */
        
        /* Using byte array */
        byte[] strAsByte = s.getBytes();
        byte[] result = new byte[strAsByte.length];
        
        // Store result in reverse
        for(int i = 0; i < strAsByte.length; i++) {
            result[i] = strAsByte[strAsByte.length - 1 - i];
        }
        
        return new String(result);
    }
	
	final int NO_OF_CHARS = 256;
    char[] count = new char[NO_OF_CHARS];
    
    private void getCharArrayCount(String s) {
        for(int i = 0; i < s.length(); i++) {
            
            if(count[s.charAt(i)] < 3) {
                count[s.charAt(i)]++;
            }
        }
    }
    
    
    public int firstUniqChar(String s) {
        
        if(s == null || s.length() <= 1) {
            
            if(s.length() == 0) {
                return -1;
            } else {
                return 0;
            }
        }
        
        getCharArrayCount(s);
        int index = -1;
        
        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)] == 1) {
                index = i;
                break;
            }
        }
        
        return index;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "amit kulkarni";
		ReverseString rs = new ReverseString();
		System.out.println("Reversed string: " + rs.reverseString(s));
		
		System.out.println("First unique character: " + rs.firstUniqChar(s));

	}

}
