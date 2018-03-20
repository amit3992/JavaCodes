package com.test.sorting;

import java.util.Comparator;

public class IntervalComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval a, Interval b) {
		// TODO Auto-generated method stub
		return a.start - b.start;
	}

}
