package dataStructures.SegmentTree;

public class SegmentTree_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] array = {1, 3, 5, 7, 9};
		int n = array.length;
		
		SegmentTree st = new SegmentTree(array, n);
		
		System.out.println("The sum from range (0, 2) is -> " + st.getSum(n, 1, 3));

	}

}
