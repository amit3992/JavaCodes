package myList;

public class ReverseKNodes {
	
	public Node reverseKNodes(Node head, int k) {
		
				  // if k is 0 or 1, then list is not changed
				  if (k <= 1 || head == null) {
				    return head;
				  }

				  Node reversed = null;
				  Node prev_tail = null;

				  while (head != null && k > 0) {
				    Node current_head = null;
				    Node current_tail = head;

				    int n = k;
				    while (head != null && n > 0) {
				      Node temp = head.next;
				      head.next = current_head;
				      current_head = head;

				      head = temp;
				      n--;
				    }

				    if (reversed == null) {
				      reversed = current_head;
				    }

				    if (prev_tail != null) {
				      prev_tail.next = current_head;
				    }
				    prev_tail = current_tail;
				  }

				  return reversed;

	}
	public static void main(String[] args) {
		
		MyList ll = new MyList();
		ll.head = new Node(0);
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		ll.insertAtEnd(7);
		
		ll.printList();
		ReverseKNodes r = new ReverseKNodes();
		System.out.println();
		
		System.out.println("Reversed list -> ");
		ll.head = r.reverseKNodes(ll.head, 3);
		ll.printList();
		

	}

}
