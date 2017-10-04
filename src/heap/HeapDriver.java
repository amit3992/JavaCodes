package heap;

public class HeapDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {5, 7, 10, 3, 6, 4, 1, 2, 9, 8};
		MinHeap minh = new MinHeap(array);
		MaxHeap maxh = new MaxHeap(array);
		
		System.out.println("Min heap");
		minh.showHeap();
		System.out.println("=============================");
		System.out.println("Max heap");
		maxh.showHeap();
		
		System.out.println();
		for(int i = 0; i < 9; i++) {
			//System.out.println("Min element: " + minh.extractMin());
			System.out.println("Max element: " + maxh.extractMax());
			System.out.println("--------");
		}
			

	}

}
