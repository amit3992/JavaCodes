package dataStructures.UnrolledLL;
import java.util.*;

public class MyUnrolledLL {
	
	Node head;
	
	public MyUnrolledLL(Node node) {
		head = node;
	}
	
	void printUnrolledList(Node node) {
		
		System.out.println("printing unrolled list");
		
		while(node != null) {
			for(int i = 0; i < node.numElements; i++) {
				System.out.print(node.arr[i] + " ");
			}
			
			node = node.next;
		}
	}

}
