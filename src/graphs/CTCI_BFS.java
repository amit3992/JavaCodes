package graphs;
import java.util.*;

public class CTCI_BFS {

    LinkedList [] adjList;
    int size;

    public CTCI_BFS(int size) {
        this.size = size;
        adjList = new LinkedList[this.size];

       for(int i = 0; i < this.size; i++) {
           adjList[i] = new LinkedList();
       }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public int [] shortestReach(int start) {

        if(start > this.size) {
            return new int[0];
        }

        int [] distances = new int[this.size];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        distances[start] = 0;
        HashSet<Integer> visited = new HashSet<Integer>();
        visited.add(start);

        while(!queue.isEmpty()) {
            Integer current = queue.poll();

            ListIterator<Integer> it = adjList[current].listIterator();

            while(it.hasNext()) {
                int node = it.next();

                if(!visited.contains(node)) {
                    queue.offer(node);
                    visited.add(node);
                    distances[node] = distances[current] + 6;
                }
            }

        }

        return distances;

    }
    public static void main(String [] args) {

        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        CTCI_BFS [] gObjs = new CTCI_BFS[q];

        while(q-- > 0) {

            System.out.println("==================================================");
            System.out.println("Query: " + q);
            int nNodes = scan.nextInt();
            int nEdges = scan.nextInt();

            gObjs[q] = new CTCI_BFS(nNodes);
            System.out.println("Nodes -> " + nNodes);
            System.out.println("Edges -> " + nEdges);

            while(nEdges-- > 0) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                System.out.println("Start -> " + start);
                System.out.println("End -> " + end);
                gObjs[q].addEdge(start, end);
            }

            int startNode = scan.nextInt();
            System.out.println("Start -> " + startNode);
            int [] distances = gObjs[q].shortestReach(startNode);
            System.out.println("Distances:");
            System.out.println(Arrays.toString(distances));
        }

    }
}
