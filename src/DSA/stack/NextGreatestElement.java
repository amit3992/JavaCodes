package DSA.stack;
import java.util.*;

public class NextGreatestElement {
	
	int [] array;
	Stack<Integer> st;
	
	NextGreatestElement(int[] array) {
		this.array = array;
		st = new Stack<Integer>();
		
		st.push(this.array[0]); // Push the first element in the stack
	}
	
	public void print(int a, int b) {
		System.out.println(a + " -- " + b);
	}
	
	public void getNGE() {
		
		for(int i = 1; i < this.array.length; i++) {
			
			int next = this.array[i];
			
			if(!st.isEmpty()) {
				int element = st.pop();
				
				while(element < next) {

					print(element, next);

					if (st.empty())
						break;

					element = st.pop();
				}

				if(element > next) {
					st.push(element);
				}
			}
			
			st.push(next);
		}
		
		while(!st.isEmpty()) {
			int element = st.pop();
			int next = -1;
			print(element, next);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] theArray = {4,5,2,25};
		NextGreatestElement nge = new NextGreatestElement(theArray);
		nge.getNGE();
		

	}

}
