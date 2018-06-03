package com.interviews.educative.graphs;
import java.util.*;

/* Directed graph/ Adjacency list representation of graphs */

public class Graph {
	
	int vertices;
	LinkedList<Integer> [] list;
	
	/* Constructor */
	Graph(int v) {
		this.vertices = v;
		list = new LinkedList[v];
		
		/* Initialize the list */
		for(int i = 0; i < v; i++) {
			list[i] = new LinkedList<>();
		}
	}
	
	/* Methods */
	public void AddDirectedEdge(int src, int dest) {
		list[src].add(dest);
	}
	
	public void AddUnDirectedEdge(int src, int dest) {
		list[src].add(dest);
		list[dest].add(src);
	}
	

}
