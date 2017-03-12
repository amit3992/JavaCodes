package dataStructures.basicDS;

import java.util.*;

import java.io.*;

public class tree_height {
	
	class Node {
		
		int key;
		Node left, right;
		
		public Node(int key) {
			this.key = key;
			left = right = null;
		}
		
	}
	
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

	public class TreeHeight {
		int n;
		int parent[];
		Node root;
		
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
			int maxHeight = 0;
			for (int vertex = 0; vertex < n; vertex++) {
				int height = 0;
				for (int i = vertex; i != -1; i = parent[i])
					height++;
				maxHeight = Math.max(maxHeight, height);
			}
			return maxHeight;
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
		//System.out.println(tree.computeHeight());
	}
}

