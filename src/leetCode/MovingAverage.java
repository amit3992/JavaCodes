package leetCode;
import java.util.*;

public class MovingAverage {
	
	ArrayDeque<Integer> queue;
	int qSize;
	int sum;
	
	/** Initialize your data structure here. */
    public MovingAverage(int size) {
    	qSize = size;
    	queue = new ArrayDeque<Integer>();
    	sum = 0;
    }
    
    public double next(int val) {
   	    	
    	if(queue.size() < qSize) {
    		queue.addLast(val);
    		sum = sum + val;
    		
    		return (double)sum/queue.size();
    		
    	} else {
    		
    		int poppedVal = queue.removeFirst();
    		sum = sum - poppedVal;
    		
    		queue.addLast(val);
    		sum = sum + val;
    	
    		return (double)sum/queue.size();
    	}
        
    }

	public static void main(String[] args) {
		
		MovingAverage mv = new MovingAverage(3);
		System.out.println("1 -> " + mv.next(1));
		System.out.println("2 -> " + mv.next(10));
		System.out.println("3 -> " + mv.next(3));
		System.out.println("4 -> " + mv.next(5));
		System.out.println("5 -> " + mv.next(7));
		System.out.println("6 -> " + mv.next(4));

	}

}
