package dataStructures.disjointSets;

public class FriendCircles {
	
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
            }
            
            if(rank[parentA] > rank[parentB]) {
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
        
        public int getCount() {
            return count;
        }
    }
    
    
    public int findCircleNum(int[][] M) {
        
        if(M == null) {
            return -1;
        }
        
        int row = M.length; // Number of students
        
        DisjointSet djs = new DisjointSet(row);
        for(int i = 0; i < row - 1; i++) {
            for(int j = i + 1; j < row; j++) {
                if(M[i][j] == 1) {
                    djs.union(i,j);
                }
            } 
        }
        
        return djs.getCount();
        
    }
}

