package graphs;
import java.util.*;

// Util class for a graph

public class Graph {
	
	int V; // Vertices
	int E; // Edges
	Edge edge[];	// Array of edges
	
	Graph(int V, int E) {
		this.V = V;
		this.E = E;
		
		edge = new Edge[this.E];
		for(int i = 0; i < this.E; i++) {
			edge[i] = new Edge();		}
	}
	
}
