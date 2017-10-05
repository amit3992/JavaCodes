package dataStructures.disjointSets;

import java.util.*;

public class DisjointSet {
	
	private HashMap<Long, Node> map = new HashMap<>();
	
	class Node {
		long data;
		Node parent;
		int rank;
		int total = 1;
	}
	
	
	// Creates a set with only one elements
	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.parent = node;	// Points the parent to itself
		node.rank = 0;
		map.put(data,node);
	}
	
	public int getTotal(long a, long b) {
		
		Node p1 = findSet(map.get(a));
		Node p2 = findSet(map.get(b));
		
		int sum = p1.total + p2.total;
		return sum;
	}
	
	// Combines two sets together. Union by rank.
	public boolean Union(long data1, long data2) {
		
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);
		
		Node parent1 = findSet(node1);
		Node parent2 = findSet(node2);
		
		// If they're part of the same set. Do nothing
		if(parent1.data == parent2.data) {
			return false;
		}
		
		// Else whoever's rank is higher becomes the parent
		if(parent1.rank >= parent2.rank) {
			//Increment rank only if both sets have same rank
			parent1.rank = (parent1.rank == parent2.rank) ? 1 + parent1.rank : parent1.rank;
			parent2.parent = parent1;
			
			parent1.total = parent1.total + 1;
		}
		else  {
			parent1.parent = parent2;
			parent2.total = parent2.total + 1;
		}
		
		return true;
	}
	
	public long findSet(long data) {
		
		return findSet(map.get(data)).data;
	}
	
	// Finds a parent of a node and also does path compression.
	private Node findSet(Node node) {
		Node parent = node.parent;
		if(parent == node)
			return parent;
		
		node.parent = findSet(node.parent);
		return node.parent;
	}
	 
}
