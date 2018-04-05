package com.components.graph;
import java.util.*;

public class Vertex<T> {
	
	long id;
	private T data;
	private List<Edge<T>> edges = new ArrayList<>();
	private List<Vertex<T>> adjacentVertices = new ArrayList<>();
	
	Vertex(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge<T>> edges) {
		this.edges = edges;
	}

	public List<Vertex<T>> getAdjacentVertices() {
		return adjacentVertices;
	}

	public void setAdjacentEdges(List<Vertex<T>> adjacentEdges) {
		this.adjacentVertices = adjacentEdges;
	}
	
	public void addAdjacentVertex(Edge<T> e, Vertex<T> v) {
		edges.add(e);
		adjacentVertices.add(v);
	}
	
	public int getDegree() {
		return edges.size();
	}
	

}
