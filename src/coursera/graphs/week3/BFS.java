package coursera.graphs.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class BFS {
	private static int V; // vertices;
	
	public static boolean isNeighbor(int u, int v, ArrayList<Integer>[] adj)
	{
		if(adj[u]==null)
			return false;
		return adj[u].contains(v);			
	}
	
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
    	ArrayList<Integer> pathList = new ArrayList<Integer>();
    	int numEdges = 0;
    	HashMap<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    	
    	if(s == t)
    		return numEdges;
    	
    	int n;
    	int a;
    	LinkedList<Integer> queue = new LinkedList<Integer>();
    	Stack<Integer> pathStack = new Stack<Integer>();
    	boolean found = false;
    	
    	queue.add(s);
    	pathStack.push(s);
    	visited.put(s, true);
    	
    	
    	while(!queue.isEmpty() && !found) {
    		
    		a = queue.poll();
    		//System.out.println(a + " ");
    		
    		Iterator<Integer> it = adj[a].listIterator();
    		while(it.hasNext()) {
    			n = it.next();
    			if(!visited.containsKey(n)) {
    				queue.add(n);
    				visited.put(n, true);
    				pathStack.add(n);
    				if(n == t) {
    					found = true;
    					break;
    				}
    			}
    		}
    		
    	}
    	
    	int node = t;
    	int dest = t;
    	pathList.add(t);
    	while(!pathStack.isEmpty())
		{
			node = pathStack.pop();
			if(isNeighbor(dest, node, adj))
			{
				pathList.add(node);
				
				dest = node;
				if(node == s)
					break;
			}
		}
    	
    	System.out.println(pathList.toString());
    	if(pathList.size() - 1 > 0)
    		numEdges = pathList.size() - 1;
    	else
    		numEdges = -1;
		
    	return numEdges;
    	
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

