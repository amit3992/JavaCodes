package BST;
import java.util.*;

public class AVLTree {
	
	Node root;
	
	// Util method to get height of tree
	public int getHeight(Node node) {
		if(node == null) {
			return 0;
		} else {
			return node.height;
		}
	}
	
	// Util method to get max of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	// Get balance factor of a node
	int getBalance(Node node) {
		if(node == null) {
			return 0;
		} else {
			return getHeight(node.left) - getHeight(node.right);
		}
	}
	
	// Util method for pre-order traversal
	void traversePreOrder(Node root) {
		if(root != null) {
			
			System.out.print(root.key + " ");
			traversePreOrder(root.left);
			traversePreOrder(root.right);
		}
	}
	
	// ==================================== AVL Rotation methods ======================================= //
	
	Node leftRotate(Node x) {
		
		Node y = x.right;
		Node T2 = y.left;
		
		// Perform rotation
		y.left = x;
		x.right = T2;
		
		// Update height
		x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
		
		// Return new root
		return y;
	}
	
	
	Node rotateRight(Node y) {
		
		Node  x = y.left;
		Node T2 = x.right;
		
		// Perform rotation
		x.right = y;
		y.left = T2;
		
		// Update height
		x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = max(getHeight(y.left), getHeight(y.right)) + 1;
		
		// Return new root
		return x;
		
	}
	
	
	// AVL Tree insertion
	Node insert(Node node, int key) {
		
		/* Step 1: Perform normal BST insertion */
		if(node == null) {
			return new Node(key);
		}
		
		if(key < node.key) {
			node.left = insert(node.left, key);
		} else if(key > node.key) {
			node.right = insert(node.right, key);
		} else {
			return node; //No duplicate keys allowed
		}
		
		/*Step 2: Update height of ancester node*/
		node.height = 1 + max(getHeight(node.left), getHeight(node.right));
		
		/*Step 3: Check the balance factor of this ancestor node is it's unbalanced*/
		int balance = getBalance(node);
		
		// If the node is unbalanced, we have 4 cases
		/*Case 1: Left Left case*/
		if(balance > 1 && key < node.left.key) {
			return rotateRight(node);
		}
		
		/*Case 2: Left Right case*/
		if(balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rotateRight(node);
		}
		
		/*Case 3: Right Right case*/
		if(balance < -1 && key > node.right.key) {
			return leftRotate(node);
		}
		
		/*Case 4: Right Left case*/
		if(balance < -1 && key < node.right.key) {
			node.right = rotateRight(node.right);
			return leftRotate(node);
		}
		
		
		/*Step 4: Return node*/
		return node;
	}
	
	

	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();
		
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);
		
		System.out.println("PreOrder Travesal of constructed tree ");
		tree.traversePreOrder(tree.root);
		
		
		
	}

}
