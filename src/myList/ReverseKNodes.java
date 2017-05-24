package myList;

public class ReverseKNodes {
	
	public Node reverseKNodes(Node head, int k) {
		Node begin = null;
		
		if(head == null || head.next == null || k == 1) {
			return head;
		}
		
		Node dummy = new Node(-1);
		dummy.next = head;
		begin = dummy;
		
		int i = 0;
		while(head != null) {
			i++;
			
			if(i % k == 0) {
				begin = reverse(begin, head.next);
				head = head.next;
				i = 0;
			} else {
				head = head.next;
			}
		}
		
		return dummy.next;
	}
	
	public Node reverse(Node begin, Node end) {
		
		Node current = begin.next;
		Node next = null;
		Node first = null;
		Node prev = begin;
		
		first = current;
		
		while(current != end) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		begin.next = prev;
		first.next = current;
		
		return first;
	}
	
	public static void main(String[] args) {
		
		MyList ll = new MyList();
		ll.head = new Node(0);
		ll.insertAtEnd(1);
		ll.insertAtEnd(2);
		ll.insertAtEnd(3);
		ll.insertAtEnd(4);
		/*ll.insertAtEnd(5);
		ll.insertAtEnd(6);
		ll.insertAtEnd(7);
		ll.insertAtEnd(8);
		ll.insertAtEnd(9);
		ll.insertAtEnd(10);*/
		
		ll.printList();
		ReverseKNodes r = new ReverseKNodes();
		System.out.println();
		
		System.out.println("Reversed list -> ");
		ll.head = r.reverseKNodes(ll.head, 2);
		ll.printList();
		

	}

}
