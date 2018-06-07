/* Copy linkedlist with a random pointer */

package leetCode.LinkedList.DoublyLinkedList;

public class CopyLL {

    public void printNodeInfo(Node node) {

        while(node != null) {

            System.out.println("======================================");
            System.out.println("Node val: " + node.data);

            if(node.next != null) {
                System.out.println("Node next -> " + node.next.data);
            } else {
                System.out.println("Node next -> NULL");
            }

            if(node.random != null) {
                System.out.println("Node random -> " + node.random.data);
            } else {
                System.out.println("Node random -> NULL");
            }

            node = node.next;
        }
    }

    public static void main(String [] args) {

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        /* Next pointers */
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        /* Random pointers */
        first.random = second;
        second.random = fourth;
        third.random = first;
        fourth.random = null;
        fifth.random = second;

        CopyLL cl = new CopyLL();
        cl.printNodeInfo(first);


    }
}
