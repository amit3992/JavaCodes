package LinkedList;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {

    public static void main(String[] args) {
        Deque<Object> deque = new LinkedList<>();
        
        // We can add elements to the queue in various ways
        deque.add(1); // add to tail
        deque.addFirst(2);
        deque.addLast(3);
        deque.push(4); //add to head
        deque.offer(5);
        deque.offerFirst(6);
        deque.offerLast(7);
        
        System.out.println(deque + "\n");

        // Iterate through the queue elements.
        System.out.println("Standard Iterator");
        Iterator<Object> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
        
        // Reverse order iterator
        Iterator reverse = deque.descendingIterator();
        System.out.println("Reverse Iterator");
        while (reverse.hasNext()) {
            System.out.println("\t" + reverse.next());
        }
        
        // Peek returns the head, without deleting it from the deque
        System.out.println("Peek " + deque.peek());
        System.out.println("After peek: " + deque);
        
        // Pop returns the head, and removes it from the deque
        System.out.println("Pop " + deque.pop());
        System.out.println("After pop: " + deque);
        
        // We can check if a specific element exists in the deque
        System.out.println("Contains element 3: " + deque.contains(3));
        
        // We can remove the first / last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing first and last: " + deque);   
    }
}