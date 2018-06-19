package com.interviews.google;

import java.util.Arrays;

public class NextClosestTime {
	
	public String nextClosestTimeLazy (String time) {
		
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
       
        while (true) {
        	
            if (++min == 60) {
                min = 0;
                ++hour;
                hour %= 24;
            }
            
            
            String curr = String.format("%02d:%02d", hour, min);
            Boolean valid = true;
            
            for (int i = 0; i < curr.length(); ++i) {
            	
            	  if (time.indexOf(curr.charAt(i)) < 0) {
                      valid = false;
                      break;
                  }
            	
            }
              
            if (valid) return curr;
        }
    }

	
	public String nextClosestTime(String time) {
        
		char[] numbers = new char[4];
       
        numbers[0] = time.charAt(4);
        numbers[1] = time.charAt(3);
        numbers[2] = time.charAt(1);
        numbers[3] = time.charAt(0);
        
        Arrays.sort(numbers);
        char[] result = time.toCharArray();
        
        
        /* Case 1: HH:M_ */
        result[4] = getNext(numbers, result[4], '9');
        if(result[4] > time.charAt(4))
        		return String.valueOf(result);
        
        
        /* Case 2: HH:_M */
        result[3] = getNext(numbers, result[3], '5');
        if(result[3] > time.charAt(3))
        		return String.valueOf(result);
        
        
        /* Case 3: H_:MM */
        result[1] = getNext(numbers, result[1], result[0] == '2' ? '3' : '9');
        if(result[1] > time.charAt(1))
        		return String.valueOf(result);
        
        /* Case 4: _H : MM */
        result[0] = getNext(numbers, result[0], '2');
        
        
        return String.valueOf(result);
    }
	
	public char getNext(char[] numbers, char cur, char upperbound) {
		
		if(cur < upperbound) {
			
			for(int i = 0; i < numbers.length && numbers[i] <= upperbound; i++)
				if(numbers[i] > cur)
					return numbers[i];
		}
		
		return numbers[0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NextClosestTime nct = new  NextClosestTime();
		System.out.println(" Lazy Next time -> " + nct.nextClosestTime("19:34"));
		System.out.println("Faster Next time -> " + nct.nextClosestTime("19:34"));

	}

}
