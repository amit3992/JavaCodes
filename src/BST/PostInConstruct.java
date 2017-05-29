package BST;

public class PostInConstruct {
	
	public Node buildTree(int[] in, int[] post) {
		
		int inStart = 0;
		int inEnd = in.length - 1;
		
		int postStart = 0;
		int postEnd = post.length - 1;
		
		return buildTreeUtil(in, inStart, inEnd, post, postStart, postEnd);
	}
	
	public Node buildTreeUtil(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
		
		if(inStart > inEnd || postStart > postEnd || in.length == 0 || post.length == 0) {
			return null;
		}
		
		int rootVal = post[postEnd];
		Node root = new Node(rootVal);
		
		int k = 0;
		for(int i = 0; i < in.length; i++) {
			if(in[i] == rootVal) {
				k = i;
				break;
			}
		}
		
		root.left = buildTreeUtil(in, inStart, k - 1, post, postStart, postStart + k - (inStart + 1));
		root.right = buildTreeUtil(in, k + 1, inEnd, post, postStart + k - inStart, postEnd - 1);
		
		return root;
		
	}

	public static void main(String[] args) {
		
		int[] in = {4, 2, 5, 1, 6, 7, 3, 8};
		int[] post = {4, 5, 2, 6, 7, 8, 3, 1};
		
		BinaryTree bt = new BinaryTree();
		PostInConstruct pic = new PostInConstruct();
		Node treeNode = pic.buildTree(in, post);
		System.out.println("In - order traversal of tree -> ");
		bt.recursiveInOrder(treeNode);

	}

}
