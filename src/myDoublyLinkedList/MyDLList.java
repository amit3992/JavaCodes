package myDoublyLinkedList;
import java.util.*;

public class MyDLList<E> {
	
	// Variables
	private Node head;
	private Node tail;
	private int size;
	
	MyDLList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}
	
	// Methods
	public int getSize() {
		return this.size;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public Node getTail() {
		return this.tail;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	// Methods to add Nodes
	public void addFirst(E element) {
		Node newNode = new Node(element, head, null);
		if(head != null) {
			head.prev = newNode;
		}
		else {
			head = newNode;
		}
		
		if(tail == null) {
			tail = newNode;
		}
		
		this.size++;
		System.out.println("Adding node -> " + element + " at the head");
		
	}
	
	public void addLast(E element) {
		Node newNode = new Node(element, null, tail);
		if(tail != null) {
			tail.next = newNode;
		}
		else {
			tail = newNode;
		}
		
		if(head == null) {
			head = newNode;
		}
		
		this.size++;
		System.out.println("Adding node -> " + element + " at the tail");
	}
	
	// Iterate through the list;
	public void iterateForward() {
		
		Node current = head;
		if(current != null) {
			System.out.print(current.element + " ");
			current = current.next;
		}
	}
	
	// Iterate through the list;
	public void iterateBackward() {
			
			Node current = tail;
			if(current != null) {
				System.out.print(current.element + " ");
				current = current.prev;
			}
	}
	
	
	// Removing elements from the list
	public void removeFirst() throws Exception {
		if(head != null && tail != null) {
			Node thisNode = head;
			if(thisNode.next != null) {
				Node newHead = thisNode.next;
				newHead.prev = null;
				System.out.println("Removed from list -> " + thisNode.element);
			}
			else {
				head = null;
			}
			
			this.size--;
		}
		else {
			throw new Exception("List is empty!");
		}
		
		
		
		
	}
	
	public void removeLast() {
		if(head != null && tail != null) {
			Node thisNode = tail;
			
			Node prevNode = tail.prev;
			prevNode.next = null;
			this.size--;
			System.out.println("Removed from list -> " + thisNode.element);
		}
	}
}
