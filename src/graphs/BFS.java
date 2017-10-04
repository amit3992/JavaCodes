package graphs;
import java.util.*;

public class BFS {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	BFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	void BFSTraversal(int s) {
		
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int a = 0;

		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			a = queue.poll();
			System.out.print(a + " ");
			
			Iterator<Integer> it = adj[a].listIterator();
			while(it.hasNext()) {
				int n = it.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BFS g = new BFS(8);
		
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 5);
		g.addEdge(3, 1);
		
		g.addEdge(7, 4);
		g.addEdge(4, 6);

      
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 1)");
 
        g.BFSTraversal(0);

	}

}
