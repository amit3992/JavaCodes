package myDoublyLinkedList;

public class Node<E> {
	
	E element;
	Node prev;
	Node next;
	
	Node(E element, Node next, Node prev) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	

}
