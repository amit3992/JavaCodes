package DSA.stack;
/*
 * Hackerrank max element
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MaxElement {
    
    Stack<Integer> dataStack;
    int maxElement;
    
    MaxElement() {
        dataStack = new Stack<Integer>();
        maxElement = -1;
    }
    
    public void push(int data) {
        
        if(dataStack.isEmpty()) {
            dataStack.push(data);
            maxElement = data;
        }
        else {
        	if(data > maxElement) {
        		int newData = maxElement + data;
                maxElement = data;
                dataStack.push(newData);
        	}
        	else if(data <= maxElement) {
        		dataStack.push(data);
        	}
            
        }
   
    }
    
    public void pop() {
       if(!dataStack.isEmpty()) {
           int poppedData = dataStack.pop();
           if(poppedData == maxElement) {
               maxElement = 0;
               return;
           }
           else if(poppedData > maxElement) {
               maxElement = poppedData - maxElement;
               System.out.println("Popped data = " + (poppedData - maxElement));
               return;
           }
           else if(poppedData < maxElement) {
               System.out.println("Popped data = " + poppedData);
               return;
           }
       }
    }
    
    public int getMax() {
        
        return maxElement;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        */
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        MaxElement s = new MaxElement();
        
        for(int i = 0; i < n; i++) {
            
            int op = sc.nextInt();
            
            switch(op) {
                
                case 1: int data = sc.nextInt();
                        s.push(data);
                        break;
                
                case 2: s.pop();
                        break;
                
                case 3: System.out.println(s.getMax());
                        break;
                
                default: continue;
                
            
            }
           
        }
    }
}