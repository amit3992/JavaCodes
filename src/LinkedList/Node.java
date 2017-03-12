// Implementation of node

package LinkedList;

public class Node {
	
	private Object data;	// Object so that data can be anything
	public Node next;
	
	public Node() {
		next = null;	// Initialize next pointer to null
	}
	
	// Create a constructor with data
	public Node(Object data) {
		this.data = data;
	}
	
	// Create a constructor with data and next
		public Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	
	public Object getData() {
		return data;
	}

}
