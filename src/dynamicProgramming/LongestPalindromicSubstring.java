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

    public static void main(String [] args) {

        String input = "babad";
        String input2 = "cbbd";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println("Longest Palindromic substring is -> " + lps.longestPalindromicString(input2));
    }
}
