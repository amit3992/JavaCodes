package myList;
import java.util.*;

public class MyList {

	// Variables
	Node head;
	
	// Methods
	public MyList() {
		head = null;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insertAtHead(int data) {
		
		head = new Node(data);
	}
	
	public int getHeadData() {
		return head.data;
	}
	
	public int popFirst() {
		int temp = head.data;
		head = head.next;
		return temp;
	}
	
	public void insertAtEnd(int data) {
		
		if(head == null)
			head = new Node(data);
		
		Node temp = head;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = new Node(data);
	}
	
	
}
