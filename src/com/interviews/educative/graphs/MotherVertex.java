package com.interviews.educative.graphs;
import java.util.*;

public class MotherVertex {
	
	Graph g;
	public MotherVertex(Graph g) {
		// TODO Auto-generated constructor stub
		this.g = g;
	}
	
	public void dfsUtil(int src, boolean [] visited) {
		
		System.out.print(src + " -> ");
		visited[src] = true;
		ListIterator<Integer> it = g.list[src].listIterator();
		while(it.hasNext()) {
			Integer n = it.next();
			if(!visited[n]) {
				dfsUtil(n, visited);
			}
		}
	}
	
	public int motherVertex() {
		
		boolean [] visited = new boolean[this.g.vertices];
		int v = 0; // last finished node
		int count = 0;
		for(int i = 0; i < g.vertices; i++) {
			
			if(!visited[i]) {
				dfsUtil(i, visited);
				v = i;
				count += 1;
			}
		}
		
		visited = new boolean[g.vertices];
		dfsUtil(v, visited);
		
		for(int i = 0; i < g.vertices; i++) {
			if(!visited[i]) {
				return -1;
			}
		}
		
		System.out.println("Count -> " + count);
		return v;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(7);
		g.AddDirectedEdge(0, 1);
		g.AddDirectedEdge(0, 2);
		g.AddDirectedEdge(1, 3);
		g.AddDirectedEdge(4, 1);
		g.AddDirectedEdge(6, 4);
		g.AddDirectedEdge(5, 6);
		g.AddDirectedEdge(5, 2);
		g.AddDirectedEdge(6, 0);
		
		
		MotherVertex mv = new MotherVertex(g);
		System.out.println("Mother vertex -> " + mv.motherVertex());

	}

}
