package BST;
import java.util.*;

public class PerimeterTree {
	
	public static void print_left_perimeter(Node root) {
		while(root != null) {
			
			int curr = root.key;
			
			if(root.left != null) {
				root = root.left;
			} else if(root.right != null) {
				root = root.right;
			} else {
				break; // leaf node
			}
			
			System.out.print(curr + " ");
		}
	}
	
	public static void print_right_perimeter(Node root) {
		Stack<Integer> st = new Stack<Integer>();
		
		while(root != null) {
			int curr = root.key;
			
			if(root.right != null) {
				root = root.right;
			} else if(root.left != null) {
				root = root.left;
			} else {
				break; // leaf
			}
			
			st.push(curr);
			
		}
		
		while(!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}
	
	public static void print_leaf_nodes(Node root) {
		if(root != null) {
			print_leaf_nodes(root.left);
			print_leaf_nodes(root.right);
			
			if(root.left == null && root.right == null) {
				System.out.print(root.key + " ");
			}
		}
	}
	
	public static void display_tree_perimeter(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.key + " ");
		
		print_left_perimeter(root.left);
		
		if(root.left != null || root.right != null) {
			print_leaf_nodes(root);
		}
		
		print_right_perimeter(root.right);
	}

	public static void main(String[] args) {
		
		Node root1 = new Node(100);
		root1.left = new Node(50);
		root1.left.left = new Node(25);
		root1.left.left.right = new Node(30); 
		root1.left.right = new Node(75);
		root1.left.right.left = new Node(60);
		root1.right = new Node(200);
		root1.right.left = new Node(125);
		root1.right.right = new Node(350);
		
		display_tree_perimeter(root1);

	}

}
