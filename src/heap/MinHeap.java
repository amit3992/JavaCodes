package heap;
import java.util.*;

public class MinHeap {
	
	int hCapacity; // Capacity of heap
	int hSize; // Current size of heap
	ArrayList<Integer> mHeap;
	
	MinHeap(int [] array) {
		mHeap = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++) {
			mHeap.add(array[i]);
		}
		
		buildHeap();
	}
	
	private void buildHeap() {
		for(int i = mHeap.size()/2; i >= 0; i--) {
			minHeapify(i);
		}
	}
	
	public int extractMin() {
		if(mHeap.size() == 0) {
			System.out.println("HEAP IS EMPTY!");
			return Integer.MAX_VALUE;
		}
		if(mHeap.size() == 1) {
			int min = mHeap.get(0);
			return min;
		}
		
		int root = mHeap.get(0);
		int lastItem = mHeap.get(mHeap.size() - 1);
		
		mHeap.set(0, lastItem);
		
		minHeapify(0);
		
		return root;
		
	}
	
	private void minHeapify(int i) {
		
		int l = getLeftChild(i);
		int r = getRightChild(i);
		
		int smallest = i;
		
		if(l < mHeap.size() && mHeap.get(l) < mHeap.get(i)) {
			smallest = l;
		}
		if(r < mHeap.size() && mHeap.get(r) < mHeap.get(smallest)) {
			smallest = r;
		}
		
		if(smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}
	}
	
	
	private void swap(int a, int b) {
		int temp  = mHeap.get(b);
		mHeap.set(b, mHeap.get(a));
		mHeap.set(a, temp);
	}
	
	public void showHeap() {
		for(int i = 0; i < this.mHeap.size(); i++) {
			System.out.print(mHeap.get(i) + " ");
		}
		System.out.println();
	}
	
	private int getParent(int i) {
		return (i-1)/2;
	}
	
	private int getLeftChild(int i) {
		return 2*i + 1;
	}
	
	private int getRightChild(int i) {
		return 2*i + 2;
	}
	
	
	

}
