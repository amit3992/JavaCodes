package dataStructures.BST;

import java.util.*;
import java.io.*;

public class tree_orders {
	
	

    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
	
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			Stack<Integer> stack = new Stack<Integer>();
			int index = 0;
			
			while(true) {
				if(index != -1) {
					stack.push(index);
					index = left[index];
				}
				else if(!stack.isEmpty()) {
					index = stack.pop();
					result.add(key[index]);
					index = right[index];
				}
				else 
					break;
			}
			
						
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			Stack<Integer> stack = new Stack<Integer>();
			int index = 0;
			
			while(true) {
				if(index != -1) {
					result.add(key[index]);
					stack.push(index);
					index = left[index];
				}
				else if (!stack.isEmpty()) {
					index = stack.pop();
					index = right[index];
				}
				else 
					break;
			}
                        
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			int index = 0;
			Stack<Integer> stack1 = new Stack<Integer>();
			Stack<Integer> stack2 = new Stack<Integer>();
			stack1.push(0);
			
			while(!stack1.isEmpty()) {
				index = stack1.pop();
				stack2.push(key[index]);
				
				int left_index = left[index];
				int right_index = right[index];
				
				if(left_index != -1) {
					stack1.add(left_index);
				}
				
				if(right_index != -1) {
					stack1.add(right_index);
				}
			}
			
			while(!stack2.isEmpty()) {
				result.add(stack2.pop());
			}
			
                        
			return result;
		}
		
		// Util method to display Array
		public void displayArray(int[] array) {
			for(int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		}
		
		
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
