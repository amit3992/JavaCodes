package code;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
 
public class MapSort {
 
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
 
		int maxValue = (Collections.max(map.values()));
		System.out.println(maxValue);
		for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                System.out.println(entry.getKey());
            }
        }
	}
 
	
}
