package BST;
import java.util.*;

public class ConstructBST {
	
	public static Node buildTree(int[] pre, int [] in) {
		return buildTreeHelper(0, 0, in.length - 1, pre, in);
	}

	private static Node buildTreeHelper(int preStart, int inStart, int inEnd, int[] pre, int[] in) {
		if(preStart > pre.length - 1 || inStart > in.length - 1) {
			return null;
		}
		
		Node root = new Node(pre[preStart]);
		int inIndex = 0;
		
		for(int i = inStart; i <= inEnd; i++) {
			if(in[i] ==  root.key) {
				inIndex = i;
			}
		}
		
		root.left = buildTreeHelper(preStart + 1, inStart, inIndex - 1, pre, in);
		root.right = buildTreeHelper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, pre, in);
		
		return root;
		
		
		
	}

	public static void main(String[] args) {
		
		int[] pre = {};
		int[] in = {};
		
	}

}
