package test.regex;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class RegexPattern {
    
    private boolean checkPattern(String input) {
        String regex = "@gmail.com";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        
        if(matcher.find()) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.     */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        ArrayList<String> list = new ArrayList<String>();
        RegexPattern s = new RegexPattern();
        
        while(T > 0) {
            String name = sc.next();
            String email = sc.next();
            if(s.checkPattern(email)) {
                list.add(name);
            }
            T--;
        }
        
        Object[] nameArray = list.toArray();
        Arrays.sort(nameArray);
        
        for(Object name: nameArray) {
        	System.out.println(name.toString());
        }
        
        
        
    }
}