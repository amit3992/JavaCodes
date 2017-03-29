package dataStructures.Trie;
import java.util.*;
import java.io.*;


public class TrieDriver2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		MyTrie trie = new MyTrie();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		line = br.readLine();
		int n = Integer.parseInt(line);
		while(n > 0) {
			line = br.readLine();
			trie.insert(line);
			n--;
		}
		
		TrieNode root = trie.getRoot();
		trie.traverseTrie(root);
	
	}

}
