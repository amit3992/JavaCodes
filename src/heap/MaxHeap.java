package heap;

import java.util.*;

public class MaxHeap {
	
	int hCapacity; // Capacity of heap
	int hSize; // Current size of heap
	ArrayList<Integer> mHeap;
	
	MaxHeap(int [] array) {
		mHeap = new ArrayList<Integer>();
		
		for(int i = 0; i < array.length; i++) {
			mHeap.add(array[i]);
		}
		
		buildHeap();
	}
	
	private void buildHeap() {
		for(int i = mHeap.size()/2; i >= 0; i--) {
			maxHeapify(i);
		}
	}
	
	public int extractMax() {
		
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
		mHeap.remove(mHeap.size() - 1);
		
		mHeap.set(0, lastItem);
		
		maxHeapify(0);
		
		return root;
		
	}
	
	private void maxHeapify(int i) {
		
		int l = getLeftChild(i);
		int r = getRightChild(i);
		
		int largest = i;
		
		if(l < mHeap.size() && mHeap.get(l) > mHeap.get(i)) {
			largest = l;
		}
		if(r < mHeap.size() && mHeap.get(r) > mHeap.get(largest)) {
			largest = r;
		}
		
		if(largest != i) {
			swap(i, largest);
			maxHeapify(largest);
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
