package myList;

public class ReverseListI {
	
	public Node reverseList(Node head) {
		if(head == null && head.next == null) {
			return null;
		}
		
		Node pointNode = head.next;
		Node reversed = head;
		
		reversed.next = null;
		
		while(pointNode != null) {
			Node temp = pointNode;
			
			pointNode = pointNode.next;
			
			temp.next = reversed;
			reversed = temp;
			
		}
		
		
		return reversed;
	}

	public static void main(String[] args) {
		
		MyList ll = new MyList();
		Node head = new Node(7);
		ll.head = head;
		ll.insertAtEnd(28);
		ll.insertAtEnd(14);
		ll.insertAtEnd(17);
		ll.insertAtEnd(11);
		ll.insertAtEnd(6);
		
		ll.printList();
		
		ReverseListI rv = new ReverseListI();
		ll.head = rv.reverseList(ll.head);
		
		System.out.println("\nReversed list -> ");
		ll.printList();

	}

}
