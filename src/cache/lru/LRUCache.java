package cache.lru;
import java.util.*;

public class LRUCache {
	
	int capacity;
	HashMap<Integer, Node> cache;
	LinkedList<Node> elements;
	
	LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<Integer, Node>();
		elements = new LinkedList<Node>();
	}
	
	public int get(int key) {
		
		Node val = cache.get(key);
		if(val == null) {
			System.out.println("Value doesn't exist in cache!");
			return -1;
		} else {
			elements.remove(val);
			elements.addLast(val);
			return val.data;
		}
	}
	
	public void set(int key, int value) {
		Node newNode = cache.get(key);
		
		if(newNode == null) {
			evictIfNeeded();
			newNode = new Node(key, value);
			cache.put(newNode.key, newNode);
			elements.addLast(newNode);
		} else {
			elements.remove(newNode);
			newNode = new Node(newNode.key, value);
			cache.put(key, newNode);
			elements.addLast(newNode);
		}
	}
	
	void evictIfNeeded() {
		if(cache.size() >= this.capacity) {
			Node evictNode = elements.removeFirst();
			cache.remove(evictNode.key);
		}
	}
	
	void printCache() {
		ListIterator<Node> lt = elements.listIterator();
		while(lt.hasNext()) {
			Node thisNode = lt.next();
			System.out.println("Key: " + thisNode.key + " | Value -> " + thisNode.data);
		}
			
			
	}

}
