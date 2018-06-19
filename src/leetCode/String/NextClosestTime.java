package leetCode.String;

public class NextClosestTime {
	
	public String nextClosestTime(String time) {
		
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String time = "19:34";
		NextClosestTime nct = new NextClosestTime();
		System.out.println("Next closest time is: " + nct.nextClosestTime(time));

	}

}
