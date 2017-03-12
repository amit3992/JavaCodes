package code;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ConvertTime {
    
    public static void convertTime(String stamp) {
        String res = null;
        if(stamp != null) {
            String[] parts = stamp.split(":");
            String amPm = parts[2].substring(2, 4);
        
            int h = Integer.parseInt(String.format("%02d", parts[0]));
            int m = Integer.parseInt(String.format("%02d", parts[1]));
            int s = Integer.parseInt(parts[2].substring(0,2));
            
            if(amPm.equalsIgnoreCase("pm")) {
                int hr = 12+h;
                res = hr+":"+m+":"+s;
                System.out.println(res);
            }
            else if(amPm.equalsIgnoreCase("am")) {
                res = h+":"+m+":"+s;
                System.out.println(res);
            }
        }
        
        
 }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
       Scanner sc = new Scanner(System.in);
        String timeStamp = sc.nextLine();
        convertTime(timeStamp);
        
       /* String myTime = "07:30:54";
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(myTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedTime = sdf.format(date);

        System.out.println(formattedTime);*/

       
        
        //System.out.println(s);
        
                
        
    }
}