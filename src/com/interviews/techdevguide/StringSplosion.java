package com.interviews.techdevguide;
import java.util.*;

public class StringSplosion {

    public String splode(String str) {

        if(str == null || str.length() == 0) {
            return str;
        }

        int len = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < len; i++) {
            sb.append(str.substring(0, i));
        }

        sb.append(str);

        return sb.toString();
    }

    public static void main(String [] args) {

        String input = "Code";
        StringSplosion ss = new StringSplosion();
        System.out.println("Sploded string -> " + ss.splode(input));

    }
}
