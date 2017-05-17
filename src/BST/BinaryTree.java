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
	
	public int getLeavesCount(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		else
			return getLeavesCount(root.left) + getLeavesCount(root.right);
	}
	
	void printPaths(Node root) {
		int path[] = new int[1000];
		printPathsUtil(root, path,0);
	}
	
	private void printPathsUtil(Node root, int[] path, int pathLen) {
		// TODO Auto-generated method stub
		if(root == null)
			return;
		
		path[pathLen] = root.key;
		pathLen++;
		
		if(root.left == null && root.right == null) {
			printArray(path, pathLen);
		}
		else {
			printPathsUtil(root.left, path, pathLen);
			printPathsUtil(root.right, path, pathLen);
		}
		
	}
	
	 /* Utility function that prints out an array on a line. */
    void printArray(int ints[], int len) 
    {
        int i;
        for (i = 0; i < len; i++) 
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

	boolean checkBST(Node root) {
        
        return isBST(root, 100000, -100000);
         
    }

    public boolean isBST(Node root, int max, int min) {
        if(root == null) {
            return true;
        }
        
        if(root.key <= min || root.key >= max) {
            return false;
        }
        
        return isBST(root.left, root.key, min) && isBST(root.right, max, root.key);
    }
	
    public boolean BSTCheck(Node root)
    {
      if(root==null) return false;
      
     Stack<Node> stack=new Stack();
     Node lastvisited=null;
    
     while(!stack.isEmpty()||(root!=null))
    {
       if(root!=null)
    {
    	   stack.push(root);
    	   root=root.left;
    }
    else
    {
    	   lastvisited = stack.pop();
           if(lastvisited != null && root.key <= lastvisited.key) {
             return false;
           }
             else
        {
            lastvisited = root;
            root = root.right;
        }
    }
    }
    return true;
    }
    
    public void spiralWithTwoStack(Node root) {
    	if(root == null) {
    		return;
    	}
    	
    	Stack<Node> s1 = new Stack<Node>();
    	Stack<Node> s2 = new Stack<Node>();
    	
    	s1.push(root);
    	
    	while(!s1.isEmpty() || !s2.isEmpty()) {
    		while(!s1.isEmpty()) {
    			root = s1.pop();
    			System.out.print(root.key + " ");
    			
    			if(root.left != null) {
    				s2.push(root.left);
    			}
    			
    			if(root.right != null) {
    				s2.push(root.right);
    			}
    		}
    		
    		while(!s2.isEmpty()) {
    			root = s2.pop();
    			System.out.print(root.key + " ");
    			
    			if(root.right != null) {
    				s1.push(root.right);
    			}
    			if(root.left != null) {
    				s1.push(root.left);
    			}
    		}
    	}
    }
    
    public void spiralWithDeque(Node root) {
    	if(root == null) {
    		return;
    	}
    	
    	Deque<Node> deque = new LinkedList<Node>();
    	deque.offerFirst(root);
    	int count = 1;
    	boolean flip = true;
    	
    	while(!deque.isEmpty()) {
    		int currentCount = 0;
    		while(count > 0) {
    			if(flip) {
    				root = deque.pollFirst();
    				System.out.print(root.key + " ");
    				
    				if(root.left != null) {
    					deque.offerLast(root.left);
    					currentCount++;
    				}
    				
    				if(root.right != null) {
    					deque.offerLast(root.right);
    					currentCount++;
    				}
    			} else {
    				root = deque.pollLast();
    				System.out.print(root.key + " ");
    				
    				if(root.right != null) {
    					deque.offerFirst(root.right);
    					currentCount++;
    				}
    				
    				if(root.left != null) {
    					deque.offerFirst(root.left);
    					currentCount++;
    				}
    			}
    			count--;
    		}
    		
    		flip = !flip;
    		count = currentCount;
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
		
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		
		n1.left = n2;
		n1.right = n3;
		
		n1.left.left = n4;
		n1.left.right = n5;
		
		n1.right.left = n6;
		n1.right.right = n7;
		
		n1.left.left.left = n8;
		n1.left.left.right = n9;
		
		n1.left.right.left = n10;
		n1.left.right.right = n11;
		
		BinaryTree bt = new BinaryTree();
		
		System.out.println("POST");
		bt.iterativePostOrder(root);
		System.out.println();
		bt.recursivePostOrder(root);
		System.out.println("\nNode n1 - > ");
		bt.iterativePostOrder(n1);
		
		
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
		bt.levelOrderTraversal(n1);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("REVERSE LEVEL ORDER");
		bt.reverseLevelOrderTraversal(root);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("PRINT ALL PATHS");
		bt.printPaths(root);
		
		System.out.println();
		
		System.out.println("NUMBER OF LEAVES -> " + bt.getLeavesCount(root));
		System.out.println();
		
		
		System.out.println("SPIRAL LEVEL ORDER TRAVERSAL WITH 2 STACKS");
		bt.spiralWithTwoStack(n1);
		
		System.out.println();
		
		
		System.out.println("SPIRAL LEVEL ORDER TRAVERSAL WITH 1 DEQUE");
		bt.spiralWithDeque(n1);
		
		
		
		
	}

	

	

	

}
