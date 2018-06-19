package com.interviews.google;
import java.util.*;

public class AddBoldTag {

    class Interval {

        int start, end;
        public Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "[" + start + ", " + end + "]" ;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });


        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));

        for(int i = 1; i < intervals.size(); i++) {

            Interval current = intervals.get(i);
            Interval previous = res.get(res.size() - 1);

            int cur_start = current.start;
            int cur_end = current.end;

            int prev_start = previous.start;
            int prev_end = previous.end;

            if(cur_start <= prev_end) {
                previous.end = Math.max(current.end, previous.end);
            } else {
                res.add(current);
            }
        }

        return res;
    }


    public String addBoldTag(String s, String[] dict) {

        List<Interval> intervals = new ArrayList<>();

        for (String str : dict) {
            int index = -1;
            index = s.indexOf(str, index);
            while (index != -1) {
                intervals.add(new Interval(index, index + str.length()));
                index +=1;
                index = s.indexOf(str, index);
            }
        }


        System.out.println(Arrays.toString(intervals.toArray()));
        intervals = merge(intervals);
        System.out.println(Arrays.toString(intervals.toArray()));

        int prev = 0;
        StringBuilder sb = new StringBuilder();

        for (Interval interval : intervals) {
            sb.append(s.substring(prev, interval.start));
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end));
            sb.append("</b>");
            prev = interval.end;
        }

        if (prev < s.length()) {
            sb.append(s.substring(prev));
        }

        return sb.toString();
    }



    public static void main(String [] args) {

        String [] dict = {"aaa", "aab", "bc"};
        String [] dict2 = {"abc", "123"};

        String input2 = "abcxyz123";
        String input = "aaabbcc";

        AddBoldTag abt = new AddBoldTag();
        System.out.println("Output -> " + abt.addBoldTag(input2, dict2));
    }
}
