package dataStructures;
import java.util.*;

class Node {
	
	int key;
	Node left, right;
	
	public Node(int key) {
		this.key = key;
		left = right = null;
	}
	
}


public class BuildTree {
	
	Node root;
	
	void createNode(int [] parent, int i, Node created[]) {
		
		if(created[i] != null)
			return;
		
		created[i] = new Node(i);
		
		if(parent[i] == -1) {
			root = created[i];
			return;
		}
		
		//If parent is not created, create a parent
		if(created[parent[i]] == null)
			createNode(parent, parent[i], created);
		
		// Find parent pointer
		Node p = created[parent[i]];
		
		// Check if this is first child of parent
		if(p.left == null)
			p.left = created[i];
		else
			p.right = created[i];		
	}
	
	Node createTree(int parents[], int n) {
		
		// Create an array created[] to keep track
        // of created nodes, initialize all entries
        // as NULL
		Node[] created = new Node[n];
		
		for (int i = 0; i < n; i++) {
			created[i] = null;
		}
		
		for(int i = 0; i < n; i++) {
			createNode(parents, i, created);
		}
		
		return root;
	}
	
	//For adding new line in a program
    void newLine() 
    {
        System.out.println("");
    }
  
    // Utility function to do inorder traversal
    void inorder(Node node) 
    {
        if (node != null) 
        {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
    
    
    int getTreeHeight(Node node) {
    	// Base case
		if(node == null)
			return 0;
		
		
		Queue<Node> q = new LinkedList();
		
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
				
				Node newNode = q.peek();
				q.remove();
				
				if(newNode.left != null)
					q.add(newNode.left);
				if(newNode.right != null)
					q.add(newNode.right);
				
				nodeCount--;
			}
		}
    }
    public static void main(String args[]) {
    	
    	BuildTree tree = new BuildTree();
        int parent[] = new int[]{-1, 0, 4, 0, 3};
        int n = parent.length;
        Node node = tree.createTree(parent, n);
        System.out.println("Inorder traversal of constructed tree ");
        tree.inorder(node);
        tree.newLine();
        System.out.println("Ht: " + tree.getTreeHeight(node));
        
    }
}

//4 -1 4 1 1
