package BST;
import java.util.*;
/*
 * hasNext()
 * getNext()
 * */
public class BinaryTreeIterator {
	
	Node root;
	Stack<Node> st;
	
	public BinaryTreeIterator(Node root) {
		this.root = root;
		st = new Stack<Node>();
		
		while(root != null) {
			st.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext() {
		return !st.isEmpty();
	}
	
	public Node getNext() {
		if(st.isEmpty()) {
			return null;
		}
		
		Node rVal = st.pop();
		Node temp = rVal.right;
		
		while(temp != null) {
			st.push(temp);
			temp = temp.left;
		}
		
		return rVal;
	}
	
	
	
	/* METHOD TO GET INORDER SUCCESSOR IN BST */
	
	public Node inOrderSuccessor(Node root, int data) {
		
		if(root == null) {
			return null;
		}
		
		Node successor = null;
		
		while(root != null) {
			if(root.key < data) {
				root = root.right;
			} else if(root.key > data) {
				successor = root;
				root = root.left;
			}
	
			else {
				if(root.right != null) {
					successor = findMin(root.right);
				}
				break;
			}
 		}
		
		return successor;
		
		
	}
	
	public Node findMin(Node root) {
		if(root == null) {
			return null;
		}
		
		while(root.left != null) {
			root = root.left;
		}
		
		return root;
	}
	
	

	public static void main(String[] args) {
		
		Node root1 = new Node(100);
		root1.left = new Node(50);
		root1.left.left = new Node(25);
		root1.left.right = new Node(75);
		root1.right = new Node(200);
		root1.right.left = new Node(125);
		root1.right.right = new Node(350);
		
		BinaryTreeIterator bii = new BinaryTreeIterator(root1);
		
		while(bii.hasNext()) {
			Node n = bii.getNext();
			System.out.print(n.key + " ");
		}

	}

}
