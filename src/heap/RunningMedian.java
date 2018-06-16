package heap;
import java.util.*;

public class RunningMedian {
	
	// Have two heaps. minHeap and maxHeap
	PriorityQueue<Integer> lowerBucket;
	PriorityQueue<Integer> upperBucket;
	
	public RunningMedian() {

	    /* Java has Min heap by default */
		upperBucket = new PriorityQueue<Integer>();

        /* Max Heap */
		lowerBucket = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}
		});
		
	}
	
	public void getRunningMedian(int[] array) {
		
		if(array == null || array.length == 0) {
			return;
		}
		
		for(int i = 0; i < array.length; i++) {
			addNumber(array[i]);
			rebalanceBuckets();
			double median = getMedian();
			System.out.println(median);
		}
		
	}
	
	private void addNumber(int value) {
		
		if(lowerBucket.size() == 0 || value < lowerBucket.peek()) {
			lowerBucket.add(value);
		} else {
			upperBucket.add(value);
		}
		
	}
	
	private void rebalanceBuckets() {
		
		PriorityQueue<Integer> bigHeap = lowerBucket.size() > upperBucket.size() ? lowerBucket : upperBucket;
		PriorityQueue<Integer> smallHeap = lowerBucket.size() > upperBucket.size() ? upperBucket : lowerBucket;
		
		if(bigHeap.size() - smallHeap.size() >= 2) {
			smallHeap.add(bigHeap.poll());
		}
		
	}
	
	public double getMedian() {
		
		PriorityQueue<Integer> bigHeap = lowerBucket.size() > upperBucket.size() ? lowerBucket : upperBucket;
		PriorityQueue<Integer> smallHeap = lowerBucket.size() > upperBucket.size() ? upperBucket : lowerBucket;
		
		if(bigHeap.size() == smallHeap.size()) {
			return (double)(bigHeap.peek() + smallHeap.peek())/2;
		} else {
			return bigHeap.peek();
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//int n = sc.nextInt();
		//int[] array = new int[n];
		int [] array = {12, 4, 5, 3, 8, 7};
		
		RunningMedian rm = new RunningMedian();
		
		/*
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		sc.close();*/
		
		rm.getRunningMedian(array);
	}

}
