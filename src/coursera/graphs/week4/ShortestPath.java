package coursera.graphs.week4;

import java.util.*;
import java.util.Map.Entry;

/*
 *
 *
 *
 * Test case #1
   6 7
   1 2 10
   2 3 5
   1 3 100
   3 5 7
   5 4 10
   4 3 -18
   6 1 -1
   1
   
  Test case #2	
   5 4
   1 2 1
   4 1 2
   2 3 2
   3 1 -5
   4
 */

public class ShortestPath {
	
	private static final int INFINITY = 100000001;
	static int V; 
	static int E;
	
	Edge edges[];
	ArrayList<Edge> allEdges;
	static HashMap<Integer, Integer> distanceMap;
	static int [] isReachable;
	static int [] isShortest;
	static int [] distance;
	
	class Edge {
		int src;
		int dest;
		int weight;
		char ID;
		
		// Edge class constructor
		Edge() {
			src = 0;
			dest = 0;
			weight = 0;
			ID = 'X';
		}
		
		public String toString() {
			return "EDGE ID: " + ID + ". FROM: " + src + " -> " + dest + ", Weight: " + weight;
		}
	}
	
	// ShortestPath class constructor
	ShortestPath(int V, int E) {
		this.V = V;
		this.E = E;
		
		isReachable = new int[this.V];
		isShortest = new int[this.V];
		distance = new int[this.V];
		allEdges = new ArrayList<Edge>();
		distanceMap = new HashMap<Integer, Integer>();
		
		edges = new Edge[this.E];
		for(int i = 0; i < this.E; i++) {
			edges[i] = new Edge();
		}
		
		for (int i = 0; i < this.V; i++) {
            distance[i] = INFINITY;
            isReachable[i] = 0;
            isShortest[i] = 1;
        }
	}
	
	public void addEdge(Edge e, int src, int dest, int wt) {
		e.src = src;
		e.dest = dest;
		e.weight = wt;
		e.ID = (char)(65 + src);
		
		allEdges.add(e);
	}
	
	public ArrayList<Edge> getAllEdges() {
		return allEdges;
	}
	
	private static void printGraph(ShortestPath graph) {
		System.out.println("EDGES OF THE GRAPH");
    	
    	ArrayList<Edge> eList = graph.getAllEdges();
    	for(Edge e: eList) {
    		System.out.println(e.toString());
    	}
	}
	
	private static void printDistanceMap(HashMap<Integer, Integer> distanceMap) {
		System.out.println("DISTANCE MAP");
    	
    	ArrayList<Entry> map = new ArrayList<Entry>(distanceMap.entrySet());
    	for(Entry e: map) {
    		System.out.println(e);
    	}
	}
	
	private static void compareDistanceMap(HashMap<Integer, Integer> newDistancemap) {
		
		ArrayList<Integer> nodes = new ArrayList<Integer>(distanceMap.keySet());
		
		for(int node: nodes) {
			
			int oldWt = newDistancemap.get(node);
			int newWt = distanceMap.get(node);
			
			if(oldWt != newWt) {
				System.out.println("-");
			}
			else if (oldWt == newWt && newWt != INFINITY) {
				System.out.println(newWt);
			}
			else if (oldWt == newWt && newWt == INFINITY) {
				System.out.println("*");
				isReachable[node] = 0;
			}
		}
	}

    private static void shortestPaths(ShortestPath graph, int s) {
    	
    	boolean isNegative = false;
    	HashMap<Integer, Integer> newDistanceMap = new HashMap<Integer, Integer>();
		
		// Step 1: Initialize distanceMap values
    	for(int i = 0; i < V; i++) {
    		distanceMap.put(i, INFINITY);
    		newDistanceMap.put(i, INFINITY);
    	}
    	distanceMap.put(s, 0); // Source distance == 0;
    	newDistanceMap.put(s,0);
    	
    	// Step 2: Relax all edges |V| - 1 times
    	for(int i = 0; i < V; i++) {
    		for(int j = 0; j < E; j++) {
    			int u = graph.edges[j].src;
    			int v = graph.edges[j].dest;
    			int wt = graph.edges[j].weight;
    			
    			int distU = distanceMap.get(u);
    			int distV = distanceMap.get(v);
    			
    			if(distU != INFINITY && (distU + wt < distV)) {
    				int newWt = distU + wt;
    				distanceMap.put(v, newWt);
    				newDistanceMap.put(v, newWt);
    			}
    		}
    	}
    	
    	// Step 3: Relax the edges once
    		for(int j = 0; j < E; j++) {
        		
    			int u = graph.edges[j].src;
    			int v = graph.edges[j].dest;
    			int wt = graph.edges[j].weight;
    			
    			int distU = distanceMap.get(u);
    			int distV = distanceMap.get(v);
    			
    			if(distU != INFINITY && (distU + wt < distV)) {
    				int newWt = distU + wt;
    				distanceMap.put(v, newWt);
    				newDistanceMap.put(v, newWt);
    			}
    		}
    		
    		// Step 4: Relax the edges once again to node change in distance
    		for(int j = 0; j < E; j++) {
        		
    			int u = graph.edges[j].src;
    			int v = graph.edges[j].dest;
    			int wt = graph.edges[j].weight;
    			
    			int distU = distanceMap.get(u);
    			int distV = distanceMap.get(v);
    			
    			if(distU != INFINITY && (distU + wt < distV)) {
    				int oldWt = distanceMap.get(v);
    				int newWt = distU + wt;
    				distanceMap.put(v, newWt);
    				isNegative = true;	
    			}
    		}
    	
    	compareDistanceMap(newDistanceMap);
    	//printDistanceMap(distanceMap);
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        ShortestPath graph = new ShortestPath(n, m);
        
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            graph.addEdge(graph.edges[i], x - 1 , y - 1, w);

        }
        int s = scanner.nextInt() - 1;
 
        shortestPaths(graph, s);
    }

}


