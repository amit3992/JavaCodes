package educative.arrays;
import java.util.*;

public class MaxSlidingWindow {
	
	public static void maxSlidingWindow(int[] array, int window_size) {
		
		if(array == null || array.length == 0 || window_size <= 0 || array.length < window_size) {
			System.out.println("Invalid input!");
			return;
		}
		
		ArrayDeque<Integer> window = new ArrayDeque<Integer>();
		
		 //find out max for the first window    
		   for(int i=0 ; i<window_size ; i++) {

		      while(!window.isEmpty() && array[i] >= array[window.peekLast()] ) {
		    	  window.removeLast();
		      }

		      window.addLast(i);
		   }

		   System.out.print(array[window.peekFirst()] + " ");

		   for(int i= window_size; i<array.length; i++) {

		      //remove all numbers that are smaller than current number 
		      //from the tail of queue
		      while(!window.isEmpty()
		          && array[i] >= array[window.peekLast()]) {
		        window.removeLast();
		      }

		      //remove first number if it doesn't fall in the window anymore
		      if(!window.isEmpty() 
		        && window.peekFirst() <= i - window_size) {
		        window.removeFirst();
		      }

		      window.addLast(i);

		      System.out.print(array[window.peekFirst()] + " ");
		   }
		
		
		
	}
	public static void main(String[] args) {
		
		int[] array = {-4, 2, -5, 3, 6};
		int winSize = 3;
		
		maxSlidingWindow(array, winSize);
		

	}

}
