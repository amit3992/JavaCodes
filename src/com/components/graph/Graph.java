package com.components.graph;
import java.util.*;

public class Graph<T> {
	
	private List<Edge<T>> allEdges;
	private Map<Long, Vertex<T>> allVertices;
	boolean isDirected = false;
	
	public Graph(boolean isDirected) {
		allEdges = new ArrayList<>();
		allVertices = new HashMap<>();
	}
	
	public void addEdge(long id1, long id2) {
		addEdge(id1, id2, 0);
	}
	
	public void addEdge(long id1, long id2, int weight) {
		Vertex<T> v1 = null;
		if(allVertices.containsKey(id1)) {
			v1 = allVertices.get(id1);
		} else {
			v1 = new Vertex<>(id1);
			allVertices.put(id1, v1);
		}
		
		Vertex<T> v2 = null;
		if(allVertices.containsKey(id2)) {
			v2 = allVertices.get(id2);
		} else {
			v2 = new Vertex<>(id2);
			allVertices.put(id2, v2);
		}
		
		Edge<T> edge = new Edge<>(v1, v2, isDirected, weight);
		allEdges.add(edge);
		v1.addAdjacentVertex(edge, v2);
		
		if(!isDirected) {
			v2.addAdjacentVertex(edge, v1);
		}
	}
	
	public List<Edge<T>> getAllEdges(){
        return allEdges;
    }
    
    public Collection<Vertex<T>> getAllVertex(){
        return allVertices.values();
    }
    
    public void setDataForVertex(long id, T data){
        if(allVertices.containsKey(id)){
            Vertex<T> vertex = allVertices.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
	
}
