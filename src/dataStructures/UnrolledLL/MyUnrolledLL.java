package dataStructures.UnrolledLL;
import java.util.*;

public class MyUnrolledLL {
	
	Node head;
	private HashMap<Integer, Node> nodeMap;
	
	public MyUnrolledLL() {
		Node node = new Node();
		head = node;
		head.setNodeID('A');
		nodeMap = new HashMap<Integer, Node>();
		nodeMap.put(0, head);
	}
	
	public void createNewNodeAt(int nodePosition, char id) {
		Node newNode = new Node();
		newNode.setNodeID(id);
		if(nodeMap.containsKey(nodePosition)) {
			nodeMap.remove(nodePosition);
		}
		
		nodeMap.put(nodePosition, newNode);
	}
	
	public void addDataToNodePosition(int nodePosition, int data) {
		if(!nodeMap.containsKey(nodePosition)) {
			System.out.println("ERROR! Node does not exist");
		}
		else {
			Node newNode = nodeMap.get(nodePosition);
			
			ArrayList<Integer> list;
			list = nodeMap.get(nodePosition).getElements();
			list.add(data);
			nodeMap.get(nodePosition).setElement(list);
		}
	}
	
	public void printListAtNodePosition(int nodePosition) {
		if(!nodeMap.containsKey(nodePosition)) {
			System.out.println("ERROR! Node does not exist");
		}
		else {
			System.out.println("Node ID -> " + nodeMap.get(nodePosition).ID);
			ArrayList<Integer> list = nodeMap.get(nodePosition).getElements();
			for(Integer i: list) {
				System.out.print(i + " ");
			}
		}
	}
	
	private void printNodeData(Node node) {
		ArrayList<Integer> list = node.getElements();
		System.out.println("Node ID: " + node.getNodeID());
		for(int i: list) {
			System.out.print(i + " ");
		}
	}
	
	public void linkNodes(int nodePosition1, int nodePosition2) {
		
		Node node1 = null;
		Node node2 = null;
		if(nodeMap.containsKey(nodePosition1)) {
			node1 = nodeMap.get(nodePosition1);
		}
		else {
			System.out.println("NODE DOES NOT EXIST AT -> " + nodePosition1);
		}
		
		if(nodeMap.containsKey(nodePosition2)) {
			node2 = nodeMap.get(nodePosition2);
		}
		else {
			System.out.println("NODE DOES NOT EXIST AT -> " + nodePosition2);
		}
		
		node1.next = node2;
		
	}
	
	public void printAllListInOrder() {
		Node node = nodeMap.get(0);
		
		while(node != null) {
			
		}
	}
}
