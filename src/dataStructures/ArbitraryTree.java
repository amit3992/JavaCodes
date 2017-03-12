package dataStructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Node2 {
	
	public int key;
	ArrayList<Node2> children = new ArrayList<Node2>();
	
	public Node2(int key) {
		this.key = key;
	}
	
	public Collection<Node2> getChildren() {
		return Collections.unmodifiableCollection(this.children);
	}
	
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		
		if (object == null || object.getClass() != getClass()) {
	        result = false;
	    } else {
	        Node2 node = (Node2) object;
	        if (this.key == node.key) {
	            result = true;
	        }
	    }
		return result;
		
	}
	
	void addChild(Node2 child) {
		
		if(this.children.isEmpty()) {
			System.out.println(this.key + " has no children. Creating a new list of children for node -> " + this.key);
			//this.children = new ArrayList<Node2>();
			this.children.add(child);
			System.out.println(child.key + " added as a child to node -> " + this.key);
		}
		else {
			System.out.println(this.key + " already has children = " + getChildren());
			
			// CHECK WHY THIS CONDITION IS FAILING
			if(this.children.contains(child)) {
				System.out.println("Child found! No need to add again");
			}
			else {
				System.out.println("Child not found!");
				this.children.add(child);
				System.out.println(child.key + " added as a child to node -> " + this.key);
				
			}
			
		}
	}
	
	public boolean isChildCreated(Node2 child) {
		System.out.println("Existing children -> " + getChildren());
		if(this.children.contains(child)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString ()
    {
        return "Node key value -> " + this.key;
    }
	
}

public class ArbitraryTree {
	
	Node2 root;
	
	Node2 createTree(int parents[], int n) {
		
		System.out.println("Inside create tree");
		Node2[] created = new Node2[n];
		
		for (int i = 0; i < n; i++) {
			created[i] = null;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println("\nConsider index -> " + i);
			createNode(parents, i, created);
		}
		
		return root;
	}
	
	void createNode(int [] parent, int i, Node2 created[]) {
		
		System.out.println( i + " is the child of node -> " + parent[i]);
		
		if(created[i] != null) {
			System.out.println("Already created! "+ created[i].toString());
		}
		
		created[i] = new Node2(i);
		
		if(parent[i] == -1) {
			root = created[i];
			System.out.println(created[i].toString() + " is root.");
			return;
		}
		
		//If parent is not created, create a parent
		if(created[parent[i]] == null) {
			System.out.println("-----------------------------------------------");
			System.out.println("But node " + parent[i] + " is not created yet.");
			//System.out.println("Parent of parents[" + i + "] -> "  + parent[i] + " not created!");
			createNode(parent, parent[i], created);
		}
			
		// Find parent pointer
		Node2 p = created[parent[i]];
		System.out.println("Parent of " + i + " = "  + parent[i] + ", which is " + p.toString());
		// Check if this is first child of parent
		if(p.isChildCreated(created[i])) {
			System.out.println("Child already created!");
		}
		else {
			System.out.println("Child not created. Adding child -> " + created[i].key);
			p.addChild(created[i]);
		}
		
	}
	
	
	//For adding new line in a program
    void newLine() 
    {
        System.out.println("");
    }
  
    int getTreeHeight(Node2 node) {
    	// Base case
		if(node == null)
			return 0;
		
		
		Queue<Node2> q = new LinkedList();
		
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
				
				Node2 newNode = q.peek();
				q.remove();
				
				if(!newNode.children.isEmpty()) {
					
					for(int i = 0; i < newNode.children.size(); ++i) {
						System.out.println(newNode.children.get(i));
						q.add(newNode.children.get(i));
					}
				}
				
				nodeCount--;
			}
		}
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbitraryTree tree = new ArbitraryTree();
        int parent[] = new int[]{-1, 0, 4, 0, 3};
		//int parent[] = new int[]{4, -1, 4, 1, 1};
        int n = parent.length;
        System.out.println("=====================================");
        Node2 node = tree.createTree(parent, n);
        //System.out.println("Inorder traversal of constructed tree ");
        //tree.inorder(node);
        tree.newLine();
        //System.out.println("Ht: " + tree.getTreeHeight(node));
	}

}
