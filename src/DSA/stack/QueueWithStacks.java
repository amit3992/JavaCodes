// Implementing a queue using 2 stacks
package DSA.stack;

import java.util.Stack;

public class QueueWithStacks<E> {
	
	private Stack<E> inbox = new Stack<E>();
	private Stack<E> outbox = new Stack<E>();
	
	public void enqueue(E item) {
		inbox.push(item);
		System.out.println("Successfully queued: " + item);
	}
	
	public E dequeue() {
		
		while(!inbox.empty()) {
			E val = inbox.pop();
			outbox.push(val);
			System.out.println("Added in outbox: " + val );
		}
		return outbox.pop();
		
	}
	
	public static void main(String args[]) {
		
		QueueWithStacks<String> Q = new QueueWithStacks<String>();
		
		Q.enqueue("Amit");
		Q.enqueue("Boss");
		Q.enqueue("Jack");
		Q.enqueue("Ashton");
		Q.enqueue("Brook");
		
		System.out.println(Q.dequeue());
	}
}
