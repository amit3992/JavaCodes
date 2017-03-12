package TreeTest;

import java.util.*;
import java.io.*;

public class tree_height {
	
	// ===================================== Node class =====================================================//
	
	public class Node {

		//Variables
		public int key;
		//public List<Node> children;
		public HashMap<Integer, Node> children;
		
		public Node(int key) {
			this.key = key;
		}
		
		public HashMap<Integer, Node> getChildren() {
			
			if(this.children == null) {
				//return new ArrayList<Node>(10000);
				return new HashMap<Integer, Node>();
			}
			else
				return this.children;
		}
		
		public int getNumberOfChildren() {
			if(this.children == null)
				return 0;
			else
				return this.children.size();
		}
		
		public void addChild(Node child) {
			
			if(this.children == null) {
				children = new HashMap<Integer, Node>();
			}
			//this.children.add(child);
			int point = this.children.size();
			this.children.put(point, child);
			//System.out.println("Current children of Node -> " + this.key + " = " + this.getChildren());
		}	
		
		
		public boolean isChildCached(Node child) {
			//System.out.println("Existing children of " + this.key + " -> " + getChildren());
			if(this.children != null && this.children.containsKey(child.key)) {
				return true;
			}
			else {
				return false;
			}
		}
	
		public String toString() {
			return "Node key value -> " + this.key;
		}
		
		@Override
		public boolean equals(Object object) {
			boolean result = false;
			
			if (object == null || object.getClass() != getClass()) {
		        result = false;
		    } else {
		        Node node = (Node) object;
		        if (this.key == node.key) {
		            result = true;
		        }
		    }
			return result;
			
		}
		
	}
	
	// ============================================= Read Input class ==============================================// 
	
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
    
    
    
    // ============================================= Tree Builder ================================================== //
    
	public class TreeHeight {
		int n;
		int parent[];
		Node root;
		
		// Create arbitrary tree method
		Node buildTree(int parents[], int n) {
			
			//System.out.println("Inside create tree");
			//System.out.println("=====================================");
			Node[] cache = new Node[n];
			
			for (int i = 0; i < n; i++) {
				cache[i] = null;
			}
			
			for(int i = 0; i < n; i++) {
				//System.out.println("\nConsider index -> " + i);
				buildNode(parents, i, cache);
			}
			
			return root;
		}
		
		
		// Create each node method
		void buildNode(int [] parent, int i, Node cache[]) {
			
			//System.out.println( i + " is the child of node -> " + parent[i]);
			
			if(cache[i] != null) {
				//System.out.println("Already cache! "+ cache[i].toString());
				return;
			}
			
			cache[i] = new Node(i);
			
			if(parent[i] == -1) {
				root = cache[i];
				//System.out.println(cache[i].toString() + " is root.");
				return;
			}
			
			//If parent is not cache, create a parent
			if(cache[parent[i]] == null) {
				//System.out.println("-----------------------------------------------");
				//System.out.println("But node " + parent[i] + " is not cache yet.");
				//System.out.println("Parent of parents[" + i + "] -> "  + parent[i] + " not cache!");
				buildNode(parent, parent[i], cache);
			}
				
			// Find parent pointer
			Node p = cache[parent[i]];
			//System.out.println();
			//System.out.println("Parent of " + i + " = "  + parent[i] + ", which is " + p.toString());
			// Check if this is first child of parent
			if(p.isChildCached(cache[i])) {
				//System.out.println("Child already cache!");
			}
			else {
				//System.out.println(cache[i].key + " is not cache as a child. "+ "Adding child -> " + cache[i].key + " to the parent -> " + p.key);
				p.addChild(cache[i]);
			}
			
		}
		
		/*// Walk the tree
		private void walk(Node element, List<Node> list) {
	        list.add(element);
	        for (Node data : element.getChildren()) {
	            walk(data, list);
	        }
	    }*/
	    
		// Get tree height iteratively method 
	    public int getTreeHeight(Node node) {
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
					
					if(newNode.children != null && !newNode.children.isEmpty()) {
						
						//System.out.println("Size of childread array of " + newNode.toString() + " == " + newNode.children.size());
						for(int i = 0; i < newNode.children.size(); ++i) {
							q.add(newNode.children.get(i));
						}
					}
					
					nodeCount--;
				}
			}
	    }
		
		
		//For adding new line in a program
	    void newLine() 
	    {
	        System.out.println("");
	    }
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
                        // Replace this code with a faster implementation
			/*int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight; */
			root = buildTree(parent, n);
			//List<Node> list = new ArrayList<Node>();
	        //walk(root, list);
	        //System.out.println(list);
	        return getTreeHeight(root);
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}

