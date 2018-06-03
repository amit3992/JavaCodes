package com.interviews.educative.intervals;
import java.util.*;

/* Leetcode : 57
*  Intervals are sorted according to their start times
* */

public class InsertInterval {

    private List<Interval> mergeIntervals(List<Interval> intervals) {

        if(intervals == null || intervals.size() == 0) {
            return intervals;
        }

        List<Interval> result = new ArrayList<Interval>();
        result.add(intervals.get(0));

        for(int i = 1; i < intervals.size(); i++) {

            Interval newI = intervals.get(i);
            Interval oldI = result.get(result.size() - 1);

            int x_new = newI.start;
            int y_new = newI.end;

            int x_old = oldI.start;
            int y_old = oldI.end;

            if(y_old >= x_new) {
                oldI.end = Math.max(y_new, y_old);
            } else {
                result.add(newI);
            }
        }

        return result;
    }

    public List<Interval> addInterval(List<Interval> intervals, Interval newInterval) {

        if(intervals == null || intervals.size() == 0) {
            if(intervals.size() == 0) {
                intervals.add(newInterval);
                return intervals;
            }

            return intervals;
        }

        /* Add new interval */
        intervals.add(newInterval);

        /* Sort intervals */
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        /* Merge intervals */
        intervals = mergeIntervals(intervals);

        return intervals;
    }

    public static void main(String [] args) {

        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(6,9);
        Interval newI = new Interval(2, 5);

        Interval a = new Interval(1,2);
        Interval b = new Interval(3,5);
        Interval c = new Interval(6,7);
        Interval d = new Interval(8,10);
        Interval e = new Interval(12,16);

        Interval new2 = new Interval(4, 8);


        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);


        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(a);
        intervals2.add(b);
        intervals2.add(c);
        intervals2.add(d);
        intervals2.add(e);

        InsertInterval ii = new InsertInterval();

        //List<Interval> result = ii.addInterval(intervals, newI);
        List<Interval> result = ii.addInterval(intervals2, new2);
        System.out.println("Rearranged intervals are -> ");
        for(Interval i : result) {
            System.out.println(i.toString());
        }

    }
}
