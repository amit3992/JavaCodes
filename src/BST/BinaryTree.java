// Implementation of a binary tree
package BST;

public class BinaryTree {
	
	Node root; // Every single tree will have a root value
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		
		if(root == null) {
			root = newNode;
		}
		else {
			Node focusNode = root; // start with root as we traverse through our tree;
			
			Node parent;
			
			while(true) {
				parent = focusNode;
				
				if(key < focusNode.key) {
					
					// Put a node to the left
					focusNode = focusNode.leftChild;
					
					if( focusNode == null) {
						
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					
					// Put a node to the right
					focusNode = focusNode.rightChild;
					
					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	
	/*
	 *  Node of traversal
	 *  1] In-order
	 */
	
	// Left -> Parent -> Right
	public void inOrderTraverseTree(Node focusNode) {
		
		if(focusNode != null) {
			
			// Left
			inOrderTraverseTree(focusNode.leftChild);
			
			// Parent
			//System.out.println(focusNode);
			
			// Right
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	// 2] PreOrderTraversal (Parent -> Left -> Right) 
	public void preOrderTraverseTree(Node focusNode) {
		
		if(focusNode != null) {
			
			// Parent
			System.out.println(focusNode);
			
			// Left
			preOrderTraverseTree(focusNode.leftChild);
			
			// Right
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
		// 2] PostOrderTraversal (Left -> Right -> Parent)
		public void postOrderTraverseTree(Node focusNode) {
			
			if(focusNode != null) {
				
				// Left
				postOrderTraverseTree(focusNode.leftChild);
				
				// Right
				postOrderTraverseTree(focusNode.rightChild);
				
				// Parent
				System.out.println(focusNode);
			}
		}
		
		public int getHeightOfTree(Node focus) {
			
			if(focus == null)
				return 0;
			else {
				int val = Math.max(getHeightOfTree(focus.leftChild), getHeightOfTree(focus.rightChild));
				return val + 1;
			}
		}
		
		
		// DELETING A NODE
		public boolean remove(int key) {
			Node focusNode = root;
			Node parent = root;
			
			boolean isItALeftChild = true;
			
			while(focusNode.key != key) {
				
				parent = focusNode;
				
				if(key < focusNode.key) {
					isItALeftChild = true;
					focusNode = focusNode.leftChild;
				}
				else {
					isItALeftChild = false;
					focusNode = focusNode.rightChild;
				}
				
				if(focusNode == null)	// Didn't find key in the tree
					return false;
				
				if(focusNode.leftChild == null && focusNode.rightChild == null) {
					
					if(focusNode == root) {
						root = null;
					} else if(isItALeftChild) {
						parent.leftChild = null;
					}
					else {
						parent.rightChild = null;
					}
				}
				else if(focusNode.rightChild == null) {
					
					if(focusNode == root) {
						root = focusNode.leftChild;
					}
					else if (isItALeftChild)
						parent.leftChild = focusNode.leftChild;
					else {
						parent.rightChild = focusNode.rightChild;
					}
				}
				else if (focusNode.leftChild == null) {
					if(focusNode == root) {
						root = focusNode.rightChild;
					}
					else if (isItALeftChild) {
						parent.leftChild = focusNode.rightChild;
					}
					else {
						parent.rightChild = focusNode.leftChild;
					}
				}
				else {
					Node replacement = getReplacementNode(focusNode);
					
					if(focusNode == root) 
						root = replacement;
					else if (isItALeftChild) 
						parent.leftChild = replacement;
					else
						parent.rightChild = replacement;
					
					replacement.leftChild = focusNode.leftChild;
				}
				
			}
			
			return true;
		}
		
		
		// Get replacement node
		
		public Node getReplacementNode(Node replaceNode) {
			// TODO Auto-generated method stub
			Node replacementParent = replaceNode;
			Node replacement = replaceNode;
			
			Node focusNode = replaceNode.rightChild;
			
			while(focusNode != null) {
				replacementParent = replacement;
				replacement = focusNode;
				focusNode = focusNode.leftChild;
			}
			return null;
		}


		public Node findNode(int key) {
			
			Node focusNode = root;
			
			while(focusNode.key !=  key) {
				
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
				}
				else {
					focusNode = focusNode.rightChild;
				}
				
				if( focusNode == null) {
					return null; //Key not found
				}
			}
			
			return focusNode;
		}
		
	// Node class
	public class Node {
		
		int key;
		String name;
		
		Node leftChild;
		Node rightChild;
		
		Node(int key, String name) {
			this.key = key;
			this.name = name;
		}
		
		public String toString() {
			return name + " has a key " + key;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree theTree = new BinaryTree();
		
		theTree.addNode(50, "Boss");
		theTree.addNode(25, "Veep");
		theTree.addNode(15, "Office Manager");
		theTree.addNode(30, "Secretary");
		theTree.addNode(75, "Sales Manager");
		theTree.addNode(80, "Senior Veep");
		theTree.addNode(85, "President");
		
		System.out.println(theTree.findNode(30));
		System.out.println("Height of this tree is: "+ theTree.getHeightOfTree(theTree.root));
		
		//theTree.inOrderTraverseTree(theTree.root); // Start from the root
		//theTree.preOrderTraverseTree(theTree.root); // Start from the root
		//theTree.postOrderTraverseTree(theTree.root);
		
	}

}
