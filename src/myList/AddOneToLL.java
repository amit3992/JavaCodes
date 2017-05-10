package myList;

class Node1 {
	int data;
	Node1 next;
	
	Node1(int data) {
		this.data = data;
		next = null;
	}
}

public class AddOneToLL {
	
	Node1 head1;
	
	/*Print list util*/
	void printList(Node1 node) {
		
		if(node == null) {
			return;
		}
		
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	/*Add two lists*/
	Node1 addOne() {
		 Node1 node = head1;
		 
		 Node1 revNode = reverse(node);
		 
		 Node1 oneAddNode = addOneUtil();
		 
		 return reverse(oneAddNode);
	}
	
	Node1 addOneUtil() {
		
		Node1 head = head1;
		Node1 temp = null;
		Node1 res = head;
		
		int carry = 1;
		int sum = 0;
		
		while(head != null) {
			
			sum = carry + head.data;
			
			carry = (sum >= 10) ? 1 : 0;
			sum = sum % 10;
			
			head.data = sum;
			temp = head;
			head = head.next;
		}
		
		if (carry > 0)
	        temp.next = new Node1(carry);
	 
	    // return head of the resultant list
	    return res;
	}
	
	private Node1 reverse(Node1 node) {
		
		Node1 curr = node;
		Node1 prev = null;
		Node1 next = null;
		
		if(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = curr.next;
		}
		
		return prev;
	}

	public static void main(String[] args) {
		
		AddOneToLL ll = new AddOneToLL();
		
		ll.head1 = new Node1(1);
		ll.head1.next = new Node1(9);
		ll.head1.next.next = new Node1(9);
		ll.head1.next.next.next = new Node1(9);
		
		System.out.println("Add");
		ll.printList(ll.head1);
		
		System.out.println("=");
		Node1 sumNum = ll.addOne();
		ll.printList(sumNum);
		
	}

}

