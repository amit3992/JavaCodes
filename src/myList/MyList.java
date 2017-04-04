package myList;
import java.util.*;

public class MyList {

	// Variables
	Node head;
	int nodeCount;
	
	// Methods
	public MyList() {
		head = null;
		nodeCount = 0;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insertAtHead(int data) {
		
		head = new Node(data,head);
		nodeCount++;
	}
	
	public int getHeadData() {
		return head.data;
	}
	
	public int popFirst() {
		int temp = head.data;
		head = head.next;
		nodeCount--;
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
		nodeCount++;
	}
	
	public void insertAfter(Node prev_node, int data) {
		Node n = new Node(data);
		
		n.next = prev_node.next;
		prev_node.next = n;
		
		nodeCount++;
		
	}
	
	public void insertAtPosition(int pos, int data) throws Exception {
		
		Node temp = new Node(data);
		Node thisNode = head;
		Node prev = null;
		
		if(pos == 0) {
			insertAtHead(data);
		}
		
		if(pos > nodeCount) {
			throw new Exception("POS cannot be bigger than size!");
		}
		
		while(pos > 0 && thisNode != null) {
			prev = thisNode;
			thisNode = thisNode.next;
			pos--;
		}
		
		prev.next = temp;
		temp.next = thisNode;
		
		nodeCount++;
		
	}
	
	public int getNodeCount() {
		return nodeCount;
	}
	
	public boolean deleteNode(int key) {
		
		Node thisNode = head;
		Node prevNode = null;
		boolean flag = false;
	
		while(thisNode != null && !flag) {
			
			prevNode = thisNode;
			thisNode = thisNode.next;
			
			if(thisNode != null && thisNode.data == key) {
				flag = true;
			}
		
		}
		
		if(!flag) {
			System.out.println("KEY NOT FOUND!");
			return false;
		}
		if(thisNode == null) {
			return false;
		}
		else {
			nodeCount--;
			prevNode.next = thisNode.next;
			return true;
		}
	}
	
	public void deleteKeyAtPosition(int pos) {
		
		if(pos == 0) {
			popFirst();
		}
		
		if(pos > nodeCount) {
			System.out.println("NOT ENOUGH ELEMENTS IN LIST");
			return;
		}
		
		Node prevNode = null;
		Node thisNode = head;
		
		while(thisNode != null && pos > 0) {
			prevNode = thisNode;
			thisNode = thisNode.next;
			pos--;
		}
		
		prevNode.next = thisNode.next;
		nodeCount--;
	}
	
	public MyList reverse() {
		
		MyList newList = new MyList();
		
		Node thisNode = head;
		while(thisNode != null) {
			int n = popFirst();
			newList.insertAtHead(n);
		}
		
		return newList;
	}
	
	public void printList() {
		Node thisNode = head;
		
		while(thisNode != null) {
			System.out.print(thisNode.data + " ");
			thisNode = thisNode.next;
		}
	}
	
	
}
