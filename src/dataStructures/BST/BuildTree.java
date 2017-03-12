/*
 * Build tree from in-order and pre-order
 */
package dataStructures.BST;

class Node {
	char data;
	Node left, right;
	
	Node(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BuildTree {
	
	Node root;
	static int preIndex = 0;
	
	Node buildTree(char[] in, char[] pre, int inStart, int inEnd) {
		
		 if (inStart > inEnd) 
	            return null;
	  
	        /* Pick current node from Preorder traversal using preIndex
	           and increment preIndex */
	        Node tNode = new Node(pre[preIndex++]);
	  
	        /* If this node has no children then return */
	        if (inStart == inEnd)
	            return tNode;
	  
	        /* Else find the index of this node in Inorder traversal */
	        int inIndex = search(in, inStart, inEnd, tNode.data);
	  
	        /* Using index in Inorder traversal, construct left and
	           right subtress */
	        tNode.left = buildTree(in, pre, inStart, inIndex - 1);
	        tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
	  
	        return tNode;
	}
	
	
	 /* UTILITY FUNCTIONS */
    
    /* Function to find index of value in arr[start...end]
     The function assumes that value is present in in[] */
    int search(char arr[], int strt, int end, char value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }
  
    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node) 
    {
        if (node == null)
            return;
  
        /* first recur on left child */
        printInorder(node.left);
  
        /* then print the data of node */
        System.out.print(node.data + " ");
  
        /* now recur on right child */
        printInorder(node.right);
    }
    
 // driver program to test above functions
    public static void main(String args[]) 
    {
        BuildTree tree = new BuildTree();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);
  
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
	
	
	
	
	

}
