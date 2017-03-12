package coursera.graphs.week4;

import java.util.*;

public class djikstra {
	
	private static final int INFINITY = 1000000;
	
	
	// ===================================================== BINARY MIN HEAP CLASS ===============================================
	
	public class Node {
		int weight;
		Vertex v;
	}
	
	public class BinaryMinHeap {
		
		private List<Node> allNodes = new ArrayList<>();
		private Map<Vertex, Integer> nodePosition = new HashMap<Vertex, Integer>();
		
		public void add(int weight, Vertex v) {
	        Node node = new Node();
	        node.weight = weight;
	        node.v = v;
	        allNodes.add(node);
	        int size = allNodes.size();
	        int current = size - 1;
	        int parentIndex = (current - 1) / 2;
	        nodePosition.put(node.v, current);

	        while (parentIndex >= 0) {
	        	
	            Node parentNode = allNodes.get(parentIndex);
	            Node currentNode = allNodes.get(current);
	            if (parentNode.weight > currentNode.weight) {
	                swap(parentNode,currentNode);
	                updatePositionMap(parentNode, currentNode, parentIndex,current);
	                current = parentIndex;
	                parentIndex = (parentIndex - 1) / 2;
	            } else {
	                break;
	            }
	        }
	    }
		
		public void decrease(Vertex v1, int newWeight){
	        Integer position = nodePosition.get(v1);
	        allNodes.get(position).weight = newWeight;
	        int parent = (position - 1 )/2;
	        while(parent >= 0){
	            if(allNodes.get(parent).weight > allNodes.get(position).weight){
	                swap(allNodes.get(parent), allNodes.get(position));
	                updatePositionMap(allNodes.get(parent) ,allNodes.get(position),parent,position);
	                position = parent;
	                parent = (parent-1)/2;
	            }else{
	                break;
	            }
	        }
	    }
		
		public Integer getWeight(Vertex key) {
	        Integer position = nodePosition.get(key);
	        if( position == null ) {
	            return null;
	        } else {
	            return allNodes.get(position).weight;
	        }
	    }
		
		public boolean containsData(Vertex key){
	        return nodePosition.containsKey(key);
	    }
		
		public Vertex extractMin(){
	        Node node = extractMinNode();
	        return node.v;
	    }
		
		public Node extractMinNode() {
			
	        int size = allNodes.size() - 1;
	        Node minNode = new Node();
	        minNode.v = allNodes.get(0).v;
	        minNode.weight = allNodes.get(0).weight;

	        int lastNodeWeight = allNodes.get(size).weight;
	        allNodes.get(0).weight = lastNodeWeight;
	        allNodes.get(0).v = allNodes.get(size).v;
	        nodePosition.remove(minNode.v);
	        nodePosition.remove(allNodes.get(0));
	        nodePosition.put(allNodes.get(0).v, 0);
	        allNodes.remove(size);

	        int currentIndex = 0;
	        size--;
	        while(true){
	            int left = 2*currentIndex + 1;
	            int right = 2*currentIndex + 2;
	            if(left > size){
	                break;
	            }
	            if(right > size){
	                right = left;
	            }
	            int smallerIndex = allNodes.get(left).weight <= allNodes.get(right).weight ? left : right;
	            if(allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight){
	                swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
	                updatePositionMap(allNodes.get(currentIndex) ,allNodes.get(smallerIndex) ,currentIndex,smallerIndex);
	                currentIndex = smallerIndex;
	            }else{
	                break;
	            }
	        }
	        return minNode;
	    }

		private void swap(Node node1, Node node2) {
			int wt = node1.weight;
			Vertex data = node1.v;
			
			node1.v = node2.v;
			node1.weight = node2.weight;
			
			node2.v = data;
			node2.weight = wt;
			
		}
		
		public boolean empty(){
	        return allNodes.size() == 0;
	    }
		
		 private void updatePositionMap(Node data1, Node data2, int pos1, int pos2){
		        nodePosition.remove(data1.v);
		        nodePosition.remove(data2.v);
		        nodePosition.put(data1.v, pos1);
		        nodePosition.put(data2.v, pos2);
		 }
		 
		 public void printHeap(){
		        for(Node n : allNodes){
		            System.out.println(n.v.id + " " + n.weight);
		        }
		    }
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
		
		List<Edge> getEdges() {
			return this.edges;
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
	BinaryMinHeap minHeap;
	
	// Constructor
	djikstra() {
		allEdges = new ArrayList<Edge>();
		allVertices = new HashMap<Integer, Vertex>();
		minHeap = new BinaryMinHeap();
	}
	
	
	Map<Vertex, Integer> distanceMap = new HashMap<Vertex, Integer>();
	Map<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();
	

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
	
	
    private int distance(Collection<Vertex> collection, int source, int dest) {
    	
    	Vertex srcVertex = null;
    	Vertex destVertex = null;
    	
    	int distance = 0;
    	
    	if(allVertices.containsKey(source)) {
    		srcVertex = allVertices.get(source);
    	}
    	
    	if(allVertices.containsKey(dest)) {
    		destVertex = allVertices.get(dest);
    	}
        
    	//initialize all vertex with infinite distance from source vertex
        for(Vertex vertex : collection){
            minHeap.add(Integer.MAX_VALUE, vertex);
        }
        
        //set distance of source vertex to 0
        minHeap.decrease(srcVertex, 0);

        //put it in map
        distanceMap.put(srcVertex, 0);

        //source vertex parent is null
        parentMap.put(srcVertex, null);
        
        //minHeap.printHeap();
        
        while(!minHeap.empty()) {
        	
        	Node node = minHeap.extractMinNode();
        	Vertex current = node.v;
        	//System.out.println("Current Node -> " + current.id + " with weight = " + node.weight);
        	distanceMap.put(current, node.weight);
        	
        	for(Edge edge : current.getEdges()) {
        		//System.out.println("Considering " + edge.toString());
        		Vertex adjacent = edge.getDestVertex();
        		//System.out.println("Adjacent vertex -> " + adjacent.id);
        		if(!minHeap.containsData(adjacent)) {
        			continue;
        		}
        		
        		 int newDistance = distanceMap.get(current) + edge.getWeight();
        		 //System.out.println("New distance -> " + newDistance);
        		 
        		 if(minHeap.getWeight(adjacent) > newDistance) {
                     minHeap.decrease(adjacent, newDistance);
                     parentMap.put(adjacent, current);
                 }
        	}
        }
        
        if(distanceMap.get(destVertex) < -1000000) {
        	distance = -1;
        }
        else {
        	distance = distanceMap.get(destVertex);
        }
        
        return distance;

        
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
        
        
      System.out.println(graph.distance(graph.getAllVertices(), x, y));
    }
}
