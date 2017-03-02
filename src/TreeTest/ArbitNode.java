package TreeTest;
import java.util.*;



public class ArbitNode {

	//Variables
	public int key;
	//public List<ArbitNode> children;
	public HashMap<Integer, ArbitNode> children;
	
	public ArbitNode(int key) {
		this.key = key;
	}
	
	public HashMap<Integer, ArbitNode> getChildren() {
		
		if(this.children == null) {
			//return new ArrayList<ArbitNode>(10000);
			return new HashMap<Integer, ArbitNode>();
		}
		else
			return this.children;
	}
	
	public ArrayList<ArbitNode> getChildrenList() {
		
		if(this.children == null) {
			return new ArrayList<ArbitNode>(10000);
		}
		else {
			ArrayList<ArbitNode> childrenList = new ArrayList<ArbitNode>();
			int n = this.children.size();
			for(int i = 0; i < n; i++) {
				childrenList.add(this.children.get(i));
			}
			
			return childrenList;
		}
	}
	
	public int getNumberOfChildren() {
		if(this.children == null)
			return 0;
		else
			return this.children.size();
	}
	
	public void addChild(ArbitNode child) {
		
		if(this.children == null) {
			children = new HashMap<Integer, ArbitNode>();
		}
		//this.children.add(child);
		int point = this.children.size();
		this.children.put(point, child);
		System.out.println("Current children of Node -> " + this.key + " = " + this.getChildren());
	}
	
	public boolean isChildCreated(ArbitNode child) {
		System.out.println("Existing children of " + this.key + " -> " + getChildren());
		if(this.children != null && this.children.containsKey(child.key)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*
	public String NodeToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(this.key + "").append(",[");
        int i = 0;
        for (ArbitNode e : getChildren()) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(e.key).toString();
            i++;
        }
        sb.append("]").append("}");
        return sb.toString();
    }*/
	
	public String toString() {
		return "Node key value -> " + this.key;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean result = false;
		
		if (object == null || object.getClass() != getClass()) {
	        result = false;
	    } else {
	        ArbitNode node = (ArbitNode) object;
	        if (this.key == node.key) {
	            result = true;
	        }
	    }
		return result;
		
	}
	
}
