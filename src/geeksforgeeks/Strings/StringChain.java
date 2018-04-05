package geeksforgeeks.Strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.lang.StringBuilder;

public class StringChain {
    public int findLongestChain(String[] words) {
        if (words==null || words.length==0) return 0;
        int longestChain = 0;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length()-str2.length();
            }
        });
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) continue;
            map.put(word, 1);
            for (int i=0; i<word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String after = sb.toString();
                if (map.containsKey(after) && map.get(after)+1 > map.get(word)) {
                    map.put(word, map.get(after)+1);
                }
            }
            if (map.get(word) > longestChain) longestChain = map.get(word);
        }
        return longestChain;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringChain sol = new StringChain();
        String[] words = new String[]{"6", "a", "b", "ba", "bca", "bda", "bdca"};
        //String[] words = new String[]{"a", "a", "bc", "exf", "abc"};
        //String[] words = new String[]{"bc", "abc"};
        int longestChain = sol.findLongestChain(words);
        System.out.println(longestChain);
    }

}