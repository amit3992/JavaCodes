package leetCode;
import java.util.*;
import java.io.*;

public class BadSetTrie {
	
	class TrieNode {
		
		HashMap<Character, TrieNode> children;
		boolean endOfWord;
		
		TrieNode() {
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}
	
	TrieNode root;
	boolean isBadString;
	ArrayList<String> badWords;
	
	BadSetTrie() {
		
		root = new TrieNode();
		isBadString = false;
		badWords = new ArrayList<String>();
	}
	
	public void insert(String word) {
		if(word.length() == 0)
			return;
		
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node  == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
			if(current.endOfWord) {
				isBadString = true;
				badWords.add(word);
			}
		}
		
		current.endOfWord = true;
	}
	
	public void checkSet() {
		if(isBadString) {
			System.out.println("BAD SET");
			System.out.println(badWords.get(0));
		}
		else {
			System.out.println("GOOD SET");
		}
	}
	
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = br.readLine();
		int n = Integer.parseInt(line);
		BadSetTrie trie = new BadSetTrie();
		while(n > 0) {
			line = br.readLine();
			trie.insert(line);
			n--;
		}
		
		trie.checkSet();

	}

}
