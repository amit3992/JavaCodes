package dataStructures.BinarySearchTree;
import java.util.*;

public class BSTIterator {

    Stack<Node> stack;
    Node root;

    public BSTIterator(Node root) {
        stack = new Stack<Node>();
        this.root = root;

        while(root != null) {
            stack.push(root);
            root = root.leftChild;
        }

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public Node getNext() {

        if(stack.isEmpty()) {
            return null;
        }

        Node rVal = stack.pop();
        Node temp = rVal.rightChild;

        while(temp != null) {
            stack.push(temp);
            temp = temp.leftChild;
        }

        return rVal;
    }
}
