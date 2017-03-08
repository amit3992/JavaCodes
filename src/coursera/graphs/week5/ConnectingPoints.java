package coursera.graphs.week5;

import java.text.DecimalFormat;
import java.util.*;


public class ConnectingPoints {
	
	// =================================== Disjoint set class ===================================
	class DisjointSet {
		private HashMap<Long, Node> map = new HashMap<Long, Node>();
		
		class Node {
			long data;
			Node parent;
			int rank;
		}
		
		public void makeSet(long data) {
			Node node = new Node();
			node.data = data;
			node.parent = node;
			node.rank = 0;
			map.put(data, node);
		}
		
		public boolean Union(long data1, long data2) {
			Node node1 = map.get(data1);
			Node node2 = map.get(data2);
			
			Node parent1 = findSet(node1);
			Node parent2 = findSet(node2);
			
			if(parent1.data == parent2.data) {
				return false;
			}
			
			if(parent1.rank >= parent2.rank) {
				
				parent1.rank = (parent1.rank == parent2.rank) ? 1 + parent1.rank : parent1.rank;
				parent2.parent = parent1;
			}
			else {
				parent1.parent = parent2;
			}
			
			return true;
		}
		
		public long findSet(long data) {
			return findSet(map.get(data)).data;
		}
		
		private Node findSet(Node node) {
			Node parent = node.parent;
			
			if(parent == node)
				return parent;
			
			node.parent = findSet(node.parent);
			
			return node.parent;
		}
	}
	
	// =================================== Connecting Points class ===================================
	public Vertex vertices[];
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	public int V;
	
	ConnectingPoints(int V) {
		this.V = V;
		
		vertices = new Vertex[this.V];
		for(int i = 0; i < this.V; i++) {
			vertices[i] = new Vertex();
		}
		
	}
	
	// Vertex class
	class Vertex {
		long id;
		int x;
		int y;
		int rank;
		
		Vertex() {
			x = 0;
			y = 0;
			id = 0;
			rank = 0;
		}
	}
	
	// Edge class
	class Edge {
		
		Vertex src;
		Vertex dest;
		double weight;
		
		
		Edge() {
			src = new Vertex();
			dest = new Vertex();
			weight = 0;
			
		}
		
		public double getWeight() {
			return this.weight;
		}
		
	}
	
	// For sorting the edges
	public class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge e1, Edge e2) {
			if(e1.getWeight() <= e2.getWeight()) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}
	
	
	
    private String minimumDistance(ArrayList<Edge> edges) {
        
    	double result = 0.;
        ArrayList<Edge> resultEdge = new ArrayList<Edge>();

        EdgeComparator edgeComparator = new EdgeComparator();
    	Collections.sort(edges, edgeComparator);
    	
    	DisjointSet disjointSet = new DisjointSet();
    	
    	// Create sets of each vertex
    	for(int i = 0; i < this.V; i++) {
    		disjointSet.makeSet(vertices[i].id);
    	}
    	
    	for(Edge e: edges) {
    		
    		long root1 = disjointSet.findSet(e.src.id);
    		long root2 = disjointSet.findSet(e.dest.id);
    		
    		if(root1 == root2) {
    			continue;
    		}
    		else {
    			resultEdge.add(e);
    			result = result + e.weight;
    			disjointSet.Union(e.src.id, e.dest.id);
    		}
    	}
    	DecimalFormat df = new DecimalFormat("####0.000000000");
        return df.format(result);
    }
    
    public double getDistance(int x1, int y1, int x2, int y2) {
    	double distance = 0.0;
    	distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    	
    	return distance;
    }
    
    public String getEdges(Vertex vertices[]) {
    	
    	for(int i = 0; i < V; i++) {
    		for(int j = i + 1; j < V; j++) {
    			
    			Edge e = new Edge();
				e.src.x = vertices[i].x;
    			e.src.y = vertices[i].y;
    			e.src.id = vertices[i].id;
    			
    			e.dest.x = vertices[j].x;
    			e.dest.y = vertices[j].y;
    			e.dest.id = vertices[j].id;
    			
    			e.weight = getDistance(e.src.x, e.src.y, e.dest.x, e.dest.y);
    			edges.add(e);
    		}
    		
    	}
    	
    	return minimumDistance(edges);
    	/*
    	System.out.println("==================== After Sorting ====================");
    	for(Edge e: edges) {
    		System.out.println("Distance of " + e.id + "-> " + e.getWeight());
    	}*/
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ConnectingPoints graph = new ConnectingPoints(n);
        
        for (int i = 0; i < n; i++) {
        	graph.vertices[i].id = i + 1;
        	graph.vertices[i].x = scanner.nextInt();
        	graph.vertices[i].y = scanner.nextInt();
        }
        
        System.out.println(graph.getEdges(graph.vertices));
    }
}