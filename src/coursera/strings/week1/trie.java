package coursera.strings.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class trie {
	
	 class FastScanner {
	        StringTokenizer tok = new StringTokenizer("");
	        BufferedReader in;

	        FastScanner() {
	            in = new BufferedReader(new InputStreamReader(System.in));
	        }

	        String next() throws IOException {
	            while (!tok.hasMoreElements())
	                tok = new StringTokenizer(in.readLine());
	            return tok.nextToken();
	        }

	        int nextInt() throws IOException {
	            return Integer.parseInt(next());
	        }
	    }
	 
	 // ============================================ Triple class for printing ====================================== // 
	 
	 class Triple {
		 int src;
		 int dest;
		 char ch;
		 
		 Triple(int src, int dest, char ch) {
			 this.src = src;
			 this.dest = dest;
			 this.ch = ch;
		 }
	 }
	
	// ============================================= TrieNode class ================================================= //
	class TrieNode {	
		Map<Character, TrieNode> children;
		boolean endOfWord;
		int nodeNum;
		
		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
			nodeNum = 0;
		}
	}
	
   // Static variables for Trie class
   private final TrieNode root;
   boolean endOfWord;
   int charCount;
   
   
   // Trie Constructor
   public trie() {
		root = new TrieNode();
		endOfWord = false;
		charCount = 0;
	}
   
   
    List<Triple> buildTrie(String[] patterns) {
    	
        List<Triple> list = new ArrayList<Triple>();
        
        for(int n = 0; n < patterns.length; n++) {
        	
        	TrieNode current = root;
            current.nodeNum = 0;
        	String word = patterns[n];
        	
        	for(int i = 0; i < word.length(); i++) {
        		
        		char ch = word.charAt(i);
        		TrieNode node = current.children.get(ch);
        		
        		if(node == null) {
        			int src = current.nodeNum;
        			charCount++;
        			Triple t = new Triple(src, charCount, ch);
        			node = new TrieNode();
        			node.nodeNum = charCount;
        			//System.out.println(ch + " at node -> " + node.nodeNum);
        			current.children.put(ch, node);
        			list.add(t);
        		}
        		
        		current = node;
        	}
        	
        	current.endOfWord = true;
        }
        
        return list;
    }
    
    public static void printTripleList(List<Triple> list2) {
    	for(Triple t: list2) {
    		System.out.println(t.src + "->" + t.dest + ":"+t.ch);
    	}
    }

    static public void main(String[] args) throws IOException {
        new trie().run();
    }


    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        int patternsCount = scanner.nextInt();
        String[] patterns = new String[patternsCount];
        for (int i = 0; i < patternsCount; ++i) {
            patterns[i] = scanner.next();
        }
        
        List<Triple> trie = buildTrie(patterns);
        printTripleList(trie);

    }
}
