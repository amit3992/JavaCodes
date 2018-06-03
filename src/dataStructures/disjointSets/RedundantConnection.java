package dataStructures.disjointSets;

public class RedundantConnection {
	
class DisjointSet {
        
        private int count = 0;
        private int [] parent;
        private int [] rank;
        
        DisjointSet(int n) {
            
            count = n;
            parent = new int[n];
            rank = new int[n];
            
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA == parentB) {
                return;
                /* Add edge to result */
            }
            
            if(rank[parentA] >= rank[parentB]) {
                parent[parentB] = parentA;
                
                if(rank[parentA] == rank[parentB]) {
                    rank[parentA]++;
                }
            } else {
                parent[parentA] = parentB;
            }
            
            count--;
        }
        
        public int find(int p) {
            
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            
            return p;
        }
        
    }

	public int[] findRedundantDirectedConnection(int[][] edges) {
    
    if(edges == null) {
        return null;
    }
    
    int n = edges.length;
    DisjointSet myds = new DisjointSet(n);
    int [] result = new int[2];
    
    for(int i = 0; i < n; i++) {
        
        System.out.println("Edge 1: " + edges[i][0]);
        System.out.println("Edge 2: " + edges[i][1]);
        
        int a = edges[i][0];
        int b = edges[i][1];
        
        int parentA = myds.find(a - 1);
        int parentB = myds.find(b - 1);
        
        if(parentA == parentB) {
            System.out.println("edge1-> " + a + " and edge2 -> " + b + " have the same parent so can be removed. ");
            result[0] = a;
            result[1] = b;
            
        } else {
            System.out.println("Combining edge1-> " + a + " and edge2 -> " + b);
            myds.union(a - 1, b - 1);
        }
        
    }
    
    return result;
    
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] edges1 = {{1, 2},
							{1, 3},
							{2, 3}};
		
		int [][] edges2 = {
				{1, 2},
				{2, 3},
				{3, 4},
				{4, 1},
				{1, 5}};
		RedundantConnection rc = new RedundantConnection();
		int [] res = rc.findRedundantDirectedConnection(edges2);
		
		System.out.println("Redundant edge is -> [" + res[0] + "," + res[1] + "]");
		

	}

}
