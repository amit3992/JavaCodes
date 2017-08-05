package myList;

public class OddEvenList {
	
	public Node arrangeOddEven(Node head) {
		if(head == null) {
			return null;
		}
		
		Node evenList = head;
		Node oddPointer = head;
		Node evenHead = null;
		if(head.next != null) {
			evenHead = head.next;
		} else {
			return oddPointer;
		}
		
		while(oddPointer != null && oddPointer.next != null) {
			oddPointer.next = oddPointer.next.next;
			oddPointer = oddPointer.next;
			
			if(oddPointer != null) {
				System.out.println("odd Data -> " + oddPointer.data);
			}
		}
		
		evenList = evenHead;
		
		while(evenList != null && evenList.next != null) {
			evenList.next = evenList.next.next;
			evenList = evenList.next;
			
			if(evenList != null) {
				System.out.println("even Data -> " + evenList.data);
			}
		}
		
		return new Node(7);
		
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
		
		OddEvenList oll = new OddEvenList();
		oll.arrangeOddEven(ll.head);

	}

}
