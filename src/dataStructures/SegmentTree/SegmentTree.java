package dataStructures.SegmentTree;

public class SegmentTree {
	
	/* Array that stores the segment tree nodes */
	int [] st;
	
	/* Constructor to construct segment tree from given array */
	SegmentTree(int [] array, int n) {
		
		/* Allocate memory for segment tree */
		int h = (int) (Math.ceil( Math.log(n) / Math.log(2)));
		
		int max_size = 2 * (int) Math.pow(2, h) - 1;
		st = new int[max_size];
		
		constructSegmentTree(array, 0, n - 1, 0);
		
	}
	
	/* Method which gets range sum from rStart to rEnd */
	public int getSum(int n, int rStart, int rEnd) {
		if(rStart < 0 || rEnd > n - 1 || rStart > rEnd) {
			System.out.println("Invalid input");
			return -1;
		}
		
		return getSumUtil(0, n - 1, rStart, rEnd, 0);
	}
	
	private int getSumUtil(int s_start, int s_end, int q_start, int q_end, int s_index) {
		
		/* If segment is a part of a range, return the sum of that segment */
		if(q_start <= s_start && q_end >= s_end) {
			return st[s_index];
		}
		
		/* If segment is out of range */
		if(s_end < q_start || s_start > q_end) {
			return -1;
		}
		
		int mid = getMid(s_start, s_end);
		
		return getSumUtil(s_start, mid, q_start, q_end, 2 * s_index + 1)
				+ getSumUtil(mid + 1, s_end, q_start, q_end, 2*s_index + 2);
	}
	
	private int constructSegmentTree(int [] array, int s_start, int s_end, int s_index) {
		
		if(s_start == s_end) {
			st[s_index] = array[s_start];
			return array[s_start];
		}
		
		int s_mid = getMid(s_start, s_end);
		
		st[s_index] = constructSegmentTree(array, s_start, s_mid, 2 * s_index + 1)
							+ constructSegmentTree(array, s_mid + 1, s_end, 2 * s_index + 2);
		
		return st[s_index];
	}
	
	private int getMid(int start, int end) {
		
		return start + (end - start) / 2;
	}

}
