package dataStructures.Trie;
import java.util.*;

public class MyTrie {
	
	private final TrieNode root;
	boolean endOfWord;
	boolean isBadSet;
	String badWord;
	int charCount;
	
	public MyTrie() {
		root = new TrieNode();
		endOfWord = false;
		isBadSet = false;
		badWord = null;
		charCount = 0;
	}
	
	public TrieNode getRoot() {
		return root;
	}
	
	// Iterative insertion into trie
	public void insert(String word) {
		
		TrieNode current = root;
		current.nodeNum = charCount;
		//System.out.println("Root -> " + current.nodeNum);
		for(int i = 0; i < word.length(); i++) {
			
			char ch = word.charAt(i);
			current.numWordsAhead++;
			TrieNode node = current.children.get(ch);
			
			if(node == null) {
				charCount++;
				node = new TrieNode();
				node.nodeNum = charCount;
				//System.out.println("Character -> " + ch + " at node number: " + node.nodeNum);
				current.children.put(ch, node);
			}
			
			current = node;
			
			if(current.endOfWord) {
				this.isBadSet = true;
				this.badWord = word;
			}
		}
		current.endOfWord = true;
	}
	
	// Recursive implementation of insert into trie
	public void insertRecursive(String word) {
		insertRecursive(root, word, 0);
	}
	
	private void insertRecursive(TrieNode current, String word, int index) {
		
		if(index == word.length()) {
			current.endOfWord = true;
			return;
		}
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		
		if(node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}
		insertRecursive(node, word, index + 1);
		
	}
	
	private String displayData(TrieNode a, TrieNode b) {
		return a.nodeNum + "->" + b.nodeNum + ": " + b.character;
	}
	
	public void traverseTrie(TrieNode node) {
		TrieNode current = node;
		ArrayList<TrieNode> childList = new ArrayList<TrieNode>(current.children.values());
		for(TrieNode n: childList) {
			System.out.println(displayData(current, n));
		}
		
	}
	
	
	// Search word in trie ITERATIVELY
	public boolean search(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			
			if(node == null)
				return false;
			
			current = node;
		}
		
		return current.endOfWord;
	}
	
	// Search word in trie ITERATIVELY
	public int countSubstring(String word) {
			TrieNode current = root;
			for(int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				TrieNode node = current.children.get(ch);
				
				if(node == null)
					return 0;
				
				current = node;
			}
			
			return current.numWordsAhead;
		}
	
	public boolean recursiveSearch(String word) {
		return recursiveSearch(root, word, 0);
	}
	
	private boolean recursiveSearch(TrieNode current, String word, int index) {
		if(index == word.length()) {
			return current.endOfWord;
		}
		
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		
		if(node == null) {
			return false;
		}
		
		return recursiveSearch(node, word, index + 1);
	}
	
	// Delete word from trie;
	public void delete(String word) {
		delete(root, word, 0);
	}
	
	private boolean delete(TrieNode current, String word, int index) {
		if(index == word.length()) {
			// When end of the word is reached, only delete if current.endOfWord == true
			if(!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			
			// If current has no other mapping, return true;
			return current.children.size() == 0;
		}
		
		char ch = word.charAt(index);
		TrieNode node = current.children.get(ch);
		if(node == null) {
			return false;
		}
		
		boolean shouldDeleteCurrentNode = delete(node, word, index + 1);
		
		// If true is returned then delete the mapping of character and trienode reference from map
		if(shouldDeleteCurrentNode) {
			current.children.remove(ch);
			return current.children.size() == 0;
		}
		
		return false;
		
		
	}

	public void checkSet() {
		// TODO Auto-generated method stub
		if(this.isBadSet) {
			System.out.println("BAD SET");
			System.out.println(this.badWord);
		}
		
	}
	
	

}
