package com.utils.iterator;
import java.util.*;

public class EnumerationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Add elements to list */
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < 5; i++) {
			map.put("Number + " + i + "] ", i + 10);
		}
		
		Enumeration<String> e = Collections.enumeration(map.keySet());
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
	}

}
