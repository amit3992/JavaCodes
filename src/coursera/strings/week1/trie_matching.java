package coursera.strings.week1;

import java.io.*;
import java.util.*;

class Node
{
	public static final int Letters =  256;
	public static final int NA      = -1;
	public Node[] children;
	ArrayList<Integer> indices;

	Node ()
	{
		children = new Node [Letters];
		indices = new ArrayList<Integer>();
	}
	
	public void insertSuffix(String s, int index) {
		
		this.indices.add(index);
		
		if(s.length() > 0) {
			
			char cIndex = s.charAt(0);
			
			if(this.children[cIndex] == null) {
				this.children[cIndex] = new Node();
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

public class trie_matching implements Runnable {
	
	// Static variables
	Node root;
	
	trie_matching() {
		root = new Node();
	}
	
	private void insertText(String text) {
		
		for(int i = 0; i < text.length(); i++) {
			root.insertSuffix(text.substring(i), i);
		}
		
	}
	
	int letterToIndex (char letter)
	{
		switch (letter)
		{
			case 'A': return 0;
			case 'C': return 1;
			case 'G': return 2;
			case 'T': return 3;
			default: assert (false); return Node.NA;
		}
	}

	List <Integer> solve (String text, int n, List <String> patterns) {
		
		List <Integer> result = new ArrayList <Integer> ();
		this.insertText(text); // Build trie
		
		for(String pat: patterns) {
			
			ArrayList<Integer> indList = root.search(pat);
			
			if(indList == null || indList.size() == 0) {
				// Do nothing
			}
			else {
				for(Integer i: indList) {
					result.add(i - pat.length());
				}
			}
		}
		
		//Collections.sort(result);
		return result;
	}

	public void run () {
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			String text = in.readLine ();
		 	int n = Integer.parseInt (in.readLine ());
		 	List <String> patterns = new ArrayList <String> ();
			for (int i = 0; i < n; i++) {
				patterns.add (in.readLine ());
			}

			List <Integer> ans = solve (text, n, patterns);

			for (int j = 0; j < ans.size (); j++) {
				System.out.print ("" + ans.get (j));
				System.out.print (j + 1 < ans.size () ? " " : "\n");
			}
		}
		catch (Throwable e) {
			e.printStackTrace ();
			System.exit (1);
		}
	}

	public static void main (String [] args) {
		new Thread (new trie_matching ()).start ();
	}
}

