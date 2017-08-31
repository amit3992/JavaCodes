package hackerrank.DS.Array;
import java.util.*;

/* https://www.hackerrank.com/challenges/deque-stl */

public class DequeMax {
	
	public static void dequeMax(int nElements, int qSize) {
		if(nElements <= 0 || qSize <= 0) {
			return;
		}
		
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		
		while(nElements-- > 0) {
			
			int element = Integer.parseInt(sc.next());
			
			if(element > max) {
				max = element;
			}
			
			if(dq.size() < qSize) {
				dq.addLast(element);
			}
			
			if(dq.size() == qSize) {
				int data = dq.peekFirst();
				dq.removeFirst();
				dq.addLast(element);
				
				System.out.print(max + " ");
			}
			
		}
	}

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		while(n-- > 0) {
			int nElements = sc.nextInt();
			int qSize = sc.nextInt();
			
			dequeMax(nElements, qSize);
		}
	}

}
