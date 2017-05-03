package DSA.Arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RotateLeft {
    
    public static int[] rotateLeft(int[] array, int d, int n) {
        
    	int i, j, k, temp;
    	int t = gcd(n,d);
    	for(i = 0; i < t; i++) {
    		temp = array[i];
    		j = i;
    		while(true) {
    			k = j + d;
    			if(k >= n)
    				k = k - n;
    			if(k == i)
    				break;
    			
    			array[j] = array[k];
    			j = k;
    		}
    		array[j] = temp;
    	}
    	
    	return array;
    }
    
    public static int[] rotateRight(int[] array, int d, int n) {
    	
    	return rotateLeft(array, n-d, n);
    }
    
    public static void printArray(int[] array) {
      for(int i = 0; i < array.length; i++) {
          System.out.print(array[i] + " ");
      }
    }
    
    private static int gcd(int a, int b) {
    	if(b == 0) {
    		return a;
    	} else {
    		return gcd(b, a % b);
    	}
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        int[] array = new int[n];
        
        while(n > 0) {
            array[count] = sc.nextInt();
            count++;
            n--;
        }
        
        array = rotateLeft(array, k, array.length);
        printArray(array);
        
        array = rotateRight(array, k, array.length);
        printArray(array);
    }
}