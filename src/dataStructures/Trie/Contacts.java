package dataStructures.Trie;
import java.util.*;

/*Hackerrank: Cracking the coding interview*/

class Node {
	char character;
	HashMap<Character, Node> children;
	int size = 0;
	
	Node() {
		children = new HashMap<Character, Node>();
	}
	
	public void putChildIfAbsent(char ch) {
		children.putIfAbsent(ch, new Node());
	}
	
	public Node getChild(char ch) {
		return children.get(ch);
	}
}

class Trie {
	
	Node root = new Node();
	
	Trie() {}
	
	public void addContact(String word) {
		Node current = root;
		
		for(int i = 0; i < word.length(); i++) {
			
			Character ch = word.charAt(i);
			Node child = current.children.get(ch);
			
			if(child == null) {
				child = new Node();
				current.children.put(ch, child);
			}
			
			current = current.getChild(ch);
			current.size++;
			
		}
	}
	
	public int findContact(String contact) {
		Node current = root;
		
		for(int i = 0; i < contact.length(); i++) {
			Character ch = contact.charAt(i);
			current = current.getChild(ch);
			
			if(current == null) {
				return 0;
			}
		}
		
		return current.size;
	}
	
	
}

public class Contacts {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Trie t = new Trie();
		
		while(n-- > 0) {
			String op = sc.next();
			String contact = sc.next();
			
			switch(op) {
				case "add" : t.addContact(contact);
							break;
				case "find": int val = t.findContact(contact);
							System.out.println(val);
							break;
				default: break;
			}
		}

	}

}
