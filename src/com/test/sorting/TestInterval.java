package com.test.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class TestInterval {
	
	@Test
	public void test2() {
		
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(i2);
		list.add(i1);
		list.add(i3);
		

		Collections.sort(list, new IntervalComparator());
		
		System.out.println(list);
		
		
		
	}

}
