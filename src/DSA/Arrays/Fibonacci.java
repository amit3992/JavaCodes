package DSA.Arrays;

import java.util.*;

public class Fibonacci {

    
    public static int fibonacci(int n) {
        // Complete the function.
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        
        if (n == 0)
            return f[0];
        else if (n == 1)
            return f[1];
        
        for(int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        
        return f[n];
      
      
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}

