package coursera.graphs.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class negative_cycle {
	
	class Edge {
		int src;
		int dest;
		int weight;
		
		Edge() {
			src = 0;
			dest = 0;
			weight = 0;
		}
	}
	
	int V; // Vertices
	int E;	// Edges
	private static final int INFINITY = 10000000;
	
	Edge edge[];
	
	negative_cycle(int V, int E) {
		this.V = V;
		this.E = E;
		
		edge = new Edge[this.E];
		for(int i = 0; i < this.E; i++) {
			edge[i] = new Edge();
		}
	}
	
    private static int negativeCycle(negative_cycle graph, int source) {
        // write your code here
    	int V = graph.V;
    	int E = graph.E;
    	boolean isNegative = false;
    	
    	HashMap<Integer, Integer> distanceMap = new HashMap<Integer, Integer>();
    	
    	// Step 1: Initialize distanceMap values
    	for(int i = 0; i < V; i++) {
    		distanceMap.put(i, INFINITY);
    	}
    	distanceMap.put(source, 0); // Source distance == 0;
    	
    	// Step 2: Relax all edges |V| - 1 times
    	for(int i = 0; i < V; i++) {
    		for(int j = 0; j < E; j++) {
    			int u = graph.edge[j].src;
    			int v = graph.edge[j].dest;
    			int wt = graph.edge[j].weight;
    			
    			int distU = distanceMap.get(u);
    			int distV = distanceMap.get(v);
    			
    			if(distU != INFINITY && (distU + wt < distV)) {
    				int newWt = distU + wt;
    				distanceMap.put(v, newWt);
    			}
    		}
    	}
    	
    	// Step 3: Relex the edges once more to check for negative cycle
    	for(int j = 0; j < E; j++) {
    		
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int wt = graph.edge[j].weight;
			
			int distU = distanceMap.get(u);
			int distV = distanceMap.get(v);
			
			if(distU != INFINITY && (distU + wt < distV)) {
				isNegative = true;	
			}
		}
    	
        if(isNegative)
        	return 1;
        else
        	return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        //ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        negative_cycle graph = new negative_cycle(n, m);
     
        for (int i = 0; i < m; i++) {
            int u, v, w;
            u = scanner.nextInt();
            v = scanner.nextInt();
            w = scanner.nextInt();
            graph.edge[i].src = u - 1;
            graph.edge[i].dest = v - 1;
            graph.edge[i].weight = w;
        }
        
        System.out.println(negativeCycle(graph, 0));
    }
}

