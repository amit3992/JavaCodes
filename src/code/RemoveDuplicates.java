package code;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RemoveDuplicates {
    
    private static String removePairs(String str) {
      
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)) {
                str = str.substring(0, i-1) + str.substring(i+1);
                i = 0;
            }
        }
        if (str.length() == 0) {
            return "Empty String";
        } else {
            return str;
        }
    }
    
    public static int[] removeDuplicates(int[] A) {
    	if (A.length < 2)
    		return A;
     
    	int j = 0;
    	int i = 1;
     
    	while (i < A.length) {
    		if (A[i] == A[j]) {
    			System.out.println("A[" + i + "]  = " + A[i]);
    			System.out.println("A[" + j + "]  = " + A[j]);
    			i++;
    		} else {
    			j++;
    			A[j] = A[i];
    			i++;
    		}
    	}
     
    	int[] B = Arrays.copyOf(A, j + 1);
     
    	return B;
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
      //  String s = line.readLine();
        
        //System.out.println(removePairs(s));
        
        int[] arr = { 1, 2, 2, 3, 3 };
    	arr = removeDuplicates(arr);
    	System.out.println(arr.length);
    }
}