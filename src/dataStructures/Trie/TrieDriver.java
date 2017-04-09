package dataStructures.Trie;

public class TrieDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTrie trie = new MyTrie();
		trie.insert("abc");
		trie.insert("abcgl");
		trie.insert("cdf");
		trie.insert("cdfk");
		trie.insert("lmn");
		
		trie.insert("lem");
		trie.insert("hack");
		trie.insert("hackerrank");
		
		//System.out.println(trie.recursiveSearch("cdf"));
		//System.out.println(trie.search("ab"));
		System.out.println(trie.countSubstring("hac"));
		
		
		/*trie.insert("aab");
		trie.insert("defgab");
		trie.insert("abcde");
		trie.insert("aabcde");
		trie.insert("cedaaa");
		trie.insert("bbbbbbbbbb");
		trie.insert("jabjjjad");
		
		trie.checkSet();*/
	}

}
