package dynamicProgramming;

public class LongestPalindromicSubstring {

    public String longestPalindromicString(String input) {

        if(input == null || input.length() == 0) {
            return input;
        }

        int n = input.length();
        String result = null;

        boolean T[][] = new boolean[n][n];

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                if(input.charAt(i) == input.charAt(j)) {
                    T[i][j] = (j - i < 3) || T[i + 1][j - 1];
                }

                if(T[i][j] && (result == null || j - i + 1 > result.length())) {
                    result = input.substring(i, j + 1);
                }
            }
        }

        return result;


    }

    public int longestPalSubstr(String str) {
        int n = str.length();   // get length of input string
 
        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];
 
        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
 
        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
         
        // Check for lengths greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k) {
             
                  // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) 
            {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;
 
                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to 
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.charAt(i) == 
                                          str.charAt(j)) {
                    table[i][j] = true;
 
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start, start + maxLength - 1);
         
        return maxLength; // return length of LPS
    }
    
 // A utility function to print a substring str[low..high]
   private void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }
    
    
    public static void main(String [] args) {

        String input = "babad";
        String input2 = "cbbd";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        //System.out.println("Longest Palindromic substring is -> " + lps.longestPalindromicString(input2));
        System.out.println("Longest palindromic substring -> " + lps.longestPalSubstr(input));
    }
}
