package cache.lru;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LRUCache lru = new LRUCache(5);
		lru.set(1, 10);
		lru.set(2, 20);
		lru.set(3, 30);
		lru.set(4, 40);
		lru.set(5, 50);
		
		System.out.println("Original contents: ");
		lru.printCache();
		
		lru.get(5);
		lru.set(3, 70);
		lru.set(7, 110);
		
		System.out.println();
		System.out.println("Cache status");
		lru.printCache();

	}

}
