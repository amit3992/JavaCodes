
package graphs;
import java.util.*;
import java.util.Map.Entry;

import coursera.graphs.week4.negative_cycle;

public class BellmanFord {
	
	private static final int INFINITY = 10000000;
	
	public static void BellmanFord(Graph graph, int source) {
		
		int V = graph.V;
		int E = graph.E;
		
		HashMap<Integer, Integer> distanceMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> parentMap = new HashMap<Integer, Integer>();
		
		// STEP 1: Initialize all distances to INFINITY and source to 0;
		for(int i = 0; i < V; i++) {
			distanceMap.put(i, INFINITY);
		}
		
		distanceMap.put(source,0);
		
		
		// Step 2: Relax all edges |V|-1 times.
		for(int i = 0; i < V; i++) {
			
			for(int j = 0; j < E; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				
				int distU = distanceMap.get(u);
				int distV = distanceMap.get(v);
	
				if(distU != INFINITY && (distU + weight < distV)) {
					int newDist = distU + weight;
					distanceMap.put(v, newDist);
				}
			}
		}
		
		// Step 3: Check for negative cycle. Step 2 runs for |V|-1 cycles. Run one more relaxation step for 
		// all edges and if distance changes, there is a negative step.
		for(int j = 0; j < E; j++) {
			
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			
			int distU = distanceMap.get(u);
			int distV = distanceMap.get(v);

			if(distU != INFINITY && (distU + weight < distV)) {
				System.out.println("GRAPH CONTAINS NEGATIVE EDGE!");
			}
		}
		
		//printMap(distanceMap);
	}
	
	

	private static void printMap(HashMap<Integer, Integer> distanceMap) {
		// TODO Auto-generated method stub
		System.out.println("Distance map after BF algorithm");
		ArrayList<Entry> map = new ArrayList<Entry>(distanceMap.entrySet());
		
		for(Entry temp: map) {
			System.out.println(temp);
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int m = scanner.nextInt();
	        
	        Graph graph = new Graph(n, m);
	     
	        for (int i = 0; i < m; i++) {
	            int u, v, w;
	            u = scanner.nextInt();
	            v = scanner.nextInt();
	            w = scanner.nextInt();
	            graph.edge[i].src = u - 1;
	            graph.edge[i].dest = v - 1;
	            graph.edge[i].weight = w;
	        }
	        
	        
	        BellmanFord(graph, 0);
		
		/*
		Graph graph = new Graph(5, 8);
		
		// add edge 0-1 (or A-B in above figure)
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;
 
        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;
 
        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;
 
        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;
 
        // add edge 1-4 (or A-E in above figure)
        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;
 
        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;
 
        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;
 
        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;
        */
        //BellmanFord(graph, 0);
	}

}
