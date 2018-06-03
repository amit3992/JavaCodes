package com.interviews.educative.graphs;
import java.util.*;

public class DFSTraverse {
	
	private void dfsUtil(Graph g, StringBuilder sb, boolean[] visited, int node) {
		
		visited[node] = true;
		sb.append(node);
		
		for(Integer child : g.list[node]) {
			if(!visited[child]) {
				dfsUtil(g, sb, visited, child);
			}
		}
	}
	
	public String traverse(Graph g, int src) {
		
		StringBuilder sb = new StringBuilder();
		boolean [] visited = new boolean[g.vertices];
		
		dfsUtil(g, sb, visited, src);
		
		return sb.toString();
	}
	
	
	public String iterativeTraverse(Graph g, int source) {
		
		StringBuilder result = new StringBuilder();
		int nVertices = g.vertices;
		
		boolean [] visited = new boolean[nVertices];
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(source);
		visited[source] = true;
		
		while(!stack.isEmpty()) {
			int current = stack.pop();
			result.append(current);
			
			for(Integer child : g.list[current]) {
				if(!visited[child]) {
					stack.push(child);
					visited[child] = true;
				}
			}
		}
		
		return result.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(5);
		
		g.AddDirectedEdge(0, 1);
		g.AddDirectedEdge(0, 2);
		g.AddDirectedEdge(1, 3);
		g.AddDirectedEdge(1, 4);
		
		DFSTraverse dfs = new DFSTraverse();
		System.out.println("DFS -> " + dfs.traverse(g, 0));
		System.out.println("Iterative DFS -> " + dfs.iterativeTraverse(g, 0));

	}

}
