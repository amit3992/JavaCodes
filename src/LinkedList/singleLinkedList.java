/*
 * Implementation of Single linked list
 *
 * Create a class Node with data, Next node and define a constructor
 *
 */

package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class singleLinkedList {
	private Node head;

	public singleLinkedList() {
		head = null; // Initialize head to null
	}

	// Checks if list is empty. List is empty if head points to null
	public boolean isEmpty() {

		if(head == null)
			return true;
		else
			return false;

		// Shorter implementation --> return head == null;
	}

	public void insertFirst(Object data) {
		/*Node NewNode = new Node(data);
		NewNode.next = head;
		this.head = NewNode;*/

		head = new Node(data,head);

	}

	// Return data in head of list
	public Object getFirstData() {
		return head.getData();
	}

	public Node getFirstNode() {
		return head;
	}

	// Remove first element in the list
	public Object removeFirst() {
		Object temp = getFirstData();
		head = head.next;
		return temp;
	}

	// Method to remove a node a particular postion
	public void removeNodeAt(int pos) {
		if(head == null)
			throw new IndexOutOfBoundsException();

		if(pos == 0) {
			removeFirst();
			return;
		}

		Node prevNode = null;
		Node currentNode = head;

		while(pos-1 > 0 && currentNode.next != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			pos--;
		}
		prevNode.next = currentNode.next;
	}

	// Insert new node at the end of list. This needs list traversal
	public void insertNodeAtEnd(Object newData) {
		if(head == null)
			insertFirst(newData);
		else {
			Node temp = head;
			// Traverse through a linked list.
			while(temp.next!= null) {
				temp = temp.next;
			}
			temp.next = new Node(newData,null);
		}
	}


	// Return last element of list
	public Object getLast() {
		if(head == null)
			throw new NoSuchElementException();

		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		return temp.getData();
	}

	// Remove all nodes of list
	public void clearList() {
		if(head == null) {
			System.out.println("List is already empty");
		}
		else {
			head = null;
		}

	}

	// Check if list contains an element
	public boolean contains(Object data) {
		Node temp = head;

		while(temp.next!=null) {
			if(temp.getData().equals(data))
				return true;
		}

		return false;
	}

	// Return data at a particular position

	public Object getDataAtPosition(int pos) {
		if(head == null)
			throw new IndexOutOfBoundsException();
		Node temp = head;
		while(pos > 0) {
			temp = temp.next;
			pos--;
		}
		return temp.getData();

	}

	// String representation of LL
	public String toString() {
		StringBuffer sb  = new StringBuffer();
		Node temp = head;
		while(temp != null) {
			sb.append(temp.getData()+" ");
			temp = temp.next;
		}


		return sb.toString().trim();
	}

	/*
	 * Insert a new node after a node containing a key
	 */
	public void insertAfter(Object key, Object insertThis) {
		Node temp = head;
		while(temp != null && !temp.getData().equals(key)) {
			temp = temp.next;
		}
		if(temp != null)
			temp.next = new Node(insertThis, temp.next);

	}

	// Insert a node before a node containing a key
	public void insertBefore(Object key, Object insertThis) {
		if(head == null)
			return;

		if(head.getData().equals(key))
			insertFirst(insertThis);

		Node prev = null;
		Node current = head;

		while(current != null && !current.getData().equals(key)) {
			prev = current;
			current = current.next;
		}

		if(current != null) {
			// Insert between current and previos
			prev.next = new Node(insertThis,current);
		}


	}

	// Insert a node at position 'pos'
	public void insertAt(Object insertThis, int pos) {
		Node newNode = new Node(insertThis,null);

		if(head == null)
			throw new IndexOutOfBoundsException();

		if(pos == 0) {
			insertFirst(insertThis);
			return;
		}


		Node prevNode = null;
		Node currentNode = head;

		while(pos - 1 > 0 && currentNode.next != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
			pos--;
		}
		newNode.next = currentNode;
		prevNode.next = newNode;

	}

	// Insert a node before a node containing a key
	public void remove(Object key)
	   {
	      if(head == null)
	         throw new RuntimeException("cannot delete");

	      if( head.getData().equals(key) )
	      {
	         head = head.next;
	         return;
	      }

	      Node cur  = head;
	      Node prev = null;

	      while(cur != null && !cur.getData().equals(key) )
	      {
	         prev = cur;
	         cur = cur.next;
	      }

	      if(cur == null)
	         throw new RuntimeException("cannot delete");

	      //delete cur node
	      prev.next = cur.next;
	   }


	 // =============================================== COPY METHODS FOR LLs =========================================================

	public singleLinkedList copy1() {
		// Complexity: O(n^2);

		singleLinkedList twin = new singleLinkedList();

		Node temp = head;

		while(temp != null) {
			twin.insertNodeAtEnd(temp.getData());
			temp = temp.next;
		}

		return twin;

	}


	public singleLinkedList copy2() {
		// Complexity: O(n);

		singleLinkedList twin = new singleLinkedList();

		Node temp = head;

		while(temp != null) {
			twin.insertFirst(temp.getData());
			temp = temp.next;
		}

		return twin.reverse();

	}


	public singleLinkedList reverse() {
		// TODO Auto-generated method stub
		singleLinkedList twin = new singleLinkedList();

		Node temp = head;

		while(temp != null) {
			twin.insertFirst(temp.getData());
			temp = temp.next;
		}

		return twin;
	}

	private void recursiveReverse(Node head) {
		if(head != null) {
			recursiveReverse(head.next);
			System.out.print(head.getData()+" ");
		}
	}


	/////   ========================== Iterator class =========================

	public Iterator iterator() {
		return new LinkedListIterator();
	}

	public class LinkedListIterator implements Iterator {
		private Node nextNode;

		public LinkedListIterator() {
			nextNode = head;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			while(nextNode != null) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			if(!hasNext()) throw new NoSuchElementException();
			{
				Object res = nextNode.getData();
				nextNode = nextNode.next;
				return res;
			}
		}

	}




   //// ================================ MAIN =================================
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		singleLinkedList list = new singleLinkedList();

		list.insertFirst("Patil");
		list.insertFirst("Rao");
		list.insertFirst("Anshul");
		list.insertFirst("Amit");

		System.out.println(list.toString());

		System.out.println(list.getDataAtPosition(2)); // Rao

		list.insertAfter("Amit","Rushi");

		System.out.println(list.toString());

		list.insertBefore("Rao", "Parth");

		System.out.println(list.toString());

		System.out.println("First data: "+list.getFirstData());
		System.out.println("Last data: "+list.getLast());

		list.insertNodeAtEnd("Omkar");

		System.out.println(list.toString());

		list.removeNodeAt(3);
		System.out.println(list.toString());

		list.insertAt("Thakur",0);
		System.out.println(list.toString());

		//System.out.println(list.reverse());

		//System.out.println(list.getFirstData());

		System.out.println("////// Recursively reversing the list");
		list.recursiveReverse(list.getFirstNode());


	}

}
