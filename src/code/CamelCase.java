package code;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CamelCase {
    
    private static int countCamelCases(String s) {
        
        char [] charArray = s.toCharArray();
        int count = 0;
        if(Character.isUpperCase(charArray[0]))
            return 0;
        else {
            for(int i = 0; i < charArray.length; i++) {
                if(Character.isUpperCase(charArray[i])) 
                    count++;
            }
        }
        
        return count+1;
    }

    public static void main(String[] args) {

        int [] array = {4, 2, 5, 1 , 3};
        double target = 3.714286;

        for(int i = 0; i < array.length; i++) {
            double diff = Math.abs(target - array[i]);
            System.out.println("Diff for num -> " + array[i] + " ==> " + diff);
        }
        /*
        Scanner in = new Scanner(System.in);
        String s = in.next();
        
        System.out.println(countCamelCases(s));
        */
    }
}