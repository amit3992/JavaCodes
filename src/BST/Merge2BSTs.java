package BST;
import java.util.*;

public class Merge2BSTs {
	
	int[] inRoot1;
	int[] inRoot2;
	int[] inOrder;
	
	public Node mergeBSTs(Node root1, Node root2, int m, int n) {
		
		if(root1 == null && root2 == null) {
			return null;
		} else if(root1 == null) {
			return root2;
		} else if(root2 == null) {
			return root1;
		}
		
		inRoot1 = new int[m];
		inRoot2 = new int[n];
		
		/* STEPS */
		// 3-> Convert SortedArray to BST
		
		/* 1 -> Get inOrder traversals of both BSTs */
		storeInOrder(root1, inRoot1, 0);
		storeInOrder(root2, inRoot2, 0);
		
		/* 2 -> Merge two arrays */
		inOrder = new int[m + n];
		mergeArrays(inOrder, inRoot1, inRoot2);
		
		/* 3 -> Convert sortedArray to BST */
		int start = 0;
		int end = inOrder.length;
		Node newRoot = sortedArrayToBST(inOrder, start, end);
		
		return newRoot;
	}
	
	public void storeInOrder(Node root, int[] array, int index) {
		if(root == null) {
			return;
		}
		
		storeInOrder(root.left, array, index);
		
		array[index] = root.key;
		index++;
		
		storeInOrder(root.right, array, index);
	}
	
	public void mergeArrays(int[] result, int[] inA, int[] inB) {
		
		int aL = inA.length;
		int bL = inB.length;
		
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < aL && j < bL) {
			
			if(inA[i] < inB[j]) {
				result[k] = inA[i];
				i++;		
			} else {
				result[k] = inB[j];
				j++;
			}
			
			k++;
		}
		
		//If there are more elements in inA
		while(i < aL) {
			result[k] = inA[i];
			i++;
			k++;
		}
		
		//If there are more elements in inB
		while(j < bL) {
			result[k] = inB[j];
			j++;
			k++;
		}
	}
	
	public Node sortedArrayToBST(int[] in, int start, int end) {
		
		if(in.length == 0 || in == null) {
			return null;
		}
		
		if(start > end) {
			return null;
		}
		
		int mid = start + (end - start)/2;
		Node root = new Node(mid);
		
		/*Recursively construct left subtree */
		root.left = sortedArrayToBST(in, start, mid - 1);
		
		/* Rescursively construct right subtree */
		root.right = sortedArrayToBST(in, mid + 1, end);
		
		return root;
		
	}
	
	public void inOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		inOrderTraversal(root.left);
		System.out.print(root.key + " ");
		inOrderTraversal(root.right);
	}
	
	
	public static void main(String[] args) {
		
		/* BST 1*/
		Node root1 = new Node(100);
		root1.left = new Node(50);
		root1.right = new Node(300);
		root1.left.left = new Node(20);
		root1.left.right = new Node(70);
		
		/* BST 2*/
		Node root2 = new Node(80);
		root2.left = new Node(40);
		root2.right = new Node(120);
		
		Merge2BSTs m = new Merge2BSTs();
		
		Node newRoot = m.mergeBSTs(root1, root2, 5, 3);
		System.out.println("In-order traversal of new tree -> ");
		m.inOrderTraversal(newRoot);
		
	}

}
