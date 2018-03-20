package com.test.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Tests {
	
	@Test
	public void test() {
		
		Users user = new Users();
		user.setUsername("Aaron");
		user.setPassword("burr");
		
		Users user1 = new Users();
		user1.setUsername("Alexander");
		user1.setPassword("hamilton");
		
		Users user2 = new Users();
		user2.setUsername("Marquis");
		user2.setPassword("lafayette");
		
		List<Users> list = new ArrayList<Users>();
		list.add(user1);
		list.add(user2);
		list.add(user);
		
		Collections.sort(list);
		
		System.out.println(list);
		assertThat(list.get(0).username, is("Aaron"));
		assertThat(list.get(1).username, is("Alexander"));
		assertThat(list.get(2).username, is("Marquis"));
		
	}
	
	@Test
	public void test2() {
		
		String name1 = "Alexander";
		String name2 = "aaron";
		String name3 = "eliza";
		String name4 = "Marquis";
		String name5 = "angelica";
		
		List<String> list = new ArrayList<String>();
		list.add(name5);
		list.add(name4);
		list.add(name1);
		list.add(name2);
		list.add(name3);
		

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
				
			}
		}); 
		
		
		System.out.println(list);
		
		
		
	}
}
