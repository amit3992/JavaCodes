package graphs;
import java.util.ArrayList;
import java.util.Scanner;


public class BinaryBFS {
	
	int V;
	int E;
	
	Edge [] edges;
	ArrayList<Edge> allEdges;
	
	class Node {
		
		int key;
		ArrayList<Edge> edges;
		ArrayList<Node> neighborNodes;
		
		Node(int key) {
			this.key = key;
			edges = new ArrayList<Edge>();
			neighborNodes = new ArrayList<Node>();
		}

		public int getKey() {
			return key;
		}

		public ArrayList<Edge> getEdges() {
			return edges;
		}

		public ArrayList<Node> getNeighborNodes() {
			return neighborNodes;
		}
		
		public void addEdge(Edge e) {
			this.edges.add(e);
		}
		
		public void addNeighbor(Node n) {
			this.neighborNodes.add(n);
		}
		
		public boolean isNeighbor(Node n) {
			if(!this.neighborNodes.isEmpty() && this.neighborNodes.contains(n)) {
				return true;
			}
			else
				return false;
		}
		
	}
	
	
	class Edge {
		
		Node src;
		Node dest;
		int weight;
		
		Edge(Node src, Node dest, int weight) {
					
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
		public String toString() {
			return "FROM: " + src.key + " -> " + dest.key + ", Weight: " + weight;
		}
	}
	
	BinaryBFS(int V, int E) {
		this.V = V;
		this.E = E;
		
		edges = new Edge[E];
		allEdges = new ArrayList<Edge>();
	}
	
	public void addEdge(int src, int dest, int weight) {
		
		Node s = new Node(src);
		Node d = new Node(dest);
		
		Edge e = new Edge(s, d, weight);
		Edge e_ = new Edge(d, s, weight);
		
		s.addEdge(e);
		s.addNeighbor(d);
		s.addEdge(e_);
		
		d.addEdge(e);
		d.addNeighbor(s);
		d.addEdge(e_);
		
		edges[src] = e;
		edges[dest] = e_;
		
		allEdges.add(e);
		
	}
	
	public ArrayList<Edge> getAllEdges() {
		return this.allEdges;
	}
	
	private static void printGraph(BinaryBFS graph) {
		System.out.println("EDGES OF THE GRAPH");
    	
    	ArrayList<Edge> eList = graph.getAllEdges();
    	for(Edge e: eList) {
    		System.out.println(e.toString());
    	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    
		BinaryBFS bfs =  new BinaryBFS(9,13);
		
		bfs.addEdge(0, 1, 0);
	    bfs.addEdge(0, 7, 1);
	    bfs.addEdge(1, 7, 1);
	    bfs.addEdge(1, 2, 1);
	    bfs.addEdge(2, 3, 0);
	    bfs.addEdge(2, 5, 0);
	    bfs.addEdge(2, 8, 1);
	    bfs.addEdge(3, 4, 1);
	    bfs.addEdge(3, 5, 1);
	    bfs.addEdge(4, 5, 1);
	    bfs.addEdge(5, 6, 1);
	    bfs.addEdge(6, 7, 1);
	    bfs.addEdge(7, 8, 1);
	    
	    printGraph(bfs);
		
	}

}
