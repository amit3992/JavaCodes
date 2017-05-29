package myList;

public class MergeTwoSorted {
	
	public Node merge(Node head1, Node head2) {
		
		if(head1 == null || head2 == null) {
			return null;
		} else if(head1 == null) {
			return head2;
		} else if(head2 == null) {
			return head1;
		}
		
		Node mergedHead = null;
		Node mergedTail = null;
		
		if(head1.data <= head2.data) {
			mergedHead = head1;
			head1 = head1.next;
		} else {
			mergedHead = head2;
			head2 = head2.next;
		}
		
		mergedTail = mergedHead;
		
		/*Combine two lists s*/
		while(head1 != null && head2 != null) {
			Node temp = null;
			
			if(head1.data <= head2.data) {
				temp = head1;
				head1 = head1.next;
			} else {
				temp = head2;
				head2 = head2.next;
			}
			
			mergedTail.next = temp;
			mergedTail = temp;
		}
		
		/* Combine the rest of the list */
		while(head1 != null) {
			mergedTail.next = head1;
			mergedTail = head1;
			head1 = head1.next;
		}
		
		while(head2 != null) {
			mergedTail.next = head2;
			mergedTail = head2;
			head2 = head2.next;
		}
		
		return mergedHead;
		
		
	}

	public static void main(String[] args) {
		
		MyList l1 = new MyList();
		MyList l2 = new MyList();
		
		l1.insertAtHead(4);
		l1.insertAtEnd(8);
		l1.insertAtEnd(15);
		l1.insertAtEnd(19);
		l1.insertAtEnd(22);
		
		l2.insertAtHead(7);
		l2.insertAtEnd(9);
		l2.insertAtEnd(10);
		l2.insertAtEnd(16);
		
		System.out.println("List 1 -> ");
		l1.printList();
		
		System.out.println("\nList 2 -> ");
		l2.printList();
		
		MergeTwoSorted ms = new MergeTwoSorted();
		
		MyList sortedList = new MyList();
		sortedList.head = ms.merge(l1.head, l2.head);
		System.out.println("\nMerged List -> ");
		sortedList.printList();
		
	}

}
