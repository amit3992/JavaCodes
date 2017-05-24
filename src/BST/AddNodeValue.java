package BST;
import java.util.*;

/* http://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/ */

public class AddNodeValue {
	
	int sum = 0;
	
	public void addValues(Node root) {
		
		if(root == null) {
			return;
		}
		
		addValues(root.right);
		sum = sum + root.key;
		root.key = sum;
		addValues(root.left);
	}
	

	public static void main(String[] args) {
		
		Node root = new Node(50);
		root.left = new Node(30);
		root.right = new Node(70);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		
		root.right.left = new Node(60);
		root.right.right = new Node(80);
		
		BinaryTree bt = new BinaryTree();
		
		//bt.recursiveInOrder(root);
		
		AddNodeValue av = new AddNodeValue();
		av.addValues(root);
		
		bt.recursiveInOrder(root);
		
		
	}

}
