package cache.lru;
import java.util.*;

public class LRUCache {
	
	HashMap<Integer, Node> nodeMap;
	int capacity;
	int count;
	Node head;
	Node tail;
	
	LRUCache(int capacity) {
		this.capacity = capacity;
		nodeMap = new HashMap<Integer, Node>();
		
		this.count = 0;
		
		head = new Node(0,0);
		tail = new Node(0,0);
		
		head.next = tail;
		tail.pre = head;
		head.pre = null;
		tail.next = null;
		
	}
	
	private void addToHead(Node node) {
		
		node.next = head.next;
		node.next.pre = node;
		node.pre = head;
		head.next = node;
		
	}
	
	public void deleteNode(Node node) {
		
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
	
	public int get(int key) {
		if(nodeMap.get(key) != null) {
			Node node = nodeMap.get(key);
			int result = node.value;
			
			deleteNode(node);
			addToHead(node);
			
			return result;
		}
		else {
			return -1;
		}
	}
	
	public void put(int key, int value) {
		if(nodeMap.get(key) != null) {
			Node node = nodeMap.get(key);
			deleteNode(node);
			addToHead(node);
		}
		else {
			Node node = new Node(key, value);
			nodeMap.put(key, node);
			if(count < this.capacity) {
				count++;
				addToHead(node);
			}
			else {
				nodeMap.remove(tail.pre.key);
				deleteNode(tail.pre);
				addToHead(node);
			}
		}
	}

}
