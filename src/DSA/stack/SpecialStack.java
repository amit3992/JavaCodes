package DSA.stack;
import java.util.*;

/*
 * All purpose stack which supports min, max, avg and mode operations in-addition to push and pop
 * 
 * */

public class SpecialStack {
	
	Stack<Integer> stack;
	int min;
	int max;
	int sum;
	double avg;
	Map<Integer, Integer> modeMap;
	Stack<Integer> minStack;
	Stack<Integer> maxStack;
	
	SpecialStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
		modeMap = new HashMap<>();
		avg = 0;
	}
	
	

	public int getMin() {
		return min;
	}


	public int getMax() {
		return max;
	}

	public double getAvg() {
		return avg;
	}
	
}
