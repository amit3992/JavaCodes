package leetCode.LinkedList.DoublyLinkedList;

public class DoubleNode {

    public int val;
    public DoubleNode prev;
    public DoubleNode next;
    public DoubleNode child;

    public DoubleNode() {}

    public DoubleNode(int _val, DoubleNode _prev, DoubleNode _next, DoubleNode _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}
