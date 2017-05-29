package myList;
import java.util.*;

class ListNode {
	int data;
	ListNode next;
	ListNode random;
	
	ListNode(int data) {
		this.data = data;
		next = null;
		random = null;
	}
}

public class CopyLinkedList {
	
	public void printList(ListNode head) {
		
		if(head == null) {
			return;
		}
		//System.out.println();
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
	
	
	public ListNode copyListMap(ListNode head) {
		
		if(head == null) {
			return null;
		}
		
		HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
		
		ListNode current = head;
		ListNode newHead = null;
		ListNode newCurrent = null;
		
		while(current != null) {
			ListNode newNode = new ListNode(current.data);
			newNode.random = current.random;
			
			if(newCurrent != null) {
				newCurrent.next = newNode;
			} else {
				newHead = newNode;
			}
			
			map.put(current, newNode);
			newCurrent = newNode;
			current = current.next;
		}
		
		newCurrent = newHead;
		
		while(newCurrent != null) {
			
			if(newCurrent.random != null && map.containsKey(newCurrent.random)) {
				ListNode temp = map.get(newCurrent.random);
				newCurrent.random = temp;
			} else {
				newCurrent.random = null;
			}
			
			newCurrent = newCurrent.next;
		}
		
		return newHead;
		
	}
	
	public ListNode copyList(ListNode head) {
		
		if(head == null) {
			return null;
		}
		
		ListNode current = head;
		
		/* Create new nodes */
		while(current != null) {
			ListNode newNode = new ListNode(current.data);
			newNode.next = current.next;
			current.next = newNode;
			current = newNode.next;
		}
		
		/* Set correct arbitrary pointers */
		current = head;
		while(current != null) {
			
			if(current.random != null) {
				current.next.random = current.random.next;
			} else {
				current.next.random = null;
			}
	
			current = current.next.next;
		}
		
		/* Separate lists */
		current = head;
		ListNode newHead = head.next;
		ListNode newCurrent = newHead;
		
		while(current != null) {
			newCurrent = current.next;
			current.next = newCurrent.next;
			
			if(newCurrent.next != null) {
				newCurrent.next = newCurrent.next.next;
			}
			
			current = current.next;
		}
		
		return newHead;
		
	}

	public static void main(String[] args) {
		
		ListNode head = new ListNode(7);
		ListNode node1 = new ListNode(14);
		ListNode node2 = new ListNode(21);
		ListNode node3 = new ListNode(28);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		
		head.random = node2;
		node1.random = null;
		node2.random = node1;
		node3.random = head;
		
		CopyLinkedList cll = new CopyLinkedList();
		System.out.println("Original list -> ");
		cll.printList(head);
		
		ListNode newNode = cll.copyListMap(head);
		System.out.println("\nCopied list with hashmap -> ");
		cll.printList(newNode);
		
		ListNode newNode2 = cll.copyList(head);
		System.out.println("\nCopied list without hashmap -> ");
		cll.printList(newNode2);

	}

}


