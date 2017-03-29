package dataStructures.Trie;
import java.util.*;
import java.io.*;

public class SuffixTrie {
	
	private final static int MAX_CHAR = 256;
	
	class SuffixTrieNode {
		
		SuffixTrieNode[] children;
		ArrayList<Integer> indices;
		
		SuffixTrieNode() {
			children = new SuffixTrieNode[MAX_CHAR];
			indices = new ArrayList<Integer>();
		}
		
		public void insertSuffix(String s, int index) {
			
			this.indices.add(index);
			
			if(s.length() > 0) {
				
				char cIndex = s.charAt(0);
				
				if(this.children[cIndex] == null) {
					this.children[cIndex] = new SuffixTrieNode();
				}
				
				children[cIndex].insertSuffix(s.substring(1), index + 1);
			}
		}
		
		public ArrayList<Integer> search(String s) {
			
			if(s.length() == 0)
				return this.indices;
			
			if(this.children[s.charAt(0)] != null) {
				return children[s.charAt(0)].search(s.substring(1));
			}
			else {
				return null;
			}
		}
		
	}
	
	SuffixTrieNode root;
	String text;
	
	SuffixTrie(String text) {
		root = new SuffixTrieNode();
		this.text = text;
		
		for(int i = 0; i < text.length(); i++) {
			root.insertSuffix(this.text.substring(i), i);
		}
		
	}
	
	public void search(String pat) {
		
		ArrayList<Integer> result = root.search(pat);
		
		if(result == null || result.size() == 0) {
			System.out.println("PATTERN NOT FOUND!");
		}
		else {
			for(Integer i: result) {
				System.out.println("Pattern found at -> " + (i - pat.length()));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		String text = "AATCGGGTTCAATCGGGGT";
		SuffixTrie st = new SuffixTrie(text);
		
		System.out.println("Search for ATCG: ");
		st.search("ATCG");
		
		System.out.println("Search for GGGT: ");
		st.search("GGGT");
		
//		System.out.println("Search for quiz: ");
//		st.search("quiz");*/

	}

}
