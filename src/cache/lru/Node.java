// Node class for least recently used cache
package cache.lru;

public class Node {
	int key;
	int value;
	Node pre;
	Node next;
	
	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
