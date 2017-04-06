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
	
	public Node reverse(Node node) {
		
		if(node == null) {
			return null;
		}
		
		Node prev = null;
		Node current = node;
		Node next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current =  next;
		}
		node = prev;
		
		return node;
	}
	
	
	public Node mergeSortList(Node head) {
		if(head == null) {
			return null;
		}
		
		// Count elements in list.
		int count = 0;
		Node p = head;
		while(p != null) {
			count++;
			p = p.next;
		}
		
		// Get middle
		int middle = count/2;
		Node left = head;
		Node right = null;
		Node p2 = head;
		int countToMid = 0;
		
		while(p2 != null) {
			countToMid++;
			Node next = p2.next;
			
			if(countToMid == middle) {
				p2.next = null;
				right = next;
			}
			
			p2 = next;
		}
		
		// Recursively sort left and right
		Node node1 = mergeSortList(left);
		Node node2 = mergeSortList(right);
		
		// Merge the two nodes
		Node mergedNode = merge(node1, node2);
		
		return mergedNode;
	}
	
	private Node merge(Node left, Node right) {
		
		Node p1 = left;
		Node p2 = right;
		
		Node fakeHead = new Node(100);
		Node pNew;
		
		pNew = fakeHead;
		
		while(p1 != null || p2 != null) {
			if(p1 == null) {
				pNew.next = new Node(p2.data);
				p2 = p2.next;
				pNew = pNew.next;
			}
			
			else if(p2 == null) {
				pNew.next = new Node(p1.data);
				p1 = p1.next;
				pNew = pNew.next;
			}
			else {
				if(p1.data < p2.data) {
					pNew.next = new Node(p1.data);
					p1 = p1.next;
					pNew = pNew.next;
				}
				else if(p1.data == p2.data) {
					pNew.next = new Node(p1.data);
					pNew.next.next = new Node(p1.data);
					pNew = pNew.next.next;
					p1 = p1.next;
					p2 = p2.next;
				}
				else {
					pNew.next = new Node(p2.data);
					p2 = p2.next;
					pNew = pNew.next;
				}
			}
		}
		
		return fakeHead.next;
	}
	
	
}
