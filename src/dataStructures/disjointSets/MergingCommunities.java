package dataStructures.disjointSets;

import java.io.*;
import java.util.*;

public class MergingCommunities {
    
    static class DisjointSet {
        int count;
        private int [] parent;
        private int[] rank;
        private int [] commSize;
        
        DisjointSet(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            commSize = new int[n];
            
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                commSize[i] = 1;
            }
            
            
        }
        
        public void merge(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            
            if(parentA == parentB) {
                return;
            }
            
            if(rank[parentA] >= rank[parentB]) {
                parent[parentB] = parentA;
                commSize[parentA]++;
                if(rank[parentA] == rank[parentB]) {
                    rank[parentA]++;
                }
            } else {
                parent[parentA] = parentB;
                commSize[parentB]++;
            }
            
            count--;
        }
                
        private int find(int p) {
        	int root = p;
            
        	while (root != parent[root])
                root = parent[root];
            
            while (p != root) {
                int newp = parent[p];
                parent[p] = root;
                p = newp;
            }
            return root;
        }
        
        public int getCount() {
            return count;
        }
        
        public int getSize(int member) {
            if(member > commSize.length) {
                return -1;
            }
            int parent = find(member);
            return commSize[parent];
        }
        
        
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        int members = sc.nextInt();
        int q = sc.nextInt();
        
        System.out.println("Members: " + members + "| Queries: " + q);
        DisjointSet djs = new DisjointSet(members);
        while(q-- > 0) {
            String query = sc.next();
            
            switch(query) {
                case "Q":
                    int val = sc.nextInt();
                    System.out.println(query + " -> " + val);
                    //System.out.println(djs.getCount());
                    System.out.println(djs.getSize(val - 1));
                    break;
                case "M":
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println("Merge: " + a + " & " + b);
                    djs.merge(a-1, b-1);
                    break;
                default :
                    System.out.println("Invalid input");
                    break;
                    
            }
            
        }
    }
}