package dataStructures.UnrolledLL;

public class UnrolledLLDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(3, 1, 2, 3);
		Node second = new Node(3, 4, 5, 6);
		Node third = new Node(3, 7, 8, 9);
		
		head.next = third;
		third.next = second;
		
		MyUnrolledLL ull = new MyUnrolledLL(head);
		ull.printUnrolledList(head);
	}

}
