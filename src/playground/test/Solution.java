package playground.test;
import java.util.*;

public class Solution {
	
		private int getLeftIndex(final List<Integer> a, int b) {
		    
		    if(a == null || a.size() == 0) {
		        return -1;
		    }
		    
		    int size = a.size();
		    int low = 0;
		    int high = size;
		    int result = -1;
		    
		    
		  
		    while(low <= high) {
		    	int mid = low + (high - low)/2;
		        int mid_element = a.get(mid);
		        
		        if(mid_element == b) {
		            result = mid;
		            high = mid - 1;
		        } else if(mid_element < b) {
		            low = mid + 1;
		        } else {
		            high = mid - 1;
		        }
		        
		    }
		    
		    return result;
		}
		
		
		private int getRightIndex(final List<Integer> a, int b) {
		    
		    if(a == null || a.size() == 0) {
		        return -1;
		    }
		    
		    int size = a.size();
		    int low = 0;
		    int high = size;
		    int result = -1;
		  
		    while(low <= high) {
		    	
		    	int mid = low + (high - low)/2;
		        int mid_element = a.get(mid);
		        
		        if(mid_element == b) {
		            result = mid;
		            low = mid + 1;
		        } else if(mid_element < b) {
		            low = mid + 1;
		        } else {
		            high = mid - 1;
		        }
		        
		    }
		    
		    return result;
		}
		
		public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		    
		    if(a == null || a.size() == 0) {
		        return null;
		    }
		    
		    int lIndex = getLeftIndex(a, b);
		    int rIndex = getRightIndex(a, b);
		    
		    System.out.println("Left index -> " + lIndex);
		    System.out.println("Right index -> " + rIndex);
		    
		    ArrayList<Integer> result = new ArrayList<Integer>();
		    
		    if(rIndex > lIndex && (a.get(lIndex) == b) && (a.get(rIndex) == b)) {
		        result.add(lIndex);
		        result.add(rIndex);
		    }
		    
		    return result;
		    
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(7);
		list.add(7);
		
		Solution s = new Solution();
		list = s.searchRange(list, 5);

	}

}
