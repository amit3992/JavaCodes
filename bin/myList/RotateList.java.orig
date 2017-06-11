package myList;
<<<<<<< HEAD
import java.util.*;

public class RotateList {
	
	public Node rotateList(Node head, int k) {
		
		if(head == null) {
			return null;
		}
		
		if(k == 0) {
			return head;
		}
		
		Node current = head;
		Node kNode = null;
		int count = 1;
		
		while(count < k && current != null) {
			current = current.next;
			count++;
		}
		
		if(current == null) {
			return null;
		} else {
			kNode = current;
		}
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = head;
		
		head = kNode.next;
		
		kNode.next = null;
		
		return head;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MyList ll = new MyList();
		ll.head = new Node(1);
=======

public class RotateList {
	
	public static int findLength(Node head) {
		
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		
		return count;
	}
	
	public int adjustRotations(int len, int k) {
		k = k % len;
		
		if(k < 0) {
			k = k + len;
		}
		
		return k;
	}

	public Node rotateList(Node head, int k) {
		
		if(head == null) {
			return null;
		}
		
		/* Step 1: Find length */
		int len = findLength(head);
		
		/* Adjust rotations */
		int n = adjustRotations(len, k);
		
		/* Rotate list */
		if(n == 0) {
			return head;
		}
		
		/* Find the start of rotated list */
		int startCount = len - n - 1;
		Node temp = head;
		while(temp != null && startCount > 0) {
			startCount--;
			temp = temp.next;
		}
		
		Node newHead = temp.next;
		temp.next = null;
		
		temp = newHead;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = head;
		
		return newHead;
		
	}
	public static void main(String[] args) {
		
		MyList ll = new MyList();
		ll.head = new Node(0);
		ll.insertAtEnd(1);
>>>>>>> code updates
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
<<<<<<< HEAD
		
		int k = sc.nextInt();
		
		sc.close();
		
		ll.printList();
		
		RotateList rl = new RotateList();
		
		ll.head = rl.rotateList(ll.head, k);
		System.out.println("Rotated list -> ");
=======
		ll.insertAtEnd(7);
		
		System.out.println("Original list -> ");
		ll.printList();
		
		RotateList rl = new RotateList();
		ll.head = rl.rotateList(ll.head, 2);
		System.out.println("\nRotated list ->");
>>>>>>> code updates
		ll.printList();

	}

}
