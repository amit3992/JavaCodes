package myList;

class thisNode {
	int data;
	thisNode next;
	
	thisNode(int data) {
		this.data = data;
		next = null;
	}
}

public class AddTwoNumbers {
	
	thisNode head1, head2;
	
	/*Print list util*/
	void printList(thisNode node) {
		
		if(node == null) {
			return;
		}
		
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
	
	/*Add two lists*/
	thisNode add() {
		 
			thisNode first = head1;
			thisNode second = head2;
			
		  	thisNode res = null; // res is head node of the resultant list
	        thisNode prev = null;
	        thisNode temp = null;
	        int carry = 0, sum;
	 
	        while (first != null || second != null) //while both lists exist
	        {
	            // Calculate value of next digit in resultant list.
	            // The next digit is sum of following things
	            // (i)  Carry
	            // (ii) Next digit of first list (if there is a next digit)
	            // (ii) Next digit of second list (if there is a next digit)
	            sum = carry + (first != null ? first.data : 0)
	                    + (second != null ? second.data : 0);
	 
	            // update carry for next calulation
	            carry = (sum >= 10) ? 1 : 0;
	 
	            // update sum if it is greater than 10
	            sum = sum % 10;
	 
	            // Create a new node with sum as data
	            temp = new thisNode(sum);
	 
	            // if this is the first node then set it as head of
	            // the resultant list
	            if (res == null) {
	                res = temp;
	            } else // If this is not the first node then connect it to the rest.
	            {
	                prev.next = temp;
	            }
	 
	            // Set prev for next insertion
	            prev = temp;
	 
	            // Move first and second pointers to next nodes
	            if (first != null) {
	                first = first.next;
	            }
	            if (second != null) {
	                second = second.next;
	            }
	        }
	 
	        if (carry > 0) {
	            temp.next = new thisNode(carry);
	        }
	 
	        // return head of the resultant list
	        return res;
		
	}

	public static void main(String[] args) {
		
		AddTwoNumbers ll = new AddTwoNumbers();
		
		ll.head1 = new thisNode(7);
		ll.head1.next = new thisNode(5);
		ll.head1.next.next = new thisNode(9);
		ll.head1.next.next.next = new thisNode(4);
		ll.head1.next.next.next.next = new thisNode(6);
		
		ll.head2 = new thisNode(8);
		ll.head2.next = new thisNode(4);
		
		System.out.println("Add");
		ll.printList(ll.head1);
		System.out.println("+");
		ll.printList(ll.head2);
		
		System.out.println("=");
		thisNode sumNum = ll.add();
		ll.printList(sumNum);
		
	}

}
