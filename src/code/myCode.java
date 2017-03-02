package code;

import java.io.*;
import java.util.*;

class myCode
{
    private static int countDeletions(String str) 
    {
        int len = str.length();
        
        char[] chars = str.toCharArray();
        int count = 0;
        
        for(int i = 0; i < chars.length; i++) 
        {
            char currentChar = chars[i];
            char nextChar = i + 1 == chars.length ? 'c' : chars[i + 1];
            
            if(currentChar == nextChar)
                count++;
        }
        
        return count;
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        //System.out.println("Hello Java");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        int n = Integer.parseInt(br.readLine());
        while(n > 0) 
        {
            line = br.readLine();
            System.out.println(countDeletions(line));
        }
        
    }
}
