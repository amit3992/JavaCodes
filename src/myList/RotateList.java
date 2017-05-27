package myList;
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
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		
		int k = sc.nextInt();
		
		sc.close();
		
		ll.printList();
		
		RotateList rl = new RotateList();
		
		ll.head = rl.rotateList(ll.head, k);
		System.out.println("Rotated list -> ");
		ll.printList();

	}

}
