package heap;
import java.util.*;

public class RunningMedian {
	
	// Have two heaps. minHeap and maxHeap
	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	
	public RunningMedian() {
		
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
	}
	
	public void getRunningMedian(int[] array) {
		for(int i = 0; i < array.length; i++) {
			addNumber(array[i]);
			System.out.println(getMedian());
		}	
	}
	
	public void addNumber(int value) {
		if(maxHeap.isEmpty()) {
			maxHeap.add(value);
		} else if(maxHeap.size() == minHeap.size()) {
			if(value < minHeap.peek()) {
				maxHeap.add(value);
			} else {
				minHeap.add(value);
				maxHeap.add(minHeap.remove());
			}
		} else if(maxHeap.size() > minHeap.size()) {
			if(value > maxHeap.peek()) {
				minHeap.add(value);
			} else {
				 maxHeap.add(value);
	             minHeap.add(maxHeap.remove());
			}
		}
	}
	
	public double getMedian() {
		if(maxHeap.isEmpty()) {
			return 0;
		} else if(maxHeap.size() == minHeap.size()) {
			int maxH = maxHeap.peek();
			int minH = minHeap.peek();
			
			return (maxH + minH)/2.0;
		} else {
			return maxHeap.peek();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] array = new int[n];
		
		RunningMedian rm = new RunningMedian();
		
		for(int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		sc.close();
		
		rm.getRunningMedian(array);
	}

}
