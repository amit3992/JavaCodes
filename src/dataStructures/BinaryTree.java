package dataStructures;

import java.util.*;


class TreeNode {
	
	int data;
	TreeNode left, right;
	
	TreeNode(int data) {
		this.data = data;
		left = right;
	}
}


public class BinaryTree {
	
	TreeNode root;
	
	int getTreeHeight(TreeNode node) {
		
		// Base case
		if(node == null)
			return 0;
		
		
		Queue<TreeNode> q = new LinkedList();
		
		//Enqueue node
		q.add(node);
		int ht = 0;
		
		while(true) {
			
			int nodeCount = q.size();
			
			if(nodeCount == 0)
				return ht;
			
			ht++;
			
			// Dequeue all nodes at current level and add other nodes
			while(nodeCount > 0) {
				
				TreeNode newNode = q.peek();
				q.remove();
				
				if(newNode.left != null)
					q.add(newNode.left);
				if(newNode.right != null)
					q.add(newNode.right);
				
				nodeCount--;
			}
		}
		
		
	}
	
	// Driver program to test above functions
    public static void main(String args[]) 
    {
        BinaryTree tree = new BinaryTree();
        
        // Let us create a binary tree shown in above diagram
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        System.out.println("Height of tree is " + tree.getTreeHeight(tree.root));
        
    }
		
	
}
