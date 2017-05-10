package leetCode;
import java.util.*;

class Interval {
	int start;
	int end;
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergeOverlappingIntervals {
	
	public ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals) {
		int size = intervals.size();
		
		int[] start = new int[size];
		int[] end = new int[size];
		
		int count = 0;
		for(Interval i : intervals) {
			start[count] = i.start;
			end[count] = i.end;
			count++;
		}
		
		// Sort start and end times
		Arrays.sort(start);
		Arrays.sort(end);
		
		ArrayList<Interval> result = new ArrayList<Interval>();
		
		for(int i = 0, j = 0; i < size; i++) {
			if (i == size - 1 || start[i + 1] > end[i]) {
				result.add(new Interval(start[j], end[i]));
				j = i + 1;
			}
		}
		
		return result;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		
		while(n > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			intervals.add(new Interval(a,b));
			n--;
		}
		
		MergeOverlappingIntervals mi = new MergeOverlappingIntervals();
		
		intervals = mi.mergeIntervals(intervals);
		
		for(Interval i: intervals) {
			System.out.println("(" + i.start + "," + i.end + ")");
		}
		
		
		
	}

}
