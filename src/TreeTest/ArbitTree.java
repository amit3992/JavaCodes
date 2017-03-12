package TreeTest;
import java.util.*;


public class ArbitTree {
	
	ArbitNode root;
	
	ArbitNode createTree(int parents[], int n) {
		
		System.out.println("Inside create tree");
		System.out.println("=====================================");
		ArbitNode[] created = new ArbitNode[n];
		
		for (int i = 0; i < n; i++) {
			created[i] = null;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println("\nConsider index -> " + i);
			createNode(parents, i, created);
		}
		
		return root;
	}
	
	void createNode(int [] parent, int i, ArbitNode created[]) {
		
		System.out.println( i + " is the child of node -> " + parent[i]);
		
		if(created[i] != null) {
			System.out.println("Already created! "+ created[i].toString());
			return;
		}
		
		created[i] = new ArbitNode(i);
		
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
		ArbitNode p = created[parent[i]];
		System.out.println();
		System.out.println("Parent of " + i + " = "  + parent[i] + ", which is " + p.toString());
		// Check if this is first child of parent
		if(p.isChildCreated(created[i])) {
			System.out.println("Child already created!");
		}
		else {
			System.out.println(created[i].key + " is not created as a child. "+ "Adding child -> " + created[i].key + " to the parent -> " + p.key);
			p.addChild(created[i]);
		}
		
	}
	
	
	//For adding new line in a program
    void newLine() 
    {
        System.out.println("");
    }
    
  
    private void walk(ArbitNode element, List<ArbitNode> list) {
        list.add(element);
        for (ArbitNode data : element.getChildrenList()) {
            walk(data, list);
        }
    }
    
    public int getTreeHeight(ArbitNode node) {
    	// Base case
		if(node == null)
			return 0;
		
		
		Queue<ArbitNode> q = new LinkedList<ArbitNode>();
		
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
				
				System.out.println("Apple Queue contents: " + q.toString());
				ArbitNode newNode = q.peek();
				q.remove();
				
				if(newNode == null) {
					System.out.println("I am null");
					break;
				}
				
				if(newNode.children != null && !newNode.children.isEmpty()) {
					
					for(int i = 0; i < newNode.children.size(); ++i) {
						q.add(newNode.children.get(i));
					}
					
					System.out.println("Buffalo queue contents: " + q.toString());
				}
				
				nodeCount--;
			}
		}
    }
	
  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArbitTree tree = new ArbitTree();
        int parent[] = new int[]{-1, 0, 4, 0, 3};
		//int parent[] = new int[]{4, -1, 4, 1, 1};
		//int parent[] = new int[]{9, 7, 5, 5, 2, 9, 9, 9, 2, -1};
		//int parent[] = new int[]{8, 8, 8, 8, 8, 8, 8, 8, -1, 8};
        int n = parent.length;
        System.out.println("=====================================");
        ArbitNode node = tree.createTree(parent, n);
        //System.out.println("Inorder traversal of constructed tree ");
        //tree.inorder(node);
        tree.newLine();
        List<ArbitNode> list = new ArrayList<ArbitNode>();
        tree.walk(node, list);
        System.out.println(list);
        System.out.println("Ht: " + tree.getTreeHeight(node));

	}

}
