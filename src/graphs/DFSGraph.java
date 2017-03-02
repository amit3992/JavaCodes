package graphs;
import java.util.*;
import java.io.*;

public class DFSGraph {
	
	private int V; // Vertices
	private LinkedList<Integer> adj[];
	
	DFSGraph(int v) {
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int x, int y) {
		adj[x].add(y);
	}
	
	void DFS(int v) {
		
		boolean visited[] = new boolean[V];
		DFSTraverse(v, visited);
	
	}
	
	void DFSTraverse(int v, boolean [] visted) {
		
		visted[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> i = adj[v].listIterator();
		
		while(i.hasNext()) {
			int n = i.next();
			if(!visted[n]) {
				DFSTraverse(n, visted);
			}
		}
	}
	
	public boolean isReachable(int x, int y) {
		
		boolean[] reached = new boolean[V];
		DFSTraverse(x, reached);
		
		return reached[y];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		DFSGraph g = new DFSGraph(5);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
        System.out.println(g.isReachable(0, 4));
		
		/*
		DFSGraph g1 = new DFSGraph(4);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		
		g1.DFS(0);
		System.out.println("Can we reach 3 from 0 " + g1.isReachable(0, 1)); */

	}

}
