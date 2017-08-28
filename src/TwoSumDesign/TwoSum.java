package TwoSumDesign;
import java.util.*;

public class TwoSum {
	
	ArrayList<Integer> myList;
	HashSet<Integer> set;
	int len; // Length of my current list;
	
	/* Constructor */
	TwoSum() {
		myList = new ArrayList<Integer>();
	}
	
	/** Add the number to an internal data structure.. */
    public void add(int number) {
    	myList.add(number);
    	
    	this.len = myList.size();
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
    	set = new HashSet<Integer>();
    	
    	if(this.len == 1 && value == myList.get(0)) {
    		return false;
    	}
    	
    	for(int i = 0; i < this.len; i++) {
    		if(set.contains(value - myList.get(i))) {
    			return true;
    		}
    		set.add(myList.get(i));
    	}
    	
        return false;
    }
	

}
