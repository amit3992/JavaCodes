package dataStructures.UnrolledLL;

public class Node {
	
	Node next;
	int numElements;
	int[] arr;
	
	Node(int numElements, int a, int b, int c) {
		this.numElements = numElements;
		arr = new int[this.numElements];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		next = null;
		
	}

}
