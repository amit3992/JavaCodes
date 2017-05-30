package BST;

class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	BinaryTreeNode next;
}

public class SiblingPointers {
	
	private static BinaryTreeNode connect_next_level(BinaryTreeNode head) {		  	 
		
		BinaryTreeNode current = head;
	    BinaryTreeNode next_level_head = null;
	    BinaryTreeNode prev = null;

	  while (current != null) {
		  
		if(current.left != null && current.right != null) {
			
			if(next_level_head == null){
				next_level_head = current.left;
			}
			
			current.left.next = current.right;
			
			if(prev != null){
				prev.next = current.left;
			}
			
			prev = current.right;
		} else if(current.left != null){
			
			if(next_level_head == null){
				next_level_head = current.left;
			}
			
			if(prev != null){
				prev.next = current.left;
			}
			
			prev = current.left;
		}
		else if(current.right != null){
			if(next_level_head == null){
				next_level_head = current.right;
			}
			
			if(prev != null){
				prev.next = current.right;
			}
			
			prev = current.right;
		}

	    current = current.next;
	  }
	  
	  if(prev != null){
		prev.next = null;  
	  }
	  
	  return next_level_head;
	}

	public static void populate_sibling_pointers(BinaryTreeNode root) {

	  if (root == null) {
	    return;
	  }

	  root.next = null;
	  
	  do {

	    root = connect_next_level(root);
	  }while (root != null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
