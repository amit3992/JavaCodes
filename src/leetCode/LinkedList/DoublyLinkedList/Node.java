/* Node class for single linked list */

package leetCode.LinkedList.DoublyLinkedList;

public class Node {

    int data;
    Node next;
    Node random;

    Node(int data) {
        this.data = data;
        next = null;
        random = null;
    }
}
