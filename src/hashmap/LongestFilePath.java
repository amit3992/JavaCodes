package hashmap;
import java.util.*;

public class LongestFilePath {

    public int longestFilePath(String path) {

        if(path == null || path.length() == 0 || (path.indexOf('.') < 0)) {
            return 0;
        }

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        String [] files = path.split("\n");

        for(String sub : files) {
            int index = sub.lastIndexOf("\t") + 1;

            int prev_len = index > 0 ? map.get(index - 1) : 0;
            int current_len = prev_len + sub.length() - index + 1;

            map.put(index, current_len);

            if(sub.indexOf('.') >= 0) {
                ans = Math.max(ans, current_len - 1);
            }
        }

        return ans;

    }

    public static void main(String [] args) {

        String path1 = "dir\\n\\tsubdir1\\n\\tsubdir2\\n\\t\\tfile.ext";
        String path2 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";

        LongestFilePath lfp = new LongestFilePath();
        System.out.println("Longest absolute path length -> " + lfp.longestFilePath(path2));
    }
}
