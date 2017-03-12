package mergingTables;

import java.util.*;

//import dataStructures.disjointSets.DisjointSet.Node;

public class MergeTables {
	
	int maxNumOfRows = -1;
	private HashMap<Integer, Table> map = new HashMap<>();
	
	// Creates a set with only one elements
		public void makeSet(int nodeNum, int numOfRows) {
			Table table = new Table(nodeNum, numOfRows);
			map.put(nodeNum,table);
		}
		
		// Finds a parent of a node and also does path compression.
		private Table findSet(Table node) {
			Table parent = node.parent;
			if(parent == node)
				return parent;
			
			node.parent = findSet(node.parent);
			return node.parent;
		}
		
		public void numberOfRowsInSet(int rowNum) {
			int node = map.get(rowNum).nodeNum;
			int num = findSet(map.get(rowNum)).numberOfRows;
			System.out.println("Number of rows in set -> " + node + " == " + num);
		}
		
		// Combines two sets together. Union by rank.
		public boolean Union(int node1, int node2) {
			
			Table table1 = map.get(node1);
			Table table2 = map.get(node2);
			
			Table parent1 = findSet(table1);
			Table parent2 = findSet(table2);
			
			// If they're part of the same set. Do nothing
			if(parent1.nodeNum == parent2.nodeNum) {
				return false;
			}
			
			// Else whoever's rank is higher becomes the parent
			if(parent1.rank >= parent2.rank) {
				//Increment rank only if both sets have same rank
				parent1.rank = (parent1.rank == parent2.rank) ? 1 + parent1.rank : parent1.rank;
				parent1.numberOfRows = parent1.numberOfRows + parent2.numberOfRows;
				maxNumOfRows = parent1.numberOfRows;
				parent2.numberOfRows = 0;
				parent2.parent = parent1;
			}
			else  {
				parent1.parent = parent2;
				parent1.parent.numberOfRows = parent1.parent.numberOfRows + parent1.numberOfRows; // CHECK 
			}
			
			return true;
		}

}
