package heap;

public class HeapDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {5, 7, 10, 3, 6, 4, 1, 2, 9, 8};
		MinHeap mh = new MinHeap(array);
		mh.showHeap();
		
		mh.extractMin();
		
		mh.showHeap();

	}

}
