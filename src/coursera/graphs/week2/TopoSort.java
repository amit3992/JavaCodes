package coursera.graphs.week2;

import java.util.*;

public class TopoSort {
	
	private static int V; // Vertices
	
    private static void toposort(ArrayList<Integer>[] adj) {
    	
        Stack st = new Stack();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
        	visited[i] = false;
        }
        
        for(int i = 0; i < V; i++) {
        	if(visited[i] == false) {
        		dfs(i, visited, st, adj);
        	}
        }
        
        // Pop stack to print nodes in topologically sorted order
     		while(st.empty() == false) {
     			System.out.print(st.pop() + " ");
     		}
    }

    private static void dfs(int v, boolean[] visited, Stack st, ArrayList<Integer>[] adj) {
      //write your code here
    	
    	visited[v] = true;
    	Integer i;
    	
    	Iterator<Integer> it = adj[v].listIterator();
    	while(it.hasNext()) {
    		i = it.next();
    		if(!visited[i]) {
    			dfs(i, visited, st, adj);
    		}
    	}
    	
    	st.push(new Integer(v + 1));
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        V = n;
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        
        toposort(adj);
        /*ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }*/
    }
}

