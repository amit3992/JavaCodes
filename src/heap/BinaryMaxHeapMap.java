package heap;
import java.util.*;

public class BinaryMaxHeapMap {

    private List<String> allNodes = new ArrayList<String>();
    private HashMap<String, Node> map = new HashMap<String, Node>();

    class Node {
        int weight;
        String data;
    }

    public void add(int weight,String data) {
    	
    	Node node = null;
    	
    	if(!map.containsKey(data)) {
    		node = new Node();
            node.weight = weight;
            node.data = data;
            
            map.put(data, node);
    	}
    	else {
    		node = map.get(data);
    		node.weight += weight;
    		
    		map.put(data, node);
    	}
    	
        if(!allNodes.contains(data)) {
        	allNodes.add(data);
        }
        
        int size = allNodes.size();
        int current = allNodes.indexOf(data);
        int parentIndex = (current - 1) / 2;

        while (parentIndex >= 0) {
            
        	String parentString = allNodes.get(parentIndex);
            String currentString = allNodes.get(current);
            
            Node parentNode = map.get(parentString);
            Node currentNode = map.get(currentString);
            
            if (parentNode.weight < currentNode.weight) {
                swapNodes(parentIndex,current);
                
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }

    }
    
    private void swapNodes(int a, int b) {
    	
    	Collections.swap(allNodes, a, b);
    }

    @Deprecated
    private void swap(Node node1,Node node2){
        
    	int weight = node1.weight;
        String data = node1.data;
        
        node1.data = node2.data;
        node1.weight = node2.weight;
        
        node2.data = data;
        node2.weight = weight;
    }
    
    public String max(){
        return allNodes.get(0);
    }
    
    public boolean empty(){
        return allNodes.size() == 0;
    }
    
    
    
    private Node extractMax(){
    	
        int size = allNodes.size() -1;
        String max = allNodes.get(0);
        
        Collections.swap(allNodes, 0, size);
        allNodes.remove(size);
        
        int currentIndex = 0;
        size--;
        
        while(true){
            
        	int left = 2*currentIndex + 1;
            int right = 2*currentIndex + 2;
            
            if(left > size){
                break;
            }
            if(right > size){
                right = left;
            }
            
            Node leftNode = map.get(allNodes.get(left));
            Node rightNode = map.get(allNodes.get(right));
            
            int largerIndex = leftNode.weight >= rightNode.weight ? left : right;
            
            Node currentNode = map.get(allNodes.get(currentIndex));
            Node largeNode = map.get(allNodes.get(largerIndex));
            
            if(currentNode.weight < largeNode.weight){
                swapNodes(currentIndex, largerIndex);
                currentIndex = largerIndex;
            }else{
                break;
            }
        }
        
        return map.get(max);
    }
    
    public void getMax() {
    	Node node = extractMax();
    	System.out.println(node.data + " -> " + node.weight);
    }
    
    
    public void printHeap(){
        for(String n : allNodes){
        	Node node = map.get(n);
            System.out.println(node.data + " -> " + node.weight);
        }
        System.out.println("=========================");
    }
    
    public void printTop(int n) {
    	if (n > allNodes.size()) {
    		System.out.println("ERRRR");
    		return;
    	}
    	
    	while(n-- > 0) {
    		getMax();
    	}
    }
    
    public static void main(String args[]){
        
    	BinaryMaxHeapMap heap = new BinaryMaxHeapMap();
        
        heap.add(50, "Google");
        heap.add(150, "Apple");
        heap.add(75, "Microsoft");
        heap.add(100, "Google");        
        heap.add(150, "Google");
        heap.add(50, "Apple");        
        heap.add(200, "Facebook");
        heap.add(200, "Microsoft");
        
        System.out.println("=========================");
        
        heap.printHeap();    
        
        
        heap.add(50, "Google");
        heap.add(100, "Microsoft");
        heap.add(-50, "Facebook");
        heap.printHeap();    
        
        heap.printTop(4);
        
        
       
        

        
        
    }
}