package dataStructures.disjointSets;

/* Number of connected components 
 * in an undirected graph
 * 
 * LC 323
 * */

public class ConnectedComponents {
	
	class MyDS {
		
		int count;
		int [] parent;
		int [] rank;
		
		MyDS(int n) {
			count = n;
			parent = new int[n];
			rank = new int[n];
			
			/* Assign each node as parent of itself */
			for(int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}
		
		/* Method to connect to nodes together */
		public void union(int a, int b) {
			
			int pA = find(a);
			int pB = find(b);
			
			/* If they belong to the same set, return */
			if(pA == pB) {
				return;
			}
			
			/* If rank of parent A is greater, join them together */
			if(rank[pA] >= rank[pB]) {
				parent[pB] = pA;
				
				if(rank[pA] == rank[pB]) {
					rank[pA]++;
				}
			} else {
				parent[pA] = pB;
			}
			
			/* Decrement count after union */
			count--;
		}
		
		private int find(int p) {
			
			while(p != parent[p]) {
				parent[p] = parent[parent[p]];
				p = parent[p];
			}
			
			return p;
		}
	}

}
