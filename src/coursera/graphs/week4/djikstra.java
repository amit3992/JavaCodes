package coursera.graphs.week4;

import java.util.*;

public class djikstra {
	
	// ===================================================== BINARY MIN HEAP CLASS ===============================================
	class BinaryMinHeap {
		
	}
	
	// ======================================================  VERTEX CLASS  ====================================================
	class Vertex {
		int id;
		private List<Edge> edges;
		private List<Vertex> adjacentVertices;
		
		Vertex(int id) {
			this.id = id;
			edges = new ArrayList<Edge>();
			adjacentVertices = new ArrayList<Vertex>();
		}
		
		int getID() {
			return this.id;
		}
		
		void addAdjacentVertex(Edge e, Vertex v) {
			edges.add(e);
			adjacentVertices.add(v);
		}
		
		// For debugging
		public String toString() {
			return "Vertex ID -> " + String.valueOf(id);
		}
	}
	
	// ======================================================  EDGE CLASS  ======================================================  
	
	class Edge {
		
		Vertex src;
		Vertex dest;
		int weight;
		
		Edge(Vertex v1, Vertex v2, int weight) {
			src = v1;
			dest = v2;
			this.weight = weight;
		}
		
		Vertex getSrcVertex() {
			return src;
		}
		
		Vertex getDestVertex() {
			return dest;
		}
		
		int getWeight() {
			return weight;
		}
		
		// For debugging
		public String toString() {
			return "Edge starting from " + src.id + " -> " + dest.id + " and weight = " + this.weight;
		}
	}
	
	// ================================================= Dijkstra graph class =======================================================
	public List<Edge> allEdges;
	public Map<Integer, Vertex> allVertices;
	
	// Constructor
	djikstra() {
		allEdges = new ArrayList<Edge>();
		allVertices = new HashMap<Integer, Vertex>();
	}
	
	void addEdge(int src, int dest, int wt) {
		
		Vertex v1 = null;
		if(allVertices.containsKey(src)) {
			v1 = allVertices.get(src);
		}
		else {
			v1 = new Vertex(src);
			allVertices.put(src,v1);
		}
		
		Vertex v2 = null;
		if(allVertices.containsKey(dest)) {
			v2 = allVertices.get(dest);
		}
		else {
			v2 = new Vertex(dest);
			allVertices.put(dest,v2);
		}
		
		Edge edge = new Edge(v1, v2, wt);
		allEdges.add(edge);
		v1.addAdjacentVertex(edge, v2);
	}
	
	public List<Edge> getAllEdges() {
		return allEdges;
	}
	
	public Collection<Vertex> getAllVertices() {
		return allVertices.values();
	}
	
	
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        return -1;
        // Main Dijkstra implementation
        
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        djikstra graph = new djikstra();
        
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            graph.addEdge(x - 1, y - 1, w);
        }
        
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        //System.out.println(distance(adj, cost, x, y));
        
        System.out.println("VERTICES ");
        for(Vertex v: graph.getAllVertices()) {
        	System.out.println(v.toString());
        }
        
        System.out.println("\nEDGES");
        for(Edge e: graph.getAllEdges()) {
        	System.out.println(e.toString());
        }
    }
}

