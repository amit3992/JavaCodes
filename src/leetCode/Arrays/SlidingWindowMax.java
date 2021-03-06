package leetCode.Arrays;
import java.util.*;

public class SlidingWindowMax {
	
	int win_sz;
	int[] window;
	ArrayList<Integer> result;
	
	public SlidingWindowMax(int win_sz) {
		this.win_sz = win_sz;
		window = new int[this.win_sz];
		result = new ArrayList<Integer>();
	}
	
	public int getMax(int start, int end, int[] array) {
		int max = Integer.MIN_VALUE;
		for(int i = start; i <= end; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}
	
	public ArrayList<Integer> slideWindowNaive(int[] array) {
		if(array.length == 0 || array == null) {
			return result;
		}
		
		for(int i = 0; i < array.length; i++) {
			int j = i + this.win_sz - 1;
			
			if(j + 1 > array.length) {
				break;
			} else {
				result.add(getMax(i, j, array));
			}
			
		}
		
		return result;
	}
	
	/* ===============================================  Linear time solution ==================================================== */
	public ArrayList<Integer> slideWindowSmart(int[] array) {
		int n = array.length;
		
		int[] left_max = new int[n];
		int[] right_max = new int[n];
		
		left_max[0] = array[0];
		right_max[n - 1] = array[n - 1];
		
		for(int i = 1; i < n; i++) {
			
			if(i % this.win_sz == 0) {
				left_max[i] = array[i];
			} else {
				left_max[i] = Math.max(left_max[i-1], array[i]);
			}
			
			final int j = array.length - i - 1;
			
			if(j % this.win_sz == 0) {
				right_max[j] = array[j];
			} else {
				right_max[j] = Math.max(right_max[j + 1], array[j]);
			}
		}
		
		for(int i = 0; (i + this.win_sz) <= array.length; i++) {
			int val = Math.max(right_max[i], left_max[i + this.win_sz - 1]);
			result.add(val);
		}
		
		return result;
	}
	
	
	/* ========================================================= ARRAY DEQUE SOLUTION ============================================================= */
	
	public ArrayList<Integer> slidingWindowDeque(int[] array) {
		
		int n = array.length;
		
		if(n < this.win_sz) {
			return new ArrayList<Integer>();
		}
		
		// Declare array deque
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		
		// Get max for the first window
		for(int i = 0; i < this.win_sz; i++) {
			
			while(!queue.isEmpty() && array[i] >= queue.peekLast()) {
				queue.removeLast();
			}
			
			queue.addLast(array[i]);
		}
		
		result.add(queue.peekFirst());
		
		for(int i = this.win_sz; i < n; i++) {
			
			/*Remove all the elements which are smaller than current number from the tail of the queue*/
			while(!queue.isEmpty() && array[i] >= queue.peekLast()) {
				queue.removeLast();
			}
			
			/* Remove first number if it doesnt fall in the window anymore*/
			if(!queue.isEmpty() && queue.peekFirst() <= array[i - this.win_sz]) {
				queue.removeFirst();
			}
			
			queue.addLast(array[i]);
			
			result.add(queue.peekFirst());
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		int[] array = {1,3,-1,-3,5,3,6,7};
		int win_size = 3;
		
		SlidingWindowMax sw = new SlidingWindowMax(win_size);
		
		System.out.println("Linear time solution -> ");
		for(int i: sw.slideWindowSmart(array)) {
			System.out.print(i + " ");
		}
		
		
		System.out.println("\nArray deque solution -> ");
		for(int i: sw.slidingWindowDeque(array)) {
			System.out.print(i + " ");
		}
		

	}

}
