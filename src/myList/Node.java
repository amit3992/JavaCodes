package myList;

public class Node {
	
	public int data;
	public Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
	
	Node(int data, Node node) {
		this.data = data;
		this.next  = node;
	}

}
