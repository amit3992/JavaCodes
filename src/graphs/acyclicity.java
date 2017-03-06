package graphs;

import java.util.ArrayList;
import java.util.*;

public class acyclicity {
	private static int V;
	
	private static boolean isCyclic(int v, boolean[] visited, boolean[] greyStack, ArrayList<Integer>[] adj) {
		
		Integer num;
		if(visited[v] == false) {
			
			visited[v] = true;
			greyStack[v] = true;
			
			Iterator<Integer> it = adj[v].listIterator();
			while(it.hasNext()) {
				num = it.next();
				if(!visited[num] && isCyclic(num, visited, greyStack, adj))
					return true;
				else if(greyStack[num])
					return true;
			}
			
		}
		
		greyStack[v] = false;
		return false;
		
	}
  private static int acyclic(ArrayList<Integer>[] adj) {
      //write your code here
  	boolean[] visited = new boolean[V];
  	boolean [] greyStack = new boolean[V];
  	
  	for(int i = 0; i < V; i++) {
  		visited[i] = false;
  		greyStack[i] = false;
  	}
  	
  	for(int i = 0; i < V; i++) {
  		if(isCyclic(i, visited, greyStack, adj ))
  			return 1;
  	}
  	
      return 0;
  }

  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      V = n;
      int m = scanner.nextInt();
      ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
      for (int i = 0; i < n; i++) {
          adj[i] = new ArrayList<Integer>();
      }
      for (int i = 0; i < m; i++) {
          int x, y;
          x = scanner.nextInt();
          y = scanner.nextInt();
          adj[x - 1].add(y - 1);
      }
      System.out.println(acyclic(adj));
  }
}


