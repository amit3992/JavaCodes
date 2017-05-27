package graphs;
import java.util.*;

public class TopoSort {
	
	private int v;
	private LinkedList<Integer> adj[];
	
	TopoSort(int v) {
		this.v = v;
		adj = new LinkedList[this.v];
		for(int i = 0; i < this.v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	void topologicalSort() {
		Stack st = new Stack();
		
		boolean [] visited = new boolean[this.v];
		/*for(int i = 0; i < this.v; i++) {
			visited[i] = false;
		}*/
		
		for(int i = 0; i < this.v; i++) {
			if(visited[i] ==  false) {
				topologicalSortUtil(i, visited, st);
			}
		}
		
		// Pop stack to print nodes in topologically sorted order
		while(st.empty() == false) {
			System.out.print(st.pop() + " ");
		}
	}

	private void topologicalSortUtil(int v, boolean[] visited, Stack st) {
		// TODO Auto-generated method stub
		visited[v] = true;
		Integer i;
		
		// Get all adjacent nodes of this node
		Iterator<Integer> it = adj[v].listIterator();
		while(it.hasNext()) {
			i = it.next();
			if(!visited[i]) {
				topologicalSortUtil(i, visited, st);
			}
		}
		
		// Push current vertex into stack
		st.push(new Integer(v));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a graph given in the above diagram
		
       // TopoSort g = new TopoSort(6);
        /*
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1); */
		
		TopoSort g = new TopoSort(5);
		g.addEdge(1, 0);
		g.addEdge(2, 1);
		g.addEdge(2, 0);
		g.addEdge(3, 2);
		g.addEdge(3, 0);
		g.addEdge(4, 1);
		g.addEdge(4, 2);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.topologicalSort();

	}

}
