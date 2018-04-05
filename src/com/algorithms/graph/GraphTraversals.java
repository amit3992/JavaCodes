package com.algorithms.graph;
import com.components.graph.Graph;
import com.components.graph.Vertex;

import java.util.*;

public class GraphTraversals {
	
	
	/* ========================== DFS =============================== */
	public void DFS(Graph<Integer> graph) {
		Set<Long> visited = new HashSet<Long>();
		for(Vertex<Integer> v : graph.getAllVertex()) {
			if(!visited.contains(v.getId())) {
				dfsUtil(v, visited);
			}
		}
		
	}
	
	private void dfsUtil(Vertex<Integer> v, Set<Long> visited) {
		visited.add(v.getId());
		System.out.print(v.getId() + " ");
		for(Vertex<Integer> adj_v : v.getAdjacentVertices()) {
			if(!visited.contains(adj_v.getId())) {
				dfsUtil(adj_v, visited);
			}
			
		}
	}
	
	/* ======================== BFS ================================= */
	public void BFS(Graph<Integer> graph) {
		Set<Long> visited = new HashSet<>();
		Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();
		
		for(Vertex<Integer> v : graph.getAllVertex()) {
			if(!visited.contains(v.getId())) {
				queue.add(v);
				visited.add(v.getId());
				
				while(queue.size() != 0) {
					Vertex<Integer> temp = queue.peek();
					queue.remove();
					
					System.out.print(temp.getId() + " ");
					for(Vertex<Integer> adj_v : temp.getAdjacentVertices()) {
						if(!visited.contains(adj_v.getId())) {
							queue.add(adj_v);
							visited.add(adj_v.getId());
						}
					}
					
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);
    //  graph.addEdge(5, 1);
        graph.addEdge(5,3);
        
        GraphTraversals gt = new GraphTraversals();
        System.out.println("DFS: ");
        gt.DFS(graph);
        System.out.println();
        System.out.println("BFS: ");
        gt.BFS(graph);

	}

}
