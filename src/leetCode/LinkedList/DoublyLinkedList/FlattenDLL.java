package leetCode.LinkedList.DoublyLinkedList;
import java.util.*;

public class FlattenDLL {

    public DoubleNode flattenList(DoubleNode head) {

        if(head == null) {
            return head;
        }

        Stack<DoubleNode> stack = new Stack<DoubleNode>();

        /* Declare nodes */
        DoubleNode current = head;
        DoubleNode newHead = head;
        DoubleNode temp = head;

        System.out.println("DEBUG");

        while(current != null) {

            System.out.print(current.val + " \n");

            if(current.child != null) {
                System.out.println("Node -> " + current.val + " has a child node!");
                stack.push(current);
                current = current.child;
            } else {
                current = current.next;
            }

            /* Assign new list */
            temp.next = current;

            temp = temp.next == null ? temp : temp.next;
        }

       // System.out.println("Temp value outside of while loop -> " + temp.val);

        DoubleNode node = stack.pop();

        while(node != null) {
            temp.next = node;



        }

        return newHead;
    }

    public void printList(DoubleNode head) {

        if(head == null) {
            return;
        }

        while(head != null) {
            System.out.print(head.val + "-");
            head = head.next;
        }

    }

    public static void main(String [] args) {

        DoubleNode start = new DoubleNode(1, null, null, null);
        DoubleNode two = new DoubleNode(2, null, null, null);
        DoubleNode three = new DoubleNode(3, null, null, null);
        DoubleNode four = new DoubleNode(4, null, null, null);
        DoubleNode five = new DoubleNode(5, null, null, null);
        DoubleNode six = new DoubleNode(6, null, null, null);
        DoubleNode seven = new DoubleNode(7, null, null, null);
        DoubleNode eight = new DoubleNode(8, null, null, null);
        DoubleNode nine = new DoubleNode(9, null, null, null);
        DoubleNode ten = new DoubleNode(10, null, null, null);
        DoubleNode eleven = new DoubleNode(11, null, null, null);
        DoubleNode twel = new DoubleNode(12, null, null, null);

        /* Next pointers */
        start.next = two;
        two.prev = start;

        two.next = three;
        three.prev = two;

        three.next = four;
        four.prev = three;

        four.next = five;
        five.prev = four;

        five.next = six;
        six.prev = five;

        seven.next = eight;
        eight.prev = seven;

        eight.next = nine;
        nine.prev = eight;

        nine.next = ten;
        ten.prev = nine;

        eleven.next = twel;
        twel.prev = eleven;

        /* Child pointers */
        three.child = seven;
        eight.child = eleven;


        FlattenDLL fl = new FlattenDLL();

        DoubleNode result = fl.flattenList(start);
        fl.printList(result);


    }
}
