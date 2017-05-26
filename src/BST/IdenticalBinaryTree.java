package BST;
import java.util.*;


public class IdenticalBinaryTree {
	
	public static boolean areIndentical(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 != null && root2 != null) {
			return ((root1.key == root2.key) && areIndentical(root1.left, root2.left) && areIndentical(root1.right, root2.right));
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		Node root1 = new Node(100);
		root1.left = new Node(50);
		root1.left.left = new Node(25);
		root1.right = new Node(200);
		root1.right.left = new Node(125);
		root1.right.right = new Node(350);
		
		
		
		Node root2 = new Node(100);
		root2.left = new Node(50);
		root2.left.left = new Node(25);
		root2.right = new Node(200);
		// root2.right = new Node(2001); --> False
		root2.right.left = new Node(125);
		root2.right.right = new Node(350);
		
		System.out.println("Are the two trees identical -> " + areIndentical(root1, root2));

	}

}
