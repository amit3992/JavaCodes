// [1,2,3,5,8,13,14,15,16,17]
// "1-3,5,8,13-17"
public class IndeedArray2 {
    public static String toString(int[] numbers) {
        
        if(numbers == null || numbers.length == 0) {
            return "";
        }
         
        String result = "";
        int j = 0;
        int start = 0;
        int end = 0;
        int len = numbers.length;
        
        for(int i = 1; i < numbers.length; i++) {
            
            if(numbers[i] - numbers[i-1] == 1) {          
                
            	end = i; // keep track of end pointer in case condition is true
                continue;
            
            } else {
                
            	end = i-1; 	// Update end pointer
                
                result = formatString(result, numbers, start, end);
                
                /* Update start and end pointers */
                start = i;
                end = i;
               
            }
            
        }
       
       /* Call format string once again after loop is over. */
       result = formatString(result, numbers, start, end);
             
       return result;
        
    }
    
    public static String formatString(String result, int [] numbers, int start, int end) {
    	
    	if(start != end && end != numbers.length - 1) {
            result += numbers[start] + "-" + numbers[end] + ",";
            
        } else if (start == end) {
            
            result = result + numbers[start];
            
            if(end < numbers.length - 1) {
                result += ",";
            }
            
        } else { // When 'end' points to end of the loop
        	
        	result += numbers[start] + "-" + numbers[end];
        }
    	
    	return result;
    	
    }
    
    public static void main(String[] args) {
        
        int [] nums1 = {1, 2, 3, 5, 8, 13, 14, 15, 16, 17, 20};
        int [] nums2 = {1,2,4,5,6,7,9,11,13,14,15,16,17};
        int [] nums3 = {1, 2, 3, 4, 5, 6};
        int [] nums4 = {1, 3, 5, 7};
        
        String str = toString(nums4);
        System.out.println("My string -> " + str);
    }
}