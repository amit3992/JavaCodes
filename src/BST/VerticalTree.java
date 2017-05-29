package BST;
import java.util.*;

public class VerticalTree {
	
	int min;
	int max;
	
	private void traverseVertical(Node root) {
		
		if(root == null) {
			return;
		}
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int hd = 0;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		getVerticalOrder(root, hd, map);
		
		
		for(int i = min; i <= max; i++) {
			System.out.println(map.get(i).toString());
		}
		
	}

	private void getVerticalOrder(Node root, int hd, HashMap<Integer, ArrayList<Integer>> map) {
		
		if(root == null) {
			return;
		}
		
		min = Math.min(min, hd);
		max = Math.max(max, hd);
		
		if(!map.containsKey(hd)) {
			
			map.put(hd, new ArrayList<Integer>());
			ArrayList<Integer> mapList = map.get(hd);
			mapList.add(root.key);
			map.put(hd, mapList);
		}
		else {
			ArrayList<Integer> mapList = map.get(hd);
			mapList.add(root.key);
			map.put(hd, mapList);
		}
		
		//Store nodes of left subTree
		getVerticalOrder(root.left, hd-1, map);
		
		// Store nodes of right subTree
		getVerticalOrder(root.right, hd+1, map);
		
		
	}
	
	public int getDiameter(Node root) {
		
		return calcDiameter(root);
	}

	private int calcDiameter(Node root) {
		if(root == null) {
			return 0;
		}
		
		// Get height of left and right subtrees
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		
		// Get diameter of left and right subtrees
		int lDiameter = calcDiameter(root.left);
		int rDiameter = calcDiameter(root.right);
		
		return Math.max(lHeight + rHeight + 1, Math.max(lDiameter, rDiameter));
	}
	
	static int getHeight(Node root) {
		if(root == null) {
			return 0;
		}
		
		return (1 + Math.max(getHeight(root.left), getHeight(root.right)));
	}

	public static void main(String[] args) {
		
		VerticalTree vt = new VerticalTree();
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		
		System.out.println("VERTICAL TREE TRAVERSAL");
		vt.traverseVertical(root);
		
		
		/*VerticalTree tree = new VerticalTree();
		Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
        
        System.out.println("Diameter of tree 2 -> " + tree.getDiameter(root2));
        System.out.println("Diameter of tree 1 -> " + vt.getDiameter(root));*/
 
		

	}

	

}
