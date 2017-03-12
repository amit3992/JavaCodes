package dataStructures.UnrolledLL;
import java.util.*;

public class Node {
	
	Node next;
	int numElements;
	ArrayList<Integer> elements;
	char ID;
	
	Node() {
		this.numElements = 0;
		this.elements = new ArrayList<Integer>();
	}
	
	public void setNodeID (char id) {
		this.ID = id;
	}
	
	public char getNodeID () {
		return this.ID;
	}
	
	public int getNumElements() {
		return numElements;
	}
	
	public ArrayList<Integer> getElements() {
		return elements;
	}
	
	public void setElement(ArrayList<Integer> list) {
		this.elements = list;
	}
	
}
