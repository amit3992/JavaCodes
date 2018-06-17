package dataStructures.SegmentTree;

public class SegmentTree_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        int [] input = {-1, 2, 4, 0};

        SegmentTree st = new SegmentTree();
        int [] segmentTree = st.buildSegmentTree(input);

        System.out.println("Min between 1 & 3 -> " + st.findMinInRange(segmentTree, 1, 3, input.length));

	}

}
