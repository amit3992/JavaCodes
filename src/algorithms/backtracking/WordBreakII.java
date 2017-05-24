package algorithms.backtracking;
import java.util.*;

class TrieNode {
	char ch;
	HashMap<Character, TrieNode> children;
	boolean endOfWord;
	
	TrieNode() {
		this.children = new HashMap<Character, TrieNode>();
		this.endOfWord = false;
	}
	
	public TrieNode getChild(char ch) {
		return this.children.get(ch);
	}
}
public class WordBreakII {
	
	TrieNode root;
	
	WordBreakII() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			TrieNode node = current.getChild(ch);
			if(node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			
			current = current.getChild(ch);
			
		}
		
		current.endOfWord = true;
	}
	
	public boolean searchWord(String word) {
		TrieNode current = root;
		
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			TrieNode node = current.getChild(ch);
			if(node == null) {
				return false;
			}
			current = current.getChild(ch);
		}
		
		return current.endOfWord;
	}
	
	

	public static void main(String[] args) {
		
		WordBreakII wb = new WordBreakII();
		String[] words = {"cat", "cats", "and", "sand", "dog"};
		
		for(int i = 0; i < words.length; i++) {
			wb.insert(words[i]);
		}
		
		

	}

}
