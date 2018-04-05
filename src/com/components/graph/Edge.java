package com.components.graph;

public class Edge<T> {
	
	private boolean isDirected = false;
	private Vertex<T> v1;
	private Vertex<T> v2;
	private int weight;
	
	Edge(Vertex<T> v1, Vertex<T> v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	Edge(Vertex<T> v1, Vertex<T> v2, boolean isDirected, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.isDirected = isDirected;
		this.weight = weight;
	}
	
	Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected){
        this.v1 = vertex1;
        this.v2 = vertex2;
        this.isDirected = isDirected;
    }
	
	Vertex<T> getVertex1(){
        return v1;
    }
    
    Vertex<T> getVertex2(){
        return v2;
    }
    
    int getWeight(){
        return weight;
    }
    
    public boolean isDirected(){
        return isDirected;
    }
    
    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + v1
                + ", vertex2=" + v2 + ", weight=" + weight + "]";
    }
	
	

}
