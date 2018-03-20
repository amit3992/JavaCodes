package educative.arrays;
import java.util.*;


public class PlusOne {
	
	public static int[] reverseArray(int[] array) {
        
        if(array == null || array.length < 2) {
            return array;
        }
        
        int [] rev = new int[array.length];
        
        for(int i = array.length - 1; i >= 0; i--) {
            rev[array.length - 1 - i] = array[i];
        }
        
        return rev;
        
    }

	public static int[] resultify(ArrayList<Integer> result) {
        
        if(result != null && result.size() > 0) {
            
            int[] res = new int[result.size()];
            
            int index = 0;
            
            for(int val : result) {
                res[index] = val;
                index++;
            }
            
            return res;
        }
        
        return new int[0];
    }
	
	public static int[] plusOne(int[] digits) {
        
        if(digits == null || digits.length == 0) {
            return digits;
        }
          
        if(digits.length == 1) {
            
            if(digits[0] < 9) {
                digits[0] = 1 + digits[0];
                return digits;
                
            } else {
                
                int [] result = new int[2];
                result[0] = 1;
                result[1] = 0;
                
                return result;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int [] revList = reverseArray(digits);
        int carry = 0;
        
        int sum = revList[0] + 1;
        
        for(int i = 1; i <= revList.length; i++) {
            
            if(sum > 9) {
                list.add(0);
                carry = 1;
            } else {
                list.add(sum);
                carry = 0;
            }
            
            if(i < revList.length) {
            	sum = revList[i] + carry;
            }
            
        }
        
        if(carry == 1) {
            list.add(1);
        }
        
        int[] answer = resultify(list);
        
        return reverseArray(answer);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] test = {1,0};
		
		for(int val : plusOne(test)) {
			System.out.print(val + " ");
		}

	}

}
