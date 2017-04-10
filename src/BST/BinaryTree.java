// Implementati
package BST;
import java.util.*;

public class BinaryTree {
	
	public void recursiveInOrder(Node root) {

		if(root == null) {
			return;
		}
		
		recursiveInOrder(root.left);
		System.out.print(root.key + " ");
		recursiveInOrder(root.right);
		
	}
	
	public void recursivePostOrder(Node root) {
		if(root == null) {
			return;
		}
		
		recursivePostOrder(root.left);
		recursivePostOrder(root.right);
		System.out.print(root.key + " ");
	}
	
	public void recursivePreOrder(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.key + " ");
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
	}
	
	private void iterativeInOrder(Node root) {
		// TODO Auto-generated method stub
		
		Stack<Node> st = new Stack<Node>();
		Node node = root;
		
		while(true) {
			if(node != null) {
				st.push(node);
				node = node.left;
			}
			else {
				if(st.isEmpty()) {
					break;
				}
				node = st.pop();
				System.out.print(node.key + " ");
				node = node.right;
			}
		}
		
	}
	
	public void iterativePostOrder(Node root) {
		
		    Stack<Node> stack1 = new Stack<Node>();
		    Stack<Node> stack2 = new Stack<Node>();
		    
		    stack1.push(root);
		    
		    while(!stack1.isEmpty()) {
		        root = stack1.pop();
		        if(root.left != null) {
		            stack1.push(root.left);
		        }
		        if(root.right != null) {
		            stack1.push(root.right);
		        }
		        
		        stack2.push(root);
		    }
		    
		    while(!stack2.isEmpty()) {
		        Node node = stack2.pop();
		        System.out.print(node.key + " ");
		    }
	}
	
	public void iterativePreOrder(Node root) {
		Stack<Node> st = new Stack<Node>();
		
		st.push(root);
		while(!st.isEmpty()) {
			root = st.pop();
			System.out.print(root.key + " ");
			
			if(root.right != null) {
				st.push(root.right);
			}
			
			if(root.left != null) {
				st.push(root.left);
			}
		}
	}
	
	public void levelOrderTraversal(Node root) {
		
		if(root == null)
	          return;
	       
	       Queue<Node> q = new LinkedList();
	       ArrayList<Integer> nodeList = new ArrayList<Integer>();
	       
	       q.add(root);
	       nodeList.add(root.key);
	       
	        int ht = 0;
	       
	       while(true) {
	           int nodeCount = q.size();
	           
	           if(nodeCount == 0) {
	               
	               for(int node: nodeList) {
	                   System.out.print(node +" ");
	               }
	               return;
	           }
	           
	           ht++;
	           
	           while(nodeCount > 0) {
	               
	               Node newNode = q.peek();
	               q.remove();
	               
	               if(newNode.left != null) {
	                  nodeList.add(newNode.left.key);
	                  q.add(newNode.left);
	               }
	                   
	               if(newNode.right != null) {
	                  nodeList.add(newNode.right.key);
	                  q.add(newNode.right);
	               }
	                   
	               
	               nodeCount--;
	                   
	           }
	       }
	}
	
	private void reverseLevelOrderTraversal(Node root) {
		

		if(root == null)
	          return;
	       
	       Queue<Node> q = new LinkedList();
	       Stack<Node> st = new Stack<Node>();
	       
	       q.add(root);
	       
	        int ht = 0;
	       
	       while(true) {
	           int nodeCount = q.size();
	           
	           if(nodeCount == 0) {
	               
	        	   while(!st.isEmpty()) {
	        		   Node n = st.pop();
	        		   System.out.print(n.key + " ");
	        	   }
	               
	               return;
	           }
	           
	           ht++;
	           
	           while(nodeCount > 0) {
	               
	               Node newNode = q.peek();
	               q.remove();
	               
	               if(newNode.right != null) {
	                  q.add(newNode.right);
	               }
	                   
	               if(newNode.left != null) {
	                  q.add(newNode.left);
	               }
	                   
	               st.push(newNode);
	               nodeCount--;
	                   
	           }
	       }
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(3);
		Node node1 = new Node(5);
		Node node2 = new Node(2);
		Node node3 = new Node(1);
		Node node4 = new Node(4);
		Node node5 = new Node(6);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		
		BinaryTree bt = new BinaryTree();
		
		System.out.println("POST");
		bt.iterativePostOrder(root);
		System.out.println();
		bt.recursivePostOrder(root);
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("PRE");
		bt.iterativePreOrder(root);
		System.out.println();
		bt.recursivePreOrder(root);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("IN-ORDER");
		bt.iterativeInOrder(root);
		System.out.println();
		bt.recursiveInOrder(root);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("LEVEL ORDER");
		bt.levelOrderTraversal(root);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("REVERSE LEVEL ORDER");
		bt.reverseLevelOrderTraversal(root);
		
		
		
	}

	

	

	

}
