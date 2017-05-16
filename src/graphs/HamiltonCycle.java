package graphs;
import java.util.*;
/*Geeksforgeeks: http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/*/

public class HamiltonCycle {
	
	final int V = 5; // 5 vertices
	int [] path;
	
	/*Util method to check if vertex v can be added at pos in the hamiltonCycle*/
	boolean isSafe(int v, int[][] graph, int[] path, int pos) {
		
		/*Check if v is an adjacent vertex of the previously added vertex*/
		 if (graph[path[pos - 1]][v] == 0)
	            return false;
		
		/*Check if v is already in path*/
		for(int i = 0; i < path.length; i++) {
			if(path[i] == v) {
				return false;
			}
		}
		
		return true;
	}
	
	boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
		/*If all vertices are checked*/
		if(pos == V) {
			// And if there is an edge from the last included
            // vertex to the first vertex
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
		}
		
		/*Check for all vertices*/
		for(int v = 1; v < V; v++) {
			if(isSafe(v, graph, path, pos)) {
				path[pos] = v;
			
			
				if(hamCycleUtil(graph, path, pos + 1) == true)
					return true;
			
				path[pos] = -1;
			}
		}
		
		return false; // If no path is constructed
	}
	
	int hamitonCycle(int[][] graph) {
		
		path = new int[V];
		
		for(int i = 0; i < V; i++) {
			path[i] = -1;
		}
		
		// First vertex
		path[0] = 0; 
		
		if(hamCycleUtil(graph, path, 1) == false) {
			System.out.println("Hamitonian path does not exist!");
			return -1;
		}
		
		printPath();
		return 1;
	}
	
	public void printPath() {
		System.out.println("Hamiltonian path -> ");
		for(int i = 0; i < V; i++) {
			System.out.print(path[i] + " ");
		}
		
		// Print first vertex again to show the cycle
		System.out.print(path[0] + " ");
	}

	public static void main(String[] args) {
		
		int graph1[][] = {{0, 1, 0, 1, 0},
	            {1, 0, 1, 1, 1},
	            {0, 1, 0, 0, 1},
	            {1, 1, 0, 0, 1},
	            {0, 1, 1, 1, 0},
	        };
		
		int graph2[][] = {{0, 1, 0, 1, 0},
	            {1, 0, 1, 1, 1},
	            {0, 1, 0, 0, 1},
	            {1, 1, 0, 0, 0},
	            {0, 1, 1, 0, 0},
	        };
		
		HamiltonCycle hc = new HamiltonCycle();
		
		hc.hamitonCycle(graph1);

	}

}
