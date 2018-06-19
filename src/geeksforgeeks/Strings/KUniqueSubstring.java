package geeksforgeeks.Strings;

public class KUniqueSubstring {

    int MAX_CHARS = 26;

    private boolean isValid(int [] count, int k) {

        int val = 0;

        for(int i = 0; i < MAX_CHARS; i++) {
            if(count[i] > 0) {
                val += 1;
            }
        }

        return k >= val;
    }

    public void kUniqueSubstring(String s, int k) {

        if(s == null || s.length() == 0) {
            return;
        }

        int u = 0;
        int len = s.length();

        int [] count = new int[MAX_CHARS];

        for(int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i) - 'a'] == 0) {
                u++;
            }
            count[s.charAt(i) - 'a']++;
        }

        if(u < k) {
            System.out.println("Not enough unique characters");
            return;
        }

        int current_start = 0;
        int current_end = 0;

        int max_window_size = 1;
        int max_window_start = 0;

        count = new int[MAX_CHARS];

        count[s.charAt(0) - 'a'] += 1;


        for(int i = 1; i < len; i++) {

            count[s.charAt(i) - 'a']++;
            current_end++;

            while(!isValid(count, k)) {
                count[s.charAt(current_start) - 'a']--;
                current_start++;
            }

            if(current_end - current_start + 1 > max_window_size) {
                max_window_size = current_end - current_start + 1;
                max_window_start = current_start;
            }
        }

        System.out.println("Max substring is -> " + s.substring(max_window_start, max_window_size + max_window_start)+ " with length -> " + max_window_size);
    }


    public static void main(String [] args) {
        KUniqueSubstring kus = new KUniqueSubstring();

        //kus.kUniqueSubstring("aabacbebebe",  3);
        kus.kUniqueSubstring("aaabbbbcccccc", 2);
    }

}
