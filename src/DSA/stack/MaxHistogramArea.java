package DSA.stack;
import java.util.*;

public class MaxHistogramArea {
	
	public int calculateMaxArea(int nums[]) {
		Deque<Integer> stack = new LinkedList<Integer>();
		
		int maxArea = 0;
		int area = -1;
		int i;
		
		for(i = 0; i < nums.length; ) {
			
			if(stack.isEmpty() || nums[stack.peekFirst()] <= nums[i]) {
				stack.offerFirst(i++);
			} else {
				
				int top = stack.pollFirst();
				
				if(stack.isEmpty()) {
					area = nums[top] * i;
				} else {
					area = nums[top] * (i - stack.peekFirst() - 1);
				}
				
				if(area > maxArea) {
					maxArea = area;
				}
			}
		}
			while(!stack.isEmpty()) {
				int top = stack.pollFirst();
				if(stack.isEmpty()) {
					area = nums[top] * i;
				} else {
					area = nums[top] * (i - stack.peekFirst() - 1);
				}
				
				if(area > maxArea) {
					maxArea = area;
				}
			}
		
		return maxArea;
	}

	public static void main(String[] args) {
		MaxHistogramArea mha = new MaxHistogramArea();
		int input[] = {2, 1, 2, 3, 1};
		int maxArea = mha.calculateMaxArea(input);
		System.out.println("Max area: " + maxArea);

	}

}
