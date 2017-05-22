package graphs;
// Connected Components

import java.util.*;
import java.io.*;

public class CC {
	
	private int V; // Vertices
	private LinkedList<Integer> adj[];
	
	CC(int v) {
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
	
	int connectedComponents() {
		
		int count = 0;
		boolean[] visited = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			
			if(visited[i] == false) {
				count++;
				DFSTraverse(i, visited);
			}
		}
		
		return count;
	}
	
	public boolean isReachable(int x, int y) {
		
		boolean[] reached = new boolean[V];
		DFSTraverse(x, reached);
		
		return reached[y];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CC g = new CC(5);
		
		g.addEdge(0, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		System.out.println("Number of CCs - " + g.connectedComponents());
		
	}

}

