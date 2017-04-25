// Java implementation of priority queue
package heap;
import java.util.*;

public class JavaPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<String> pQueue = new PriorityQueue<String>();
		
		pQueue.add("Amit");
		pQueue.add("C++");
		pQueue.add("Amazon");
		pQueue.add("Bloomberg");
		pQueue.add("Coupang");
		pQueue.add("Java");
		
		// Printing the most priority element
        System.out.println("Head value using peek function: " + pQueue.peek());
        
        System.out.println("Elements in queue -> ");
        Iterator it = pQueue.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next());
        	
        }
        
        // Removing the top priority element (or head) and
        // printing the modified pQueue
        pQueue.poll();
        System.out.println("After removing an element" +
                           "with poll function:");
        Iterator<String> itr2 = pQueue.iterator();
        while (itr2.hasNext())
            System.out.println(itr2.next());
 
        // Removing Java
        pQueue.remove("Java");
        System.out.println("after removing Java with" +
                           " remove function:");
        Iterator<String> itr3 = pQueue.iterator();
        while (itr3.hasNext())
            System.out.println(itr3.next());
 
        // Check if an element is present
        boolean b = pQueue.contains("C");
        System.out.println ( "Priority queue contains C" +
                             "ot not?: " + b);
 
        // get objects from the queue in an array and
        // print the array
        Object[] arr = pQueue.toArray();
        System.out.println ( "Value in array: ");
        for (int i = 0; i<arr.length; i++)
          System.out.println ( "Value: " + arr[i].toString()) ;

	}

}
