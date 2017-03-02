package coursera.graphs.week1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ConnectedComponents {
	private static int V;
	
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        
        boolean[] visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			
			if(visited[i] == false) {
				result++;
				DFS(i, visited, adj);
			}
		}
		
        return result;
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
        int m = scanner.nextInt();
        V = n;
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
        System.out.println(numberOfComponents(adj));
    }
}