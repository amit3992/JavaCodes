package heap;

public class SortedHeap {
	
	private static void printSortedArray(int[] array, int start, int end) {
		
		if(start > end)
			return;
		
		// left child
		printSortedArray(array, 2*start + 1, end);
		
		// print root
		System.out.print(array[start] + " ");
		
		// right child
		printSortedArray(array, 2*start + 2, end);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {4,2,5,1,3};
		int sArray = array.length;
		printSortedArray(array, 0, sArray - 1);

	}

	

}
