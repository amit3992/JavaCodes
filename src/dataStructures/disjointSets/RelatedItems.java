package dataStructures.disjointSets;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Node {
	int data;
	Node parent;
	int rank;
	
}

public class RelatedItems {
	
	private HashMap<Integer, Node> nodeMap;
	
	RelatedItems() {
		nodeMap = new HashMap<Integer, Node>();
	}
	
	/* Wrapper method for makeSet */
	public void addItem(int item) {
		makeSet(item);
	}
	
	public void makeSet(int item) {
		Node node = new Node();
		node.data = item;
		node.parent = node;
		node.rank = 0;
		
		nodeMap.put(item, node);
	}
	
	public Node union(int item1, int item2) {
		
		Node node1 = find(item1);
		Node node2 = find(item2);
		
		if(node1 == null || node2 == null) {
			return null;
		}
		
		if(node1.data == node2.data) {
			return node1;
		}
		
		Node result = null;
		
		if(node1.rank > node2.rank) {
			node2.parent = node1;
			node1.rank++;
			result = node1;
		} else {
			node1.parent = node2;
			node2.rank++;
			result = node2;
		}
		
		return result;
		
	}
	
	public Node find(int item) {
		Node node = nodeMap.get(item);
		
		if(node == null) {
			return null;
		}
		
		if(node != node.parent) {
			node.parent = find(node.parent.data);
			return node.parent;
		}
		
		return node;
	}
	
	private int countSets() {
		int count = 0;
		
		for(Entry<Integer, Node> entry: nodeMap.entrySet()) {
			if(entry.getValue().parent == entry.getValue()) {
				count++;
			}
		}
		
		return count;
	}
	
	public List<Set<Integer>> getSets()
	{
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (Entry<Integer, Node> entry : nodeMap.entrySet())
		{
			Node n = find(entry.getValue().data);
			Set<Integer> set = map.get(n.data);
			if (set == null)
			{
				set = new HashSet<>();
				map.put(n.data, set);
			}
			set.add(entry.getValue().data);
		}
		return map.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
	}
	
	

	public static void main(String[] args) {
		
		RelatedItems ri = new RelatedItems();
		
		ri.addItem(1);
		ri.addItem(2);
		ri.addItem(3);
		ri.addItem(4);
		ri.addItem(5);
		ri.addItem(6);
		
		ri.union(1,2);
		ri.union(2,3);
		ri.union(2,4);
		ri.union(5,6);
		
		System.out.println("Count sets -> " + ri.countSets());
		System.out.println("Get set -> " + ri.getSets());
	

	}

}
