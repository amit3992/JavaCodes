package com.interviews.google;
import java.util.*;

public class DecodeString {

    public String decode(String input) {

        if(input == null || input.length() == 0) {
            return input;
        }

        String result = "";
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> resultStack = new Stack<String>();

        int index = 0;

        while(index < input.length()) {

            if(Character.isDigit(input.charAt(index))) {

                int count = 0;
                while(Character.isDigit(input.charAt(index))) {
                    count = count * 10 + (input.charAt(index) - '0');
                    index++;
                }

                countStack.push(count);

            } else if(input.charAt(index) == '[') {
                resultStack.push(result);
                result = "";
                index++;

            } else if(input.charAt(index) == ']') {

                String temp = resultStack.pop();
                StringBuilder sb = new StringBuilder(temp);

                int nTimes = !countStack.isEmpty() ? countStack.pop() : 0;
                while(nTimes-- > 0) {
                    sb.append(result);
                }

                result = sb.toString();
                index++;

            } else {
                result += input.charAt(index);
                index++;
            }


        }

        return result;

    }

    public static void main(String [] args) {

        DecodeString ds = new DecodeString();
        String test1 = "3[a]2[bc]";
        String test2 = "3[a2[c]]";
        String test3 = "2[abc]3[cd]ef";

        System.out.println("Decoded string -> " + ds.decode(test3));
    }
}
