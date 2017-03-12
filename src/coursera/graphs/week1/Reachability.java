package coursera.graphs.week1;

import java.util.*;

public class Reachability {
	private static int  v;
	
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
       
    	boolean[] visited = new boolean[v];
    	DFS(x, visited, adj);	// Starting from x, traverse the graph.
    	
    	if(!visited[y])	// Check if visited is true
    		return 0;
    	else
    		return 1;
    }


    private static void DFS(int a, boolean[] visited, ArrayList<Integer>[] adj) {
		
    	visited[a] = true;
    	//System.out.println(a+" ");
    	
    	Iterator<Integer> i = adj[a].listIterator();
    	while(i.hasNext()) {
    		int n = i.next();
    		if(!visited[n]) {
				DFS(n, visited, adj);
			}
    	}
    	
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        v = n;
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
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}


