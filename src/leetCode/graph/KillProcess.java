package leetCode.graph;
import java.util.*;

public class KillProcess {
	
	public static ArrayList<Integer> killProcess(ArrayList<Integer> pid, ArrayList<Integer> ppid, int kill) {
	        
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        HashMap<Integer, LinkedList<Integer>> children = new HashMap<Integer, LinkedList<Integer>>();
	        
	        for(int i = 0; i < pid.size(); i++) {
	        	
	        	if(!children.containsKey(ppid.get(i))) {
	        		
	        		children.put(ppid.get(i), new LinkedList<Integer>());
	        		LinkedList<Integer> list = children.get(ppid.get(i));
	        		list.add(pid.get(i));
	        		
	        		children.put(ppid.get(i), list);
	        		
	        	} else {
	        		
	        		LinkedList<Integer> list = children.get(ppid.get(i));
	        		list.add(pid.get(i));
	        		
	        		children.put(ppid.get(i), list);
	        		
	        	}
	        }
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        q.add(kill);
	        
	        while(!q.isEmpty()) {
	        	int p = q.peek();
	        	q.remove();
	        	
	        	result.add(p);
	        	
	        	LinkedList<Integer> childrenList = children.get(p);
	        	
	        	if(childrenList != null) {
	        		
	        		for(int child: childrenList) {
		        		q.add(child);
		        	}
	        	}
	        	
	        }
	        
	        return result;
	        
	   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> pid = new ArrayList<Integer>();
		ArrayList<Integer> ppid = new ArrayList<Integer>();
		
		pid.add(1); pid.add(3); pid.add(10); pid.add(5);
		ppid.add(3); ppid.add(0); ppid.add(5); ppid.add(3);
		
		
		ArrayList<Integer> killed = killProcess(pid, ppid, 1);
		
		System.out.println("Processes killed: ");
		for(int kill: killed) {
			System.out.println(kill);
		}

	}

}
