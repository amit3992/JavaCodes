package myList;
import java.util.*;

class RandomListNode {
	int label;
	RandomListNode next, random;
	
	RandomListNode(int x) {
		label = x;
	}
}

public class CopyList {
	
public RandomListNode copyRandomList(RandomListNode head) {
        
        RandomListNode current = head;
        RandomListNode temp = head;
        // Insert indentical node after every node of original list
        while(current != null) {
            
            //Inserting a new node
            current.next = new RandomListNode(current.label);
            current.next.next = temp;
            temp = current;
        }
        
        current = head;
        
        while(current != null) {
            current.next.random = current.random.next;
            
            if(current == current.next) {
                current = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        
        RandomListNode original = head;
        RandomListNode copy = head.next;
        
        temp = copy;
        
        while(original != null && copy != null) {
            
           if(original.next == original.next) {
                original = original.next.next;
            }
            else {
                original = original.next;
            }
            
            if(copy == copy.next) {
                copy = copy.next.next;
            }
            else {
                copy = copy.next;
            }
            
            original = original.next;
            copy = copy.next;
        }
        
        return temp;
        
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
