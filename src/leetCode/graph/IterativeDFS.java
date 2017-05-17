package leetCode.graph;
import java.util.*;

public class IterativeDFS {
	
	public final int V;
	private LinkedList<Integer> adj[];
	
	IterativeDFS(int v) {
		V = v;
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	public void iterativeDFS(int s) {
		boolean[] visited = new boolean[V];
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(s);
		
		while(!st.isEmpty()) {
			s = st.peek();
			st.pop();
			
			if(!visited[s]) {
				System.out.print(s + " ");
				visited[s] = true;
			}
			
			Iterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int ind = i.next();
				if(!visited[ind]) {
					st.push(ind);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		
		IterativeDFS idfs = new IterativeDFS(5);
		idfs.addEdge(1, 0);
		idfs.addEdge(0, 2);
		idfs.addEdge(2, 1);
		idfs.addEdge(0, 3);
		idfs.addEdge(1, 4);
		
		System.out.println("Iterative DFS of the graph -> ");
		idfs.iterativeDFS(0);
		

	}

}
