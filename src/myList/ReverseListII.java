package myList;
import java.util.*;

public class ReverseListII {
	
	public Node reverseList(Node head, int m, int n) {
		if(head == null) {
			return null;
		}
		
		Node dummy = new Node(0); // Dummy node
		dummy.next = head;
		
		Node pre = dummy;
		
		for(int i = 0; i < (m-1); i++) {
			pre = pre.next;
		}
		/*a pointer to the beginning of a sub-list that will be reversed */
		Node start = pre.next;
		
		/* a pointer to a node that will be reversed */
		Node then = start.next;
		
		// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		// dummy-> 1 -> 2 -> 3 -> 4 -> 
		
		for(int i = 0; i < (n - m); i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}
		
		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
	    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
		
		return dummy.next;
		
		
	}

	public static void main(String[] args) {
		
		MyList ll = new MyList();
		ReverseListII r = new ReverseListII();
		
		ll.head = new Node(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		ll.insertAtEnd(7);
		
		
		ll.printList();
		
		System.out.println();
		Node revNode = r.reverseList(ll.head, 2, 4);
		
		while(revNode != null) {
			System.out.print(revNode.data + " ");
			revNode = revNode.next;
		}
		
	}

}
