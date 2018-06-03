package com.interviews.educative.graphs;
import java.util.*;

public class BFSTraverse {
	
	public String traverse(Graph g, int src) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		StringBuilder sb = new StringBuilder();
		
		while(!queue.isEmpty()) {
			
			Integer node = queue.peek();
			queue.remove();
			
			sb.append(node);
			
			for(Integer child : g.list[node]) {
				queue.add(child);
			}
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(5);
		
		g.AddDirectedEdge(0, 1);
		g.AddDirectedEdge(0, 2);
		g.AddDirectedEdge(1, 3);
		g.AddDirectedEdge(1, 4);
		
		BFSTraverse bfs = new BFSTraverse();
		System.out.println("BFS -> " + bfs.traverse(g, 0));

	}

}
