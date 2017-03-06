package graphs;
import java.util.*;

/* Data structure which supports following operations
 * 1] containsKey - O(1)
 * 2] addToHeap - O(logN)
 * 3] extractMin - O(logN)
 * 4] decreaseKey - O(logN)
 * 5] getKeyWeight - O(1)
 * 
 *  - it's a combination of binary heap and hashMap
 * 
 */

public class BinaryMinHeap<T> {
	
	public class Node {
		int weight;
		T key;
		
		Node(int weight, T key) {
			this.weight = weight;
			this.key = key;
		}
	}
	
	private List<Node> allNodes = new ArrayList<Node>();
	private HashMap<T, Integer> nodeMap = new HashMap<T, Integer>();
	
	// Check whether key exists in binary heap
	public boolean containsData(T key) {
		return nodeMap.containsKey(key);
	}
	
	// Add data in binary heap
	public void Add(int weight, T key) {
		Node node = new Node(weight, key);
		
		allNodes.add(node);
		int size = allNodes.size();
		int current = size - 1;
		int parentIndex = (current - 1)/2;
		nodeMap.put(node.key, current);
		
		while(parentIndex >= 0) {
			Node parentNode = allNodes.get(parentIndex);
			Node currentNode = allNodes.get(current);
			
			if(parentNode.weight > currentNode.weight) {
				swap(parentNode, currentNode);
				updatePositionInMap(parentNode.key, currentNode.key, parentIndex, current);
				current = parentIndex;
				parentIndex = (parentIndex - 1)/2;
			}
			else {
				break;
			}
		}
	}
	
	// Get heap min
	public T getMin() {
		return allNodes.get(0).key;
	}
	
	// Check if heap is empty
	public boolean isEmpty() {
		return allNodes.size() == 0;
	}
	
	// Decrease weight of given key to newWeight
	public void decreaseWeight(T data, int newWeight) {
		Integer position = nodeMap.get(data);
		allNodes.get(position).weight = newWeight;
		int parent = (position - 1)/2;
		
		while(parent >= 0) {
			if(allNodes.get(parent).weight > allNodes.get(position).weight) {
				swap(allNodes.get(parent), allNodes.get(position));
				updatePositionInMap(allNodes.get(parent).key, allNodes.get(position).key, parent, position);
				position = parent;
				parent = (parent - 1)/2;
			}
			else {
				break;
			}
		}
	}
	
	public Integer getWeight(T key) {
		Integer position = nodeMap.get(key);
		if(position == null)
			return null;
		else {
			return allNodes.get(position).weight;
		}
	}
	
	public Node extractMinNode() {
		int size = allNodes.size() -  1;
		Node minNode = new Node(allNodes.get(0).weight, allNodes.get(0).key);
		
		int lastNodeWeight = allNodes.get(size).weight;
		allNodes.get(0).weight = lastNodeWeight;
		allNodes.get(0).key = allNodes.get(size).key;
		
		nodeMap.remove(minNode.key);
		nodeMap.remove(allNodes.get(0));
		
		nodeMap.put(allNodes.get(0).key, 0);
		allNodes.remove(size);
		
		int currentIndex = 0;
		size--;
		
		while(true) {
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;
			
			if(left > size) {
				break;
			}
			if(right > size) {
				right = left;
			}
			
			int smallIndex = allNodes.get(left).weight <= allNodes.get(right).weight ? left : right;
			if(allNodes.get(currentIndex).weight > allNodes.get(smallIndex).weight) {
				swap(allNodes.get(currentIndex), allNodes.get(smallIndex));
				updatePositionInMap(allNodes.get(currentIndex).key, allNodes.get(smallIndex).key, currentIndex, smallIndex);
				currentIndex = smallIndex;
			}
			else {
				break;
			}
		}
		
		return minNode;
	}
	
	
	public T extractMin() {
		Node node = extractMinNode();
		return node.key;
	}
	
	private void swap(Node node1, Node node2) {
		int weight = node1.weight;
		T data = node1.key;
		
		node1.key = node2.key;
		node1.weight = node2.weight;
		
		node2.key = data;
		node2.weight = weight;
	}
	
	private void updatePositionInMap(T key1, T key2, int pos1, int pos2) {
		// TODO Auto-generated method stub
		nodeMap.remove(key1);
		nodeMap.remove(key2);
		
		nodeMap.put(key1, pos1);
		nodeMap.put(key2, pos2);
		
		
	}
	
	public void printHeap(){
        for(Node n : allNodes){
            System.out.println(n.weight + " " + n.key);
        }
    }

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
		heap.Add(3, "Amit");
		heap.Add(4, "Brian");
		heap.Add(8, "Caleb");
		heap.Add(1, "Damien");
		heap.Add(10, "Elon");
		
		heap.printHeap();
		heap.decreaseWeight("Lisa", 11);
		heap.printHeap();
		//System.out.println("Min weight string: " + heap.extractMin());
		
		
		//System.out.println("Min weight string: " + heap.extractMin());

	}

}
