package dataStructures.TST;

public class Node {
	
	char data;
	
	boolean isEndOfString;
	
	Node left;
	Node mid;
	Node right;
	
	Node() {
		
		this.isEndOfString = false;
		this.left = null;
		this.mid = null;
		this.right = null;
		this.data = '#';
	}
	
	Node(char data) {
		this.data = data;
		this.isEndOfString = false;
		this.left = null;
		this.mid = null;
		this.right = null;
	}

}
