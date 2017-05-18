package dataStructures.Trie;
import java.util.*;

class tNode {
	char ch;
	HashMap<Character, tNode> children;
	boolean endOfWord;
	int size = 0;
	
	tNode() {
		children = new HashMap<Character, tNode>();
		endOfWord = false;
	}
	
	public tNode getChild(char ch) {
		return this.children.get(ch);
	}
}

class TrieClass {
	
	tNode root = new tNode();
	
	public void addWord(String word) {
		tNode current = root;
		
		for(int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			
			tNode node = current.getChild(ch);
			if(node == null) {
				node = new tNode();
				current.children.put(ch, node);
			}
			
			current = current.getChild(ch);
			current.size++;
		}
		
		current.endOfWord = true;
	}
	
	public String passwordCheck(String pw) {
		
		StringBuilder sb = new StringBuilder();
		StringBuilder word = new StringBuilder();
		
		tNode current = root;
		
		for(int i = 0; i < pw.length(); i++) {
			Character ch = pw.charAt(i);
			
			tNode node = current.getChild(ch);
			
			if(node != null) {
				
				if(node.endOfWord) {
					word.append(ch);
					sb.append(word.toString());
					sb.append(" ");
					word = new StringBuilder();
					current = root;
				} else {
					word.append(ch);
					current = node;
				}
			} else {
				return "WRONG PASSWORD";
			}
			
		}
		
		return sb.toString();
	}
	
}

public class PasswordCracker {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		
		TrieClass t = new TrieClass();
		
		while(q-- > 0) {
			int n = sc.nextInt();
			
			while(n-- > 0) {
				String word = sc.next();
				t.addWord(word);
			}
			
			String pw = sc.next();
			System.out.println(t.passwordCheck(pw));
		}

	}

}
