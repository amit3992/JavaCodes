package dataStructures.SegmentTree;
import java.util.*;
import com.bit.NextPowerOf2;

public class SegmentTree {
	
	public int [] buildSegmentTree(int [] input) {

	    if(input == null || input.length == 0) {
	        return input;
        }

        NextPowerOf2 np = new NextPowerOf2();
	    int len = input.length;
	    int segTreeLen = np.nextPowerOf2(len) * 2 - 1;

	    int [] segmentTree = new int[segTreeLen];

	    /* Initialize segTree elements to MAX */
        for(int i = 0; i < segmentTree.length; i++) {
            segmentTree[i] = Integer.MAX_VALUE;
        }

        buildTreeUtil(input, segmentTree, 0, len - 1, 0);
        return segmentTree;

	}

	private void buildTreeUtil(int [] input, int [] segmentTree, int low, int high, int pos) {

	    if(low == high) {
	        segmentTree[pos] = input[low];
	        return;
        }

        int mid = (low + high) / 2;

	    int leftChild = 2*pos + 1;
	    int rightChild = 2*pos + 2;

	    buildTreeUtil(input, segmentTree, low, mid, leftChild);
	    buildTreeUtil(input, segmentTree, mid + 1, high, rightChild);

	    /* set parent node value */
	    segmentTree[pos] = Math.min(segmentTree[leftChild], segmentTree[rightChild]);
    }

    private int findMin(int [] segmentTree, int qLow, int qHigh, int low, int high, int pos) {

	    /* Total overlap condition */
        if(qLow <= low && qHigh >= high) {
            return segmentTree[pos];
        }

        /* No overlap condition */
        if(qLow > high || qHigh < low) {
            return Integer.MAX_VALUE;
        }

        /* Partial overlap condition */
        int mid = (low + high) / 2;

        int leftMin = findMin(segmentTree, qLow, qHigh, low, mid, 2*pos + 1);
        int rightMin = findMin(segmentTree, qLow, qHigh, mid + 1, high,2*pos + 2);

        return Math.min(leftMin, rightMin);
    }

    public int findMinInRange(int [] segmentTree, int qLow, int qHigh, int len) {
	    return findMin(segmentTree, qLow, qHigh, 0, len - 1, 0);
    }

}
