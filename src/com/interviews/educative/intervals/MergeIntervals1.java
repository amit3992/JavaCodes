package com.interviews.educative.intervals;
import java.util.*;

public class MergeIntervals1 {

    public List<Interval> mergeIntervals(List<Interval> intervals) {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(5, 18);

        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        MergeIntervals1 mi = new MergeIntervals1();

        List<Interval> mergedIntervals = mi.mergeIntervals(intervals);
        for(Interval i : mergedIntervals) {
            System.out.println(i.toString());
        }




	}

}
