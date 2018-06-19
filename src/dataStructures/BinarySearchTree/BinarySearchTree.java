package dataStructures.BinarySearchTree;

public class BinarySearchTree {

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public boolean add(int value) {

        if(root == null) {
            this.root = new Node(value);
            return true;
        }

        Node currentNode = root;

        while(currentNode != null) {

            Node leftChild = currentNode.leftChild;
            Node rightChild = currentNode.rightChild;

            if(currentNode.value > value) {

                if(leftChild == null) {
                    leftChild = new Node(value);
                    currentNode.leftChild = leftChild;
                    return true;
                }

                currentNode = leftChild;
            } else {
                if(rightChild == null) {
                    rightChild = new Node(value);
                    currentNode.rightChild = rightChild;
                    return true;
                }

                currentNode = rightChild;
            }
        }

        return false;

    }

    public Node search(int value) {

        if(this.root == null) {
            return this.root;
        }

        Node currentNode = this.root;

        while(currentNode != null) {

            if(currentNode.value == value) {
                return currentNode;
            } else if(currentNode.value > value) {
                currentNode = currentNode.leftChild;
            } else {
                currentNode = currentNode.rightChild;
            }
        }

        return null;
    }

    public boolean delete(int value, Node start) {

        Node current = start;
        Node parent = null;
        boolean isLeftChild = false;

        while(current != null) {

            /* Apply 3 condition when current node's value ==  node to be deleted */
            if(current.value == value) {

                Node left = current.leftChild;
                Node right = current.rightChild;

                /* Case 1: Current node is leaf node */
                if(left == null && right == null) {

                    if(isLeftChild) {
                        parent.leftChild = null;
                    } else {
                        parent.rightChild = null;
                    }

                    return true;

                }

                /* Case 2B] Node has 2 children */
                else if (left != null && right != null) {

                    /* Get left most node of right subtree */
                    Node leftMostNode = getLeftMostNode(right);

                    /* swap the values */
                    current.value = leftMostNode.value;

                    /* Delete the left most node */
                    delete(leftMostNode.value, right);

                    return true;
                }

                /* Case 2A - Node has 1 child */
                else {
                    if(left != null) {
                        if(isLeftChild) {
                            parent.leftChild = left;
                        } else {
                            parent.rightChild = left;
                        }
                    } else {
                        if(isLeftChild) {
                            parent.leftChild = right;
                        } else {
                            parent.rightChild = right;
                        }
                    }

                    return true;
                }
            }
            else if(current.value > value) {
                isLeftChild = true;
                parent = current;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                parent = current;
                current = current.rightChild;
            }


        }

        System.out.println(value + " does not exist in the tree!");
        return false;

    }


    private Node getLeftMostNode(Node node) {

        Node temp = node;

        while(temp.leftChild != null) {
            temp = temp.leftChild;
        }

        return temp;
    }
    public boolean isEmpty() {
        return this.root == null;
    }

    public void printPreOrder(Node current) {

        if(current == null) {
            return;
        }

        System.out.print(current.value + " , ");
        printPreOrder(current.leftChild);
        printPreOrder(current.rightChild);
    }

    public void printInOrder(Node current) {

        if(current == null) {
            return;
        }

        printInOrder(current.leftChild);
        System.out.print(current.value + " , ");
        printInOrder(current.rightChild);
    }
}
