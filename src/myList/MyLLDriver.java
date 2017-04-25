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
		//System.out.println("\nNode count -> " + ll.getNodeCount());
		
		
		Node n = ll.getHead();
		Node m = ll.reverse(n);
		Node p = ll.oddEvenList(n);
		Node r = ll.reverseK(n, 2);
		
		System.out.println("\nREVERSED LIST");
		while(m != null) {
			System.out.print(m.data + " ");
			m = m.next;
		}
		System.out.println();
		
		System.out.println("\nREVERSEd K LIST");
		while(r != null) {
			System.out.print(r.data + " ");
			r = r.next;
		}
		System.out.println();
		
		
		
		
		
	}

}
