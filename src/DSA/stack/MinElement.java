package DSA.stack;
/*
 * Hackerrank max element
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MinElement {
    
    Stack<Integer> dataStack;
    int minElement;
    
    MinElement() {
        dataStack = new Stack<Integer>();
        minElement = -1;
    }
    
    public void push(int data) {
        
        if(dataStack.isEmpty()) {
            dataStack.push(data);
            minElement = data;
        }
        else {
        	if(data >= minElement) {
                dataStack.push(data);
        	}
        	else if(data < minElement) {
        		int newData = 2*data - minElement;
        		minElement = data;
        		dataStack.push(newData);
        	}
            
        }
   
    }
    
    public void pop() {
       if(!dataStack.isEmpty()) {
           int poppedData = dataStack.pop();
           
           if(poppedData >= minElement) {
               return;
           }
           else if(poppedData < minElement) {
               minElement = 2*minElement - poppedData;
               return;
           }
       }
    }
    
    public int getMin() {
        
        return minElement;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        MinElement s = new MinElement();
        
        for(int i = 0; i < n; i++) {
            
            int op = sc.nextInt();
            
            switch(op) {
                
                case 1: int data = sc.nextInt();
                        s.push(data);
                        break;
                
                case 2: s.pop();
                        break;
                
                case 3: System.out.println(s.getMin());
                        break;
                
                default: continue;
                
            
            }
           
        }
    }
}