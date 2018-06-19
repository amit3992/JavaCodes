package algorithms.backtracking;
import java.util.*;

public class WordSquare {

    class Node {

        Node [] nodes;
        String word;

        Node() {
            this.nodes = new Node[26];
            this.word = null;
        }
    }

    void add(Node root, String word) {
        Node node = root;

        for(char c : word.toCharArray()) {

            int index = c - 'a';
            if(node.nodes[index] == null) {
                node.nodes[index] = new Node();
                node = node.nodes[index];
            }
        }

        node.word = word;
    }

    public List<List<String>> wordSquare(String [] words) {

        List<List<String>> result = new ArrayList<>();

        if(words == null || words.length == 0) {
            return result;
        }

        Node root = new Node();
        int len = words[0].length();

        for(String word : words) {
            add(root, word);
        }

        Node [] rows = new Node[len];

        for(int i = 0; i < len; i++) {
            rows[i] = root;
        }

        //helper(0, 0, len, rows, result);
        return result;

    }

    public static void main(String [] args) {

    }
}
