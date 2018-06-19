package dataStructures.BinarySearchTree;


public class BST_Test {

    public static void main(String [] args) {

        BinarySearchTree bsT = new BinarySearchTree();

        System.out.println("*******************************************");
        System.out.println("Testing add method");
        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println("=================== pre-order ==================  ");
        bsT.printPreOrder(bsT.getRoot());

        System.out.println();
        System.out.println("=================== In-order ==================  ");
        bsT.printInOrder(bsT.getRoot());

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Testing search method");

        Node n = bsT.search(12);
        if(n != null && n.value == 12) {
            System.out.println("Node with value: " + 12 + " found!");
        } else {
            System.out.println("Node with value: " + 12 + " not found!");
        }


        n = bsT.search(3);
        if(n != null && n.value == 3) {
            System.out.println("Node with value: " + 3 + " found!");
        } else {
            System.out.println("Node with value: " + 3 + " not found!");
        }

        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Testing delete method");
        if(bsT.delete(10, bsT.getRoot())) {
            System.out.println("Node with value 10 deleted!");
            bsT.printInOrder(bsT.getRoot());
        }

        if(bsT.delete(7, bsT.getRoot())) {
            System.out.println("Node with value 7 deleted!");
            bsT.printInOrder(bsT.getRoot());
        }


        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Testing Iterator method");
        BSTIterator it = new BSTIterator(bsT.getRoot());

        while(it.hasNext()) {
            Node temp = it.getNext();

            if(temp != null)
                System.out.print(temp.value);

            System.out.print(" -> ");
        }

    }
}
