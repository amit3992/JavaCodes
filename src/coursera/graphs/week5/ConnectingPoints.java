package coursera.graphs.week5;
import java.util.*;

public class ConnectingPoints {
	
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
		char id;
		int x;
		int y;	
		
		Vertex() {
			x = 0;
			y = 0;
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
	
	
	
    private double minimumDistance(int[] x, int[] y) {
        double result = 0.;
        //write your code here
        return result;
    }
    
    public double getDistance(int x1, int y1, int x2, int y2) {
    	double distance = 0.0;
    	distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    	
    	return distance;
    }
    
    public void getEdges(Vertex vertices[]) {
    	
    	EdgeComparator edgeComparator = new EdgeComparator();
    	
    	for(int i = 0; i < V; i++) {
    		for(int j = i + 1; j < V; j++) {
    			
    			Edge e = new Edge();
				e.src.x = vertices[i].x;
    			e.src.y = vertices[i].y;
    			
    			e.dest.x = vertices[j].x;
    			e.dest.y = vertices[j].y;
    			
    			e.weight = getDistance(e.src.x, e.src.y, e.dest.x, e.dest.y);
    			System.out.println("Distance between " + vertices[i].id + " -> " + vertices[j].id + " = " + e.weight);
    			edges.add(e);
    		}
    		
    	}
    	
    	// Sort Edges
    	Collections.sort(edges, edgeComparator);
    	
    	System.out.println("==================== After Sorting ====================");
    	for(Edge e: edges) {
    		System.out.println("Distance -> " + e.getWeight());
    	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ConnectingPoints graph = new ConnectingPoints(n);
        
        for (int i = 0; i < n; i++) {
        	graph.vertices[i].id = (char) (65 + i);
        	graph.vertices[i].x = scanner.nextInt();
        	graph.vertices[i].y = scanner.nextInt();
        }
        
        graph.getEdges(graph.vertices);
        //System.out.println(minimumDistance(x, y));
    }
}

