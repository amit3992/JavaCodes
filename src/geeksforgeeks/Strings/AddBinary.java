package geeksforgeeks.Strings;

public class AddBinary {
	
	public static String AddBinary(String a, String b) {
		
		StringBuilder sb = new StringBuilder();
       
		int i = a.length() - 1;
		int j = b.length() -1;
		int carry = 0;
        
        while (i >= 0 || j >= 0) {
            int sum = carry;
            
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if (carry != 0) 
        	sb.append(carry);
        
        return sb.reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(AddBinary("1100", "1000"));

	}

}
