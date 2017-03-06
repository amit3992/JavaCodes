package coursera.graphs.week3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bipartite {
	private static int V;
	
  private static int bipartite(ArrayList<Integer>[] adj) {
  	
  	LinkedList<Integer> q = new LinkedList<Integer>();
  	Integer u;
  	int[] color = new int[V];
  	for(int i = 0; i < V; i++)
  		color[i] = -1;
  	
  	color[0] = 1;
  	q.add(0);
  	
  	while(!q.isEmpty()) {
  		
  		int s = q.peek();
  		q.remove();
  		
  		Iterator it = adj[s].listIterator();
  		while(it.hasNext()) {
  			u = (Integer) it.next();
  			if(color[u] == -1) {
  				color[u] = 1 - color[s];
  				q.add(u);
  			}
  			else if (color[u] == color[s])
  				return 0;
  		}
  		
  	}
  	
      return 1;
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
          adj[y - 1].add(x - 1);
      }
      System.out.println(bipartite(adj));
  }
}

