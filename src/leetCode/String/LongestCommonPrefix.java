package leetCode.String;
import java.util.*;

class TrieNode {
	char ch;
	HashMap<Character, TrieNode> children;
	
	TrieNode() {	
		children = new HashMap<Character, TrieNode>();
	}
	
	TrieNode getChild(char ch) {
		return this.children.get(ch);
	}
	
}
public class LongestCommonPrefix {
	
	TrieNode root;
	StringBuilder sb;
	
	public LongestCommonPrefix() {
		// TODO Auto-generated constructor stub
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		
		sb = new StringBuilder();
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			TrieNode node = current.getChild(ch);
			
			if(node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
				sb.append(ch);
			}
			
			current = current.getChild(ch);
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		lcp.insert("geeksforgeeks");
		lcp.insert("geeks");
		lcp.insert("geezer");
	}

}
