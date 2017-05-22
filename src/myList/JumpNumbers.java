package myList;
import java.util.*;

public class JumpNumbers {
	int count = 0;
	int jumpVal = 0;
	
	public int countJumps(Node head) {
		if(head == null) {
			return 0;
		}
		Node current = head;
		jumpVal = current.data;
		
		if(jumpVal == 0) {
			return -1;
		}
		
		Node newNode = travel(current, jumpVal);
		
		while(newNode != null) {
			jumpVal = newNode.data;
			if(jumpVal == 0) {
				return -1;
			}
			newNode = travel(newNode, jumpVal);
		}
		
		return count;
	}
	
	public Node travel(Node pointer, int jumps) {
		if(pointer == null) {
			return null;
		}
		
		if(jumps == 0) {
			return null;
		}
		
		Node current = pointer;
		
		while(current != null && jumps-- > 0) {
			current = current.next;
		}
		
		count++;
		return current;
	}

	public static void main(String[] args) {
		
		MyList ll = new MyList();

		ll.head = new Node(9);

		
		ll.printList();
		
		JumpNumbers jump = new JumpNumbers();
		System.out.println("\nNumber of jumps -> " + jump.countJumps(ll.head));
		
		

	}

}
