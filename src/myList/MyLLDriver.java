package myList;

public class MyLLDriver {
	
	public static void main(String[] args) throws Exception {
		MyList ll = new MyList();
		ll.insertAtHead(1);
		ll.insertAtEnd(2);
		ll.insertAtHead(4);
		ll.insertAtEnd(3);
		ll.insertAfter(ll.head.next, 5);
		ll.insertAtPosition(2,6);
		
		//ll.deleteKeyAtPosition(3);
		
		ll.printList();
		System.out.println("\nNode count -> " + ll.getNodeCount());
		
		
		Node n = ll.getHead();
		Node m = ll.reverse(n);
		
		System.out.println("REVERSED LIST");
		while(m != null) {
			System.out.print(m.data + " ");
			m = m.next;
		}
		System.out.println();
		
	}

}
