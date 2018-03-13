package leetCode.String;
import java.util.*;

public class AToI {
	
	public static int atoi(String s) {
		if(s == null) {
			return 0;
		}
		
		if(s.length() == 0) {
			return 0;
		}
		
		s = s.trim();
		double result = 0;
		
		int flag = 0;
		int i = 0;
		
		if(s.charAt(0) == '-'){
			flag = 1;
			i++;
		}
		
		if(s.charAt(0) == '+') {
			flag = 0;
			i++;
		}
		
		while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
			result = result * 10 + (s.charAt(i) - '0');
			
			//System.out.println(result);
			i++;
		}
		
		 if(flag == 1)
	        result = -result;
	     
		 if(result > Integer.MAX_VALUE)
	        return Integer.MAX_VALUE;
	     
	     if(result < Integer.MIN_VALUE)
	         return Integer.MIN_VALUE;
	     
	     
	     return (int)result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = " 75";
        System.out.println(atoi(a));

	}

}
