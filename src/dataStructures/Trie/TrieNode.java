package dataStructures.Trie;
import java.util.*;

public class TrieNode {

	Map<Character, TrieNode> children;
	boolean endOfWord;
	int numWordsAhead = 0;
	
	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}
}
